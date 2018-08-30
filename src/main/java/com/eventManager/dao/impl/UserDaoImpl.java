package com.eventManager.dao.impl;

import com.eventManager.DBManager;
import com.eventManager.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean checkLogin (String email, String password){
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        return true;

    }
}
