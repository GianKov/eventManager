package com.eventManager.dao;

import com.eventManager.model.Event;
import com.eventManager.model.Sector;

import java.util.List;

public interface EventDao {

   List<Event> getEventList();
   List<Event> getEventListByName(String res);
   Event getEventByID(String id);
   List<Sector> getSectorList(String idEv);
}
