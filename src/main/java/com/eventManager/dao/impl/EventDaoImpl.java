package com.eventManager.dao.impl;

import com.eventManager.DBManager;
import com.eventManager.dao.EventDao;
import com.eventManager.model.Event;
import com.eventManager.model.Sector;
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

        return eventList;
    }

    @Override
    public List<Event> getEventListByName(String res){
        DBManager dbObj=new DBManager();
        List<Event> eventList = new ArrayList<Event>();
        String resU=res.toUpperCase();
        String sql = "SELECT * FROM EVENTO WHERE NOME='"+resU+"' "+"OR LUOGO='"+resU+"'";
        System.out.println(sql);
        ResultSet rs=dbObj.executeQuery(sql);
        try {
            while (rs.next()) {
                Event eventToAdd = new Event();
                eventToAdd.setIdEvent(rs.getString("ID"));
                eventToAdd.setEventName(rs.getString("NOME"));
                eventToAdd.setPlace(rs.getString("LUOGO"));
                eventToAdd.setDate(rs.getString("DATA"));
                //System.out.println(rs.getString("LUOGO")+rs.getString("NOME")+rs.getString("ID"));
                eventList.add(eventToAdd);
            }
        }catch(SQLException e){e.printStackTrace();}
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
    public List<Sector> getSectorList(String idEv){
        List <Sector> sectorList = new ArrayList<Sector>();
        DBManager dbObj=new DBManager();
        Connection con = dbObj.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try{
            String sql="SELECT * FROM SETTORE WHERE IDEVENTO=?";
            prepStat = con.prepareStatement(sql);
            prepStat.setString(1,idEv);
            rs=prepStat.executeQuery();
            while(rs.next()){
                Sector secToAdd=new Sector();
                secToAdd.setIdSector(rs.getString("IDSETTORE"));
                secToAdd.setName(rs.getString("NOME"));
                secToAdd.setPrice(rs.getString("PREZZO"));
                secToAdd.setSeatsAvail(rs.getString("POSTIDISPONIBILI"));
                sectorList.add(secToAdd);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return sectorList;
    }






}
