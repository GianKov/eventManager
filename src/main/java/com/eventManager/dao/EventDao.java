package com.eventManager.dao;

import com.eventManager.model.Event;
import com.eventManager.model.Sector;

import java.util.List;

public interface EventDao {
   //Interface methods to expand

   //Get every event in the db
   List<Event> getEventList();
   //Get events given an input
   List<Event> getEventListByName(String res);
   //Get a single event by id
   Event getEventByID(String id);
   //Get every sector given event id
   List<Sector> getSectorList(String idEv);
}
