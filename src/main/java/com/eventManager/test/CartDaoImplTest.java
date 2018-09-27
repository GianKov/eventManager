package com.eventManager.test;

import com.eventManager.dao.impl.CartDaoImpl;
import com.eventManager.dao.impl.DBManager;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class CartDaoImplTest {

    //Dao
    CartDaoImpl cdao = new CartDaoImpl();

    //Generating randomUserid from db
    String randomUser(){
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prpst = null;
        ResultSet rs = null;
        String sql="SELECT ID FROM UTENTE";
        List<String> utenti = new ArrayList<String>();
        try{
            prpst=con.prepareStatement(sql);
            rs=prpst.executeQuery();
            while(rs.next()){
                utenti.add(rs.getString("ID"));
            }
        }catch(SQLException e){e.printStackTrace();}
        Random rand = new Random();
        String ret=utenti.get(rand.nextInt(utenti.size()));
        return ret;
    }

    //Generating randomSectorId from db
    String randomSector(){
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prpst = null;
        ResultSet rs = null;
        String sql="SELECT IDSETTORE FROM SETTORE";
        List<String> settori = new ArrayList<String>();
        try{
            prpst=con.prepareStatement(sql);
            rs=prpst.executeQuery();
            while(rs.next()){
                settori.add(rs.getString("IDSETTORE"));
            }
        }catch(SQLException e){e.printStackTrace();}
        Random rand = new Random();
        String ret=settori.get(rand.nextInt(settori.size()));
        return ret;
    }

    //Getting right event id from sector
    String getEvId(String id){
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prpst = null;
        ResultSet rs = null;
        String sql="SELECT IDEVENTO FROM SETTORE WHERE IDSETTORE=?";
        String ret = null;
        try{
            prpst=con.prepareStatement(sql);
            prpst.setString(1,id);
            rs=prpst.executeQuery();
            while(rs.next()){
                ret=rs.getString("IDEVENTO");
            }
        }catch(SQLException e){e.printStackTrace();}
        return ret;
    }

    @Test
    //Testing adding a random ticket to a random user
    public void testAddingTicket() {
        //for(int i=0;i<2;i++) {
            String usId=randomUser();
            String secId=randomSector();
            String evId=getEvId(secId);
            boolean check=cdao.addToCart(usId,secId,1,evId);
            System.out.println("Tentativo aggiunta biglietto a userid,settoreid,eventid: "+usId+" "+secId+" "+evId+" ");
            assertTrue(check);
        //}
    }

    @Test
    //Testing adding too many tickets for a single user, max tickets purchasable by one user are 7
    public void testAddTooManyTickets(){
        String usId=randomUser();
        String secId=randomSector();
        String evId=getEvId(secId);
        //qty is set to 8
        boolean check=cdao.addToCart(usId,secId,8,evId);
        System.out.println("Tentativo aggiunta biglietto a userid,settoreid,eventid: "+usId+" "+secId+" "+evId+" ");
        assertFalse(check);
    }
}