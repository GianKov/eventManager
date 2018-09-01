package com.eventManager.controller;

import java.lang.String;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class LogController {

    @RequestMapping(value="/Login", method=RequestMethod.POST)
    public String Login(){
        return "Login";
        }

    @RequestMapping(value="/registrazione", method=RequestMethod.POST)
    public String Registrazione(){
        return "registrazione";
    }
}
