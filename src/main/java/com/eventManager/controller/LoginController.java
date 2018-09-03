package com.eventManager.controller;

import com.eventManager.dao.UserDao;
import com.eventManager.dao.impl.UserDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.String;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController{

    private UserDao UsDao= new UserDaoImpl();

    @RequestMapping("/login")
    public String Login(){
        return "Login";
    }

    @RequestMapping(value="/Log", method=RequestMethod.POST)
    public String log(@RequestParam("inputEmail")String email, @RequestParam("inputPassword")String password, Model model) {
        boolean redirect=UsDao.checkLogin(email,password);
        String err;
        if(redirect){
            return "home";
        }else{
            err="Credenziali non valide, riprova!";
            if(email.equals(""))
                err="Attenzione, il campo Email è vuoto!";
            if(password.equals(""))
                err="Attenzione, il campo Password è vuoto!";
            model.addAttribute("Errore",err);
            return "Login";
        }
    }
}