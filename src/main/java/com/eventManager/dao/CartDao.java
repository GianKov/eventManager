package com.eventManager.dao;

import com.eventManager.model.Ticket;

import java.util.List;

public interface CartDao {
    //Interface methods to expand

    //Given userid sess, sector id and qty tickets are added to the cart if certain conditions are true(check implementation)
    boolean addToCart(String userId, String sectorId, Integer qty, String idEve);
    //Retrieving every ticket not bought of a given user
    List<Ticket> getAllTick(String userId, String Stato);
    //Methods for deleting and validating tickets
    boolean deleteTick(String idTick);
    boolean confBoughtTickets(String userID);
}
