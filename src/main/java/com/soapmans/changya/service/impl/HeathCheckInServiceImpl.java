package com.soapmans.changya.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.soapmans.changya.entry.HeathCheckInParam;
import com.soapmans.changya.entry.QuestionContentEntry;
import com.soapmans.changya.service.HeathCheckInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class HeathCheckInServiceImpl implements HeathCheckInService {

    private String heathUrl = String.valueOf(System.getenv("HEATH_URL"));
    private Integer source = Integer.valueOf(System.getenv("HEATH_SOURCE"));
    private String lobNumber = String.valueOf(System.getenv("HEATH_NUMBER"));
    private String userAgent = String.valueOf(System.getenv("USER_AGENT"));
    private String heathH1001 = String.valueOf(System.getenv("HEATH_H1001"));
    private String heathH1002 = String.valueOf(System.getenv("HEATH_H1002"));
    private String heathH1003 = String.valueOf(System.getenv("HEATH_H1003"));
    private String heathH1004 = String.valueOf(System.getenv("HEATH_H1004"));
    private String heathH1005 = String.valueOf(System.getenv("HEATH_H1005"));
    private String heathH1006 = String.valueOf(System.getenv("HEATH_H1006"));
    private String heathH1007 = String.valueOf(System.getenv("HEATH_H1007"));
    private String heathH1008 = String.valueOf(System.getenv("HEATH_H1008"));
    private String heathH1009 = String.valueOf(System.getenv("HEATH_H1009"));
    private String heathH1010 = String.valueOf(System.getenv("HEATH_H1010"));
    private String heathH1011 = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern(""));
    private String heathH1012 = String.valueOf(System.getenv("HEATH_H1012"));
    private String heathH1013 = String.valueOf(System.getenv("HEATH_H1013"));

    @Override
    public String heathCheckIn() throws UnirestException {
        HeathCheckInParam heathCheckInParam = HeathCheckInParam.builder()
                .questionContent(QuestionContentEntry.builder()
                        .h1001(heathH1001).h1002(heathH1002).h1003(heathH1003).h1004(heathH1004).h1005(heathH1005).h1006(heathH1006)
                        .h1007(heathH1007).h1008(heathH1008).h1009(heathH1009).h1010(heathH1010).h1011(heathH1011).h1012(heathH1012).h1013(heathH1013)
                        .build())
                .source(source)
                .lobNumber(lobNumber)
                .build();
        log.info("heathCheckIn date: {}", LocalDate.now());
        log.info("heathCheckIn param: {}", heathCheckInParam);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> result = Unirest.post(heathUrl)
                .header("User-Agent", userAgent)
                .header("Content-Type", "application/json")
                .body(heathCheckInParam)
                .asString();
        log.info("heathCheckIn result: {}", result.toString());
        return result.getBody();
    }

}
