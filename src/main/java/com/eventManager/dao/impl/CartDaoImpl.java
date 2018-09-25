package com.eventManager.dao.impl;

import com.eventManager.QRCodeGenerator;
import com.eventManager.dao.CartDao;
import com.eventManager.model.Ticket;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CartDaoImpl implements CartDao {
    public boolean addToCart(String userId, String sectorId, Integer qty, String idEve) {
        //Database operation objects
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        PreparedStatement prepStat2 = null;
        Integer count = 0;
        boolean check = true;
        for (Integer i = 0; i < qty; i++) {
            //Checking that user hasn't bought more than 7tickets for the event desired
            try {
                String sql2 = "SELECT COUNT(biglietto.id) FROM BIGLIETTO JOIN SETTORE ON biglietto.settoreid=settore.idsettore WHERE settore.idevento=? AND CARTID=?";
                prepStat2 = con.prepareStatement(sql2);
                prepStat2.setString(1, idEve);
                prepStat2.setString(2, userId);
                ResultSet rs = prepStat2.executeQuery();
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (count > 6)
                return false;
            //If condition is false then the ticket can be add to cart
            else {
                try {
                    String sql = "INSERT INTO BIGLIETTO (SETTOREID,STATO,CARTID) VALUES (?,?,?)";
                    prepStat = con.prepareStatement(sql);
                    prepStat.setString(1, sectorId);
                    prepStat.setString(2, "ATTESA");
                    prepStat.setString(3, userId);
                    Integer j = prepStat.executeUpdate();
                    if (j < 0) {
                        check = false;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return check;
    }

    public List<Ticket> getAllTick(String userId, String Stato) {
        //Database operation objects
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        List<Ticket> tickSummary = new ArrayList<Ticket>();
        //Object for genereting qrcodes
        QRCodeGenerator qrgen = new QRCodeGenerator();
        try {
            String sql = "SELECT BIGLIETTO.ID AS ID,SETTORE.PREZZO,EVENTO.NOME AS EVNAME,EVENTO.LUOGO,EVENTO.DATA,SETTORE.NOME AS SECNAME FROM BIGLIETTO INNER JOIN SETTORE ON settoreid=settore.idsettore INNER JOIN EVENTO ON settore.idevento=evento.id WHERE CARTID=? AND STATO=?";
            prepStat = con.prepareStatement(sql);
            prepStat.setString(1, userId);
            prepStat.setString(2, Stato);
            rs = prepStat.executeQuery();
            while (rs.next()) {
                Ticket ticktoshow = new Ticket();
                ticktoshow.setEventName(rs.getString("EVNAME"));
                ticktoshow.setSecName(rs.getString("SECNAME"));
                ticktoshow.setDate(rs.getString("DATA"));
                ticktoshow.setPrice(rs.getFloat("PREZZO"));
                ticktoshow.setPlace(rs.getString("LUOGO"));
                ticktoshow.setId(rs.getString("ID"));
                ticktoshow.setQrImage(qrgen.getQRCodeByString(ticktoshow.getId()));
                tickSummary.add(ticktoshow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return tickSummary;
    }

    public boolean deleteTick(String idTick) {
        //Database operation objects
        boolean check = true;
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {
            String sql = "DELETE FROM BIGLIETTO WHERE ID=?";
            prepStat = con.prepareStatement(sql);
            prepStat.setString(1, idTick);
            Integer i = prepStat.executeUpdate();
            if (i < 1)
                check = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean confBoughtTickets(String userID) {
        //Database operation objects
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        List<Ticket> tickSummary = new ArrayList<Ticket>();
        boolean check = true;
        //Getting current date, formatting it and passing it to query
        Date data = new Date();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(data);
        try {
            String sql = "UPDATE BIGLIETTO SET STATO='ACQUISTATO', ACQDATA=? WHERE CARTID=? AND STATO='ATTESA' ";
            prepStat = con.prepareStatement(sql);
            prepStat.setDate(1, java.sql.Date.valueOf(date));
            prepStat.setString(2, userID);
            Integer i = prepStat.executeUpdate();
            if (i < 1)
                check = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
