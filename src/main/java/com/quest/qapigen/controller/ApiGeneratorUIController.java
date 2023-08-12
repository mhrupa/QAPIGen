package com.quest.qapigen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiGeneratorUIController {
    
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/apicgen")
    public String getAPICgen() {
        return "apicgen";
    }

    
}
