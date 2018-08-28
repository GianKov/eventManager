package com.eventManager.dao.impl;

import com.eventManager.DBManager;
import com.eventManager.dao.EventDao;
import com.eventManager.model.Event;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {



    @Override
    public List<Event> getEventList() {
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        System.out.println("Entro nel metodo");
        List<Event> eventList = new ArrayList<Event>();

        try {
            System.out.println("Entro nel try");
            String sql = "SELECT * FROM EVENTO";
            prepStat = con.prepareStatement(sql);
            rs = prepStat.executeQuery();

            while (rs.next()) {
                Event eventToAdd = new Event();
                eventToAdd.setIdEvent(rs.getString("ID"));
                eventToAdd.setEventName(rs.getString("NOME"));
                eventToAdd.setPlace(rs.getString("LUOGO"));
                eventToAdd.setDate(rs.getString("DATA"));
                //System.out.println(rs.getString("LUOGO")+rs.getString("NOME")+rs.getString("ID"));
                eventList.add(eventToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("wewe");
        for(Event evento:eventList){
            System.out.println(evento.getIdEvent());
        }
        return eventList;
    }

    @Override
    public List<Event> getEventListByName(String res){
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        System.out.println("Entro nel metodo");
        List<Event> eventList = new ArrayList<Event>();
        String resU=res.toUpperCase();

        try {
            System.out.println("Entro nel try");
            String sql = "SELECT * FROM EVENTO WHERE NOME=? OR LUOGO=?";

            prepStat = con.prepareStatement(sql);
            prepStat.setString(1,resU);
            prepStat.setString(2,resU);

            rs = prepStat.executeQuery();

            while (rs.next()) {
                Event eventToAdd = new Event();
                eventToAdd.setIdEvent(rs.getString("ID"));
                eventToAdd.setEventName(rs.getString("NOME"));
                eventToAdd.setPlace(rs.getString("LUOGO"));
                eventToAdd.setDate(rs.getString("DATA"));
                //System.out.println(rs.getString("LUOGO")+rs.getString("NOME")+rs.getString("ID"));
                eventList.add(eventToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("wewe");
        for(Event evento:eventList){
            System.out.println(evento.getIdEvent());
        }
        return eventList;


    }

    @Override
    public Event getEventByID(String id){
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        System.out.println("Entro nel metodo");
        Event evTR=new Event();

        try {
            System.out.println("Entro nel try");
            String sql = "SELECT * FROM EVENTO WHERE ID=?";

            prepStat = con.prepareStatement(sql);
            prepStat.setString(1,id);


            rs = prepStat.executeQuery();

            while (rs.next()) {

                evTR.setIdEvent(rs.getString("ID"));
                evTR.setEventName(rs.getString("NOME"));
                evTR.setPlace(rs.getString("LUOGO"));
                evTR.setDate(rs.getString("DATA"));
                System.out.println(rs.getString("LUOGO")+rs.getString("NOME")+rs.getString("DATA"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return evTR;

    }

    @Override
    public Event getEventByName(String name){
        Event event=null;
        return event;
    }




}
