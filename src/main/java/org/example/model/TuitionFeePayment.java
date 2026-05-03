package org.example.model;

public class TuitionFeePayment {
    private double balance;
    private double totalTuitionFee;

    public TuitionFeePayment(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTotalTuitionFee() {
        return totalTuitionFee;
    }

    public void setTotalTuitionFee(double totalTuitionFee) {
        this.totalTuitionFee = totalTuitionFee;
    }
}