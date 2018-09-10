package com.eventManager.controller;


import com.eventManager.ValidatePayment;
import com.eventManager.dao.CartDao;
import com.eventManager.dao.impl.CartDaoImpl;
import com.eventManager.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    CartDao cartdao = new CartDaoImpl();

    @RequestMapping("/view")
    //aggiungere totale da pagare, passare come parametro dal carrello
    public String getToView(HttpSession session, Model model){
        List<Ticket> summary=cartdao.getAllTick((String)session.getAttribute("user"),"ATTESA");
        Float tot = 0.00f;
        for(Ticket tick : summary){
            tot=tot+tick.getPrice();
        }
        model.addAttribute("Total",tot);
        model.addAttribute("Summary",summary);
        return "payment";
    }

    @RequestMapping(value="/rng",method= RequestMethod.POST)
    public String validate(HttpSession session,Model model){
        ValidatePayment tool=new ValidatePayment();
        boolean check=tool.checkPayment(13);
        if(check) {
            boolean check2=cartdao.confBoughtTickets((String)session.getAttribute("user"));
            if(check2) {
                System.out.println("Pagamento avvenuto");
                return "redirect:/payment/resume";
            }

            else
                System.out.println("Biglietti non aggiornati");
        }
        else
            System.out.println("Non avvenuto");
        return "payment";
    }

    @RequestMapping("/resume")
    public String viewOrders(HttpSession session,Model model){
        List<Ticket> ticksBought=cartdao.getAllTick((String)session.getAttribute("user"),"ACQUISTATO");
        model.addAttribute("TicketsB",ticksBought);
        return "Riepilogo";
    }
}
