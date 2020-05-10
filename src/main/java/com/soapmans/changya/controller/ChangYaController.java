package com.soapmans.changya.controller;

import com.soapmans.changya.entry.Mp3Entry;
import com.soapmans.changya.entry.ReEntry;
import com.soapmans.changya.service.ChangYaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Controller
@RequestMapping("/changya")
public class ChangYaController {

    @Resource
    ChangYaService changYaService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("entry", new ReEntry());
        return "index";
    }

    @PostMapping("/mp3")
    public String mp3(@ModelAttribute ReEntry reEntry, Model model){
        Mp3Entry entry = changYaService.getMp3Url(reEntry.getShareUrl());
        model.addAttribute("result", entry);
        return "result";
    }
}
