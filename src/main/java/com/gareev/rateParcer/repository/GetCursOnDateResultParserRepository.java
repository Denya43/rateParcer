package com.gareev.rateParcer.repository;

import com.gareev.rateParcer.entity.Valute;
import org.springframework.stereotype.Repository;
import ru.cbr.web.GetCursOnDateXMLResponse;

@Repository
public interface GetCursOnDateResultParserRepository {

    Valute getValuteByValuteCh(String valuteCh, GetCursOnDateXMLResponse.GetCursOnDateXMLResult result) throws Exception;
    Valute getValuteByValuteCode(String valuteCode, GetCursOnDateXMLResponse.GetCursOnDateXMLResult result) throws Exception;

}
