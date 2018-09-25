package com.eventManager.controller;

import com.eventManager.dao.UserDao;
import com.eventManager.dao.impl.UserDaoImpl;
import com.eventManager.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.String;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
//Controller to handle login operations
public class LoginController{

    private UserDao UsDao= new UserDaoImpl();

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    //Mapping for validating login
    @RequestMapping(value="/Log", method=RequestMethod.POST)
    public String log(@RequestParam("inputEmail")String email, @RequestParam("inputPassword")String password, Model model, HttpSession session) {
        User user=UsDao.checkLogin(email,password);
        String msgToAdd="";
        if(user.getEmail().equals(email)){
            session.setAttribute("user",user.getIdUser());
            session.setAttribute("nomeUser",user.getNome());
            msgToAdd="Login effettuato correttamente";
            model.addAttribute("Error",msgToAdd);
            return "home";
        }else{
            msgToAdd="Credenziali non valide, riprova!";
            if(email.equals(""))
                msgToAdd="Attenzione, il campo Email è vuoto!";
            if(password.equals(""))
                msgToAdd="Attenzione, il campo Password è vuoto!";
            model.addAttribute("Error",msgToAdd);
            return "login";
        }
    }
}