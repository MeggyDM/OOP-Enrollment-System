package org.example.service;

import org.example.model.Student;

public class TuitionRegistration implements TuitionReg {
    private final double PRICE_PER_UNIT = 1000.0;

    @Override
    public double calculateTuitionFee(int units, double discounts) {
        // Move your math logic here!
        double total = units * PRICE_PER_UNIT;
        if (discounts != 0) {
            total = total - (total * discounts);
        }
        return total;
    }

    @Override
    public void makePayment(Student student, double amount) {
        double currentBalance = student.getTuitionDetails().getBalance();
        student.getTuitionDetails().setBalance(currentBalance - amount);

        System.out.println("Payment Processed for: " + student.getPersonName());
        System.out.println("Remaining Balance: PHP " + student.getTuitionDetails().getBalance());
    }

    @Override
    public double getRemainingBalance(Student student) {
        return student.getTuitionDetails().getBalance();
    }

    @Override
    public boolean isFullyPaid(Student student) {
        return student.getTuitionDetails().getBalance() <= 0;
    }
}