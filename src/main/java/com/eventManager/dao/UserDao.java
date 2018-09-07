package com.eventManager.dao;

import com.eventManager.model.User;

public interface UserDao {

    User checkLogin (String email, String password);
    boolean registerNewUser(String name, String surname, String birthDate, String Address, String email, String password, String password2);
}
