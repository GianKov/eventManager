package com.eventManager.controller;


import com.eventManager.dao.CartDao;
import com.eventManager.dao.impl.CartDaoImpl;
import com.eventManager.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
//Controller to handle cart operations
public class CartController {

    private CartDao cartDao=new CartDaoImpl();

    //Mapping for adding to cart
    @RequestMapping(value="/aggtoCart",method= RequestMethod.POST)
    public String addTick(@RequestParam("idSec")String idSec, @RequestParam("quantita")Integer qty, @RequestParam("idEv")String idEv, HttpSession session, Model model, RedirectAttributes redirectAttributes){

        //If user isn't logged an error is displayed
        if(session.getAttribute("user").equals("guest")) {
            model.addAttribute("Error","Per poter aggiungere elementi al carrello devi effettuare il login!");
            return "login";
        }
        else{
            boolean check=cartDao.addToCart((String)session.getAttribute("user"),idSec,qty,idEv);
            if(check){
                redirectAttributes.addFlashAttribute("Successo","I biglietti sono stati aggiunti correttamente!");
            }

            else{
                redirectAttributes.addFlashAttribute("Failure","Errore, hai acquistato troppi biglietti per questo evento!");
            }

        }

        return "redirect:/event/eventList";
    }

    //Mapping for returning cart view
    @RequestMapping("/getCart")
    public String retrieveCart(HttpSession session, Model model){
        //User can't access to cart if he isn't logged
        if(session.getAttribute("user").equals("guest")) {
            model.addAttribute("Err", "Non hai effettuato l'accesso");
            return "home";
        }
        //Getting all the tickets in a list
        List<Ticket> tickets=cartDao.getAllTick((String)session.getAttribute("user"),"ATTESA");
        if(tickets.isEmpty()){
            model.addAttribute("Err", "Il tuo carrello è vuoto!");
            return "home";
        }
        model.addAttribute("tickets",tickets);
        return "cart";

    }

    //Mapping for deleting ticket from cart
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
