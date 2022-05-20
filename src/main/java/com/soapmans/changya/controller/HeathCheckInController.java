package com.soapmans.changya.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.soapmans.changya.service.HeathCheckInService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/heathCheckIn")
@RestController
public class HeathCheckInController {

    @Resource
    HeathCheckInService heathCheckInService;

    @GetMapping("/checkIn")
    public String heathCheckIn() throws UnirestException {
        return heathCheckInService.heathCheckIn();
    }

}
