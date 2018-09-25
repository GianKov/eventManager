package com.eventManager.dao;

import com.eventManager.model.User;

public interface UserDao {
    //Interface methods to expand

    //Returning user model if its in the db
    User checkLogin (String email, String password);
    //Method for adding new user into db returns boolean if teh operation is or isnt completed
    boolean registerNewUser(String name, String surname, String birthDate, String Address, String email, String password, String password2);
}
