package com.gareev.rateParcer.services;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.gareev.rateParcer.entity.Valute;
import com.gareev.rateParcer.repository.GetCursOnDateResultParserRepository;
import org.apache.xerces.dom.ElementNSImpl;
import org.apache.xerces.dom.TextImpl;

import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ru.cbr.web.*;
import ru.cbr.web.GetCursOnDateResponse.GetCursOnDateResult;
import ru.cbr.web.GetCursOnDateXMLResponse.GetCursOnDateXMLResult;

@Service
public class GetCursOnDateResultParserService implements GetCursOnDateResultParserRepository {

    /*@Autowired
    private final GetCursOnDateResultParserRepository getCursOnDateResultParser;

    public GetCursOnDateResultParserService(GetCursOnDateResultParserRepository getCursOnDateResultParser) throws Exception {
        this.getCursOnDateResultParser = getCursOnDateResultParser;
    }
    */


    public Valute getValuteFromCB() throws Exception {
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();

        XMLGregorianCalendar onDate = null;
        try {
            onDate = getXMLGregorianCalendarNow();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        EnumValutesResponse.EnumValutesResult en = port.enumValutes(false);
        GetCursOnDateResult curs = port.getCursOnDate(onDate);

        onDate = port.getLatestDateTime();
        GetCursOnDateXMLResult result = port.getCursOnDateXML(onDate);
        Valute list = null;

        try {
            list = getValuteByValuteCh("USD", result);
        } catch (Exception e) {

        }
        System.out.println(list.getCurs());

        try {
            list = getValuteByValuteCode("840", result);
        } catch (Exception e) {

        }
        System.out.println(list.getCurs());

        return list;
    }

    public Valute getValuteByValuteCh(String valuteCh, GetCursOnDateXMLResult result) throws Exception{

        Valute answer = new Valute();

        List<Object> list = result.getContent();
        ElementNSImpl e = (ElementNSImpl) list.get(0);
        NodeList chCodeList =   e.getElementsByTagName("VchCode");
        int length = chCodeList.getLength();

        boolean isFound = false;
        for (int i = 0; i< length; i++){
            if (isFound) break;

            Node valuteChNode = chCodeList.item(i);
            TextImpl textimpl = (TextImpl)valuteChNode.getFirstChild();
            String chVal = textimpl.getData();

            if (chVal.equalsIgnoreCase(valuteCh)){
                isFound = true;
                Node parent = valuteChNode.getParentNode();
                NodeList nodeList = parent.getChildNodes();
                int paramLength = nodeList.getLength();

                for (int j=0; j<paramLength; j++){
                    Node currentNode = nodeList.item(j);

                    String name = currentNode.getNodeName();
                    Node currentValue = currentNode.getFirstChild();
                    String value = currentValue.getNodeValue();
                    if (name.equalsIgnoreCase("Vname")){
                        answer.setName(value);
                    }
                    if (name.equalsIgnoreCase("Vnom")){
                        answer.setNom(new BigDecimal(value));
                    }
                    if (name.equalsIgnoreCase("Vcurs")){
                        answer.setCurs(new BigDecimal(value));
                    }
                    if (name.equalsIgnoreCase("Vcode")){
                        answer.setCode(Integer.parseInt(value));
                    }
                    if (name.equalsIgnoreCase("VchCode")){
                        answer.setChCode(value);
                    }
                }
            }
        }

        return answer;

    }

    public Valute getValuteByValuteCode(String valuteCode, GetCursOnDateXMLResult result) throws Exception{

        Valute answer = new Valute();

        List<Object> list = result.getContent();
        ElementNSImpl e = (ElementNSImpl) list.get(0);
        NodeList chCodeList =   e.getElementsByTagName("Vcode");
        int length = chCodeList.getLength();

        boolean isFound = false;
        for (int i = 0; i< length; i++){
            if (isFound) break;

            Node valuteChNode = chCodeList.item(i);
            TextImpl textimpl = (TextImpl)valuteChNode.getFirstChild();
            String chVal = textimpl.getData();

            if (chVal.equalsIgnoreCase(valuteCode)){
                isFound = true;
                Node parent = valuteChNode.getParentNode();
                NodeList nodeList = parent.getChildNodes();
                int paramLength = nodeList.getLength();

                for (int j=0; j<paramLength; j++){
                    Node currentNode = nodeList.item(j);

                    String name = currentNode.getNodeName();
                    Node currentValue = currentNode.getFirstChild();
                    String value = currentValue.getNodeValue();
                    if (name.equalsIgnoreCase("Vname")){
                        answer.setName(value);
                    }
                    if (name.equalsIgnoreCase("Vnom")){
                        answer.setNom(new BigDecimal(value));
                    }
                    if (name.equalsIgnoreCase("Vcurs")){
                        answer.setCurs(new BigDecimal(value));
                    }
                    if (name.equalsIgnoreCase("Vcode")){
                        answer.setCode(Integer.parseInt(value));
                    }
                    if (name.equalsIgnoreCase("VchCode")){
                        answer.setChCode(value);
                    }
                }
            }
        }

        return answer;

    }


    public XMLGregorianCalendar getXMLGregorianCalendarNow()
            throws DatatypeConfigurationException
    {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now =
                datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        return now;
    }

}
