package com.eventManager.dao.impl;

import com.eventManager.DBManager;
import com.eventManager.dao.CartDao;
import com.eventManager.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    public boolean addToCart(String userId, String sectorId, Integer qty){
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        boolean check=true;
        for(Integer i=0;i<qty;i++) {
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
        return check;
    }

    public List<Ticket> getAllTick(String userId){
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs=null;
        List<Ticket> tickSummary=new ArrayList<Ticket>();
        try{
            String sql="SELECT SETTORE.PREZZO,EVENTO.NOME AS EVNAME,EVENTO.LUOGO,EVENTO.DATA,SETTORE.NOME AS SECNAME FROM BIGLIETTO INNER JOIN SETTORE ON settoreid=settore.idsettore INNER JOIN EVENTO ON settore.idevento=evento.id WHERE CARTID=?";
            prepStat=con.prepareStatement(sql);
            prepStat.setString(1,userId);
            rs=prepStat.executeQuery();
            while(rs.next()){
                Ticket ticktoshow=new Ticket();
                ticktoshow.setEventName(rs.getString("EVNAME"));
                ticktoshow.setSecName(rs.getString("SECNAME"));
                ticktoshow.setDate(rs.getString("DATA"));
                ticktoshow.setPrice(rs.getString("PREZZO"));
                ticktoshow.setPlace(rs.getString("LUOGO"));
                //restanti informazioni
                tickSummary.add(ticktoshow);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return tickSummary;
    }
}
