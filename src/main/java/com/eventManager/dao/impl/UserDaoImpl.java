package com.eventManager.dao.impl;

import com.eventManager.model.User;
import com.eventManager.dao.UserDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class UserDaoImpl implements UserDao {

    @Override
    public User checkLogin (String email, String password){
        boolean check=false;
        User user = new User();
        user.setEmail("null");
        DBManager db= new DBManager();
        Connection con= db.getConnection();
        String sql = "SELECT * FROM UTENTE WHERE EMAIL LIKE ? AND PASSWORD LIKE ?";
        PreparedStatement prepStat = null;
        ResultSet rs = null;
        try {
                prepStat = con.prepareStatement(sql);
                prepStat.setString(1, email);
                prepStat.setString(2, password);
                rs = prepStat.executeQuery();
                if(!(rs.next())){

                    return user;
                }
                else{

                    user.setEmail(rs.getString("EMAIL"));
                    user.setPassword(rs.getString("PASSWORD"));
                    user.setIdUser(rs.getString("ID"));
                    user.setIndirizzo(rs.getString("INDIRIZZO"));
                    user.setNome(rs.getString("NOME"));
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try { rs.close(); } catch (Exception e) {}
                try { prepStat.close(); } catch (Exception e) {}
                try { con.close(); } catch (Exception e) {}
            }

        return user;
    }

    public boolean registerNewUser(String name, String surname, String birthDate, String Address, String email, String password, String password2){
        boolean check=false;
        if(!password.equals(password2))
            return check;
        User account = new User();
        account.setNome(name);
        account.setCognome(surname);
        account.setDataN(birthDate);
        account.setIndirizzo(Address);
        account.setEmail(email);
        account.setPassword(password);
        DBManager db= new DBManager();
        Connection con= db.getConnection();
        PreparedStatement prepStat = null;
        try {
            String sql = "INSERT INTO UTENTE (NOME, COGNOME, DATAN, INDIRIZZO, EMAIL, PASSWORD) VALUES (?,?,?,?,?,?)";
            prepStat = con.prepareStatement(sql);
            prepStat.setString(1, account.getNome());
            prepStat.setString(2, account.getCognome());
            prepStat.setString(3, account.getDataN());
            prepStat.setString(4, account.getIndirizzo());
            prepStat.setString(5, account.getEmail());
            prepStat.setString(6, account.getPassword());
            int v = prepStat.executeUpdate();
            if( v>0 )
                check=true;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            try { prepStat.close(); } catch (Exception e) {}
            try { con.close(); } catch (Exception e) {}
        }
        return check;
    }



}
