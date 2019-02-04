package com.eventManager.test;

import com.eventManager.dao.impl.UserDaoImpl;
import com.eventManager.model.User;
import org.junit.After;
import org.junit.Test;
import org.springframework.test.annotation.Repeat;

import java.security.SecureRandom;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class UserDaoImplTest {

    UserDaoImpl dao = new UserDaoImpl();

    String randomString( int len ){
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    User newUser(){
        User utente = new User();
        utente.setEmail(randomString(10)+"@"+randomString(3)+".com");
        utente.setNome(randomString(10));
        utente.setCognome(randomString(10));
        utente.setPassword(randomString(10));
        utente.setIndirizzo(randomString(10));
        utente.setDataN(randomString(10));
        return utente;
    }

    @Test
    //Testing adding a new user, boolean value should be true
    public void testRegisterNewUser() {
        //for(int i=0;i<10;i++) {
            User toTest = newUser();
            boolean check = dao.registerNewUser(toTest.getNome(), toTest.getCognome(), toTest.getDataN(), toTest.getIndirizzo(), toTest.getEmail(), toTest.getPassword(), toTest.getPassword());
            assertTrue(check);
        //}
    }

    @Test
    //Testing passing different passwords, boolean value returned should be false
    public void testDifferentPassword() {
        for(int i=0;i<1000;i++) {
            User toTest = newUser();
            String password2 = randomString(10);
            if (!(password2.equals(toTest.getPassword()))) {
                boolean check = dao.registerNewUser(toTest.getNome(), toTest.getCognome(), toTest.getDataN(), toTest.getIndirizzo(), toTest.getEmail(), toTest.getPassword(), password2);
                assertFalse(check);
            }
        }
    }

    @Test
    //Testing adding a new user with existing email, boolean value returned should be false
    public void testAddAlreadyExistUser(){
        User toTest = newUser();
        toTest.setEmail("admin@live.it");
        boolean check = dao.registerNewUser(toTest.getNome(), toTest.getCognome(), toTest.getDataN(), toTest.getIndirizzo(), toTest.getEmail(), toTest.getPassword(), toTest.getPassword());
        assertFalse(check);
    }




}