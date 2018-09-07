package com.eventManager.dao;

import com.eventManager.model.Ticket;

import java.util.List;

public interface CartDao {
    boolean addToCart(String userId, String sectorId, Integer qty);
    List<Ticket> getAllTick(String userId);

}
