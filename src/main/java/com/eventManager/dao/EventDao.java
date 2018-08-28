package com.eventManager.dao;

import com.eventManager.model.Event;

import java.util.List;

public interface EventDao {

   List<Event> getEventList();
   List<Event> getEventListByName(String res);
   Event getEventByName(String name);
   Event getEventByID(String id);

}
