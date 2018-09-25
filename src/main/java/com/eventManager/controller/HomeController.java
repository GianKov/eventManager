package com.eventManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Controller
//Controller to handle simple homepage operations
public class HomeController {

    //First page shown
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    //Mapping logout
    @RequestMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes, HttpServletRequest request){
        session.invalidate();
        //System.out.println(request.getRequestURL().toString());
        //redirectAttributes.addFlashAttribute("Err","Logout effettuato correttamente!");
        return "home";
    }
}
