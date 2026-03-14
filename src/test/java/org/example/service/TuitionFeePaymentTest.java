package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    //arrange
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setup(){
        tuitionFeePayment = new TuitionFeePayment();
    }

    //act & assert
    @Test
    void shouldCalculateCorrectTuitionFeeWithoutDiscount(){
        assertEquals(5000, tuitionFeePayment.calculateTuitionFee(5, 0));
    }

    @Test
    void shouldCalculateCorrectTuitionFeeWithDiscount(){
        assertEquals(4500, tuitionFeePayment.calculateTuitionFee(5, 0.10));
    }

    @Test
    void shouldMakePaymentOf600(){
        tuitionFeePayment.calculateTuitionFee(5, 0);
        tuitionFeePayment.makePayment(600);

        assertEquals(4400, tuitionFeePayment.getBalance());
    }

    @Test
    void shouldBeFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(5,0);
        tuitionFeePayment.makePayment(5000);
        assertTrue(tuitionFeePayment.isFullyPaid());
    }

    @Test
    void shouldNotBeFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(5,0);
        tuitionFeePayment.makePayment(6000);
        assertFalse(tuitionFeePayment.isFullyPaid());
    }


}