package com.eventManager.controller;


import com.eventManager.ValidatePayment;
import com.eventManager.dao.CartDao;
import com.eventManager.dao.impl.CartDaoImpl;
import com.eventManager.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/payment")

//Controller that handles payment operations
public class PaymentController {
    CartDao cartdao = new CartDaoImpl();

    //Mapping for seeing tickets to buy
    @RequestMapping("/view")
    public String getToView(HttpSession session, Model model){
        List<Ticket> summary=cartdao.getAllTick((String)session.getAttribute("user"),"ATTESA");
        //Calculating total amount to pay
        Float tot = 0.00f;
        for(Ticket tick : summary){
            tot=tot+tick.getPrice();
        }
        model.addAttribute("Total",tot);
        model.addAttribute("Summary",summary);
        return "payment";
    }

    //Mapping for validating transaction
    @RequestMapping(value="/rng",method= RequestMethod.POST)
    public String validate(HttpSession session,Model model, RedirectAttributes redirectedAttributes){
        ValidatePayment tool=new ValidatePayment();
        boolean check=tool.checkPayment(13);
        if(check) {
            boolean check2=cartdao.confBoughtTickets((String)session.getAttribute("user"));
            if(check2) {
                redirectedAttributes.addFlashAttribute("Confirm","Biglietti acquistati con successo!");
                return "redirect:/payment/resume";
            }
        }

        redirectedAttributes.addFlashAttribute("Error","Ci sono stati degli errori con il pagamento");
        return "redirect:/cart/getCart";

    }

    //Mapping for viewing tickets bought
    @RequestMapping("/resume")
    public String viewOrders(HttpSession session, Model model, RedirectAttributes redirectAttributes ){
        List<Ticket> ticksBought=cartdao.getAllTick((String)session.getAttribute("user"),"ACQUISTATO");
        if(ticksBought.isEmpty()){
            redirectAttributes.addFlashAttribute("Err","Non ci sono acquisti effettuati da visualizzare!");
            return "redirect:/";
        }
        model.addAttribute("TicketsB",ticksBought);
        return "resume";
    }
}
