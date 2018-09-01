package com.eventManager.dao;

public interface UserDao {

    boolean checkLogin (String email, String password);
    public  boolean registerNewUser(String name, String surname, String birthDate, String Address, String email, String password, String password2);
}
