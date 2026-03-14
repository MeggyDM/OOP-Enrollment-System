package org.example.service;

public class TuitionFeePayment {
    private final double PRICE_PER_UNIT= 1000;
    private double balance;
    private double totalTuitionFee;

    public double calculateTuitionFee(int units, double discounts){
        totalTuitionFee = units * PRICE_PER_UNIT;

        if(discounts!=0){
            totalTuitionFee= totalTuitionFee - ( totalTuitionFee * discounts);
        }

        return totalTuitionFee;
    }

    public void makePayment(double amount){
        balance = totalTuitionFee - amount;
    }

    public double getBalance(){
        return balance;
    }

    public boolean isFullyPaid(){
//        if (balance ==0){
//            return true;
//        } else {
//            return false;
//        }

        //simplified if else
        return balance == 0 && balance>0 ? true : false ;
    }




}
