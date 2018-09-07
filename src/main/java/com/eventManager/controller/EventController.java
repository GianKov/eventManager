package com.eventManager.controller;

import com.eventManager.dao.EventDao;
import com.eventManager.dao.impl.EventDaoImpl;
import com.eventManager.model.Event;
import com.eventManager.model.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventDao evDao;

    @RequestMapping("/eventList")
    public String getEvLis(Model model){

        System.out.println("wewe");
        List<Event> events=evDao.getEventList();

        model.addAttribute("events",events);
        return "eventList";
    }

    @RequestMapping(value="/research",method=RequestMethod.POST)
    public String getEvRes(@RequestParam("search")String searchd, Model model){
        List<Event> events=evDao.getEventListByName(searchd);
        model.addAttribute("events",events);
        return "eventList";
    }

    @RequestMapping(value="/description",method=RequestMethod.POST)
        public String getEvDesc(@RequestParam("id")String idTS, Model model){
            System.out.println("L'id che mi viene passato e"+idTS);
            List <Sector> sectors = evDao.getSectorList(idTS);
            Event evento=evDao.getEventByID(idTS);
            model.addAttribute("eventotr",evento);
            model.addAttribute("sectors",sectors);
            return "eventDesc";
        }


}
