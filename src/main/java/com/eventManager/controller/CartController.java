package com.eventManager.controller;


import com.eventManager.dao.CartDao;
import com.eventManager.dao.impl.CartDaoImpl;
import com.eventManager.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private CartDao cartDao=new CartDaoImpl();

    @RequestMapping(value="/aggtoCart",method= RequestMethod.POST)
    public String addTick(@RequestParam("idSec")String idSec, @RequestParam("quantita")Integer qty, @RequestParam("idEv")String idEv, HttpSession session, Model model, RedirectAttributes redirectAttributes){
        System.out.println("Al cart viene passato"+idSec+qty+idEv);
        if(session.getAttribute("user").equals("guest")) {
            model.addAttribute("Error","Per poter aggiungere elementi al carrello devi effettuare il login!");
            return "Login";
        }
        else{
            boolean check=cartDao.addToCart((String)session.getAttribute("user"),idSec,qty);
            if(check){
                redirectAttributes.addFlashAttribute("Successo","I biglietti sono stati aggiunti correttamente!");
            }

            else{
                model.addAttribute("Failure","Errore nell'aggiunta dei biglietti");
                return "redirect:/event/eventDesc";
            }

        }

        return "redirect:/event/eventList";
    }


    @RequestMapping("/getCart")
    public String retrieveCart(HttpSession session, Model model){
        List<Ticket> tickets=cartDao.getAllTick((String)session.getAttribute("user"),"ATTESA");
        model.addAttribute("tickets",tickets);
        return "cart";

    }

    @RequestMapping(value="/delTicket", method= RequestMethod.POST)
    public String deleteTicket(@RequestParam("idTick")String idTick, RedirectAttributes redirectAttributes){
        boolean check=cartDao.deleteTick(idTick);
        if(check) {
            redirectAttributes.addFlashAttribute("TickRemoved","Biglietto rimosso correttamente!");
            return "redirect:/cart/getCart";
        }
        else {
            redirectAttributes.addFlashAttribute("TickNotRemoved","Non e stato possibile rimuovere il biglietto!");
            return "redirect:/cart/getCart";
        }
    }
}
