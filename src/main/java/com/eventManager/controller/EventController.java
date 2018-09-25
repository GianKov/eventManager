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
//Controller for handling events
public class EventController {

    @Autowired
    private EventDao evDao;

    //Mapping for getting every event list
    @RequestMapping("/eventList")
    public String getEvLis(Model model){
        List<Event> events=evDao.getEventList();
        model.addAttribute("events",events);
        return "eventList";
    }

    //Mapping for getting list given an input
    @RequestMapping(value="/research",method=RequestMethod.POST)
    public String getEvRes(@RequestParam("search")String searchd, Model model){
        List<Event> events=evDao.getEventListByName(searchd);
        //If the research didn't give any result an error will be displayed
        if(events.isEmpty())
            model.addAttribute("Failure","Nessun evento trovato, prova con un nuovo input!");
        model.addAttribute("events",events);
        return "eventList";
    }

    //Mapping for getting description of an event
    @RequestMapping(value="/description",method=RequestMethod.POST)
        public String getEvDesc(@RequestParam("id")String idTS, Model model){
            List <Sector> sectors = evDao.getSectorList(idTS);
            Event evento=evDao.getEventByID(idTS);
            model.addAttribute("eventotr",evento);
            model.addAttribute("sectors",sectors);
            return "eventDesc";
        }


}
