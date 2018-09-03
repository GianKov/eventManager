package com.eventManager.controller;

import java.lang.String;

import com.eventManager.dao.impl.UserDaoImpl;
import org.springframework.stereotype.Controller;
import com.eventManager.dao.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class RegistrationController {

    private UserDao UsDao=new UserDaoImpl();

    @RequestMapping("/registrazione")
    public String Registrazione(){ return "registrazione"; }

    @RequestMapping(value="/Register", method=RequestMethod.POST)
    public String executeRegister(@RequestParam("first_name")String first_name,@RequestParam("last_name")String last_name,@RequestParam("DataN")String DataN,@RequestParam("indirizzo")String indirizzo, @RequestParam("email")String email, @RequestParam("password")String password, @RequestParam("password_confirmation")String password_confirmation, Model model){
        String msg="mamma";
        boolean check = UsDao.registerNewUser(first_name, last_name, DataN ,indirizzo ,email ,password ,password_confirmation);
        if(!check) {
            if(first_name.equals(""))
                msg="Attenzione, il campo Nome è vuoto!";
            if(last_name.equals(""))
                msg="Attenzione, il campo Cognome è vuoto!";
            if(DataN.equals(""))
                msg="Attenzione, il campo Data di nascita è vuoto!";
            if(indirizzo.equals(""))
                msg="Attenzione, il campo Indirizzo è vuoto!";
            if(email.equals(""))
                msg="Attenzione, il campo Email è vuoto!";
            if(password.equals(""))
                msg="Attenzione, il campo Password è vuoto!";
            if(password_confirmation.equals(""))
                msg="Attenzione, il campo Conferma Password è vuoto!";
            if(!password_confirmation.equals(password))
                msg="Attenzione, la conferma della password non corrisponde!";
            model.addAttribute("Error",msg);
            return "registrazione";
        } else {
            msg="Registrazione effettuata con successo!";
            model.addAttribute("Conferma",msg);
            return "Login";
        }
    }
}
