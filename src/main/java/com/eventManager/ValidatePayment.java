package com.eventManager;

import java.util.Random;

public class ValidatePayment {
    private Integer transactionNumb;
    public ValidatePayment() {
        Random rand = new Random();
        this.transactionNumb=rand.nextInt(100)+1;
    }
    public boolean checkPayment(int mod){
        //Dummy control
        if(transactionNumb%mod==0)
            return false;
        else
            return true;
    }
}
