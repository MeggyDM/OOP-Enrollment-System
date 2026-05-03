package org.example.service;

import org.example.model.Student;
import org.example.model.TuitionFeePayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionRegistration tuitionService;
    private Student testStudent;

    @BeforeEach
    void setup() {
        // We test the Service (the logic)
        tuitionService = new TuitionRegistration();
        // We need a student to hold the data
        testStudent = new Student("Test Student", "123", "IT");
    }

    @Test
    void shouldCalculateCorrectTuitionFeeWithoutDiscount() {
        // Logic check: 5 units * 1000 = 5000
        assertEquals(5000, tuitionService.calculateTuitionFee(5, 0));
    }

    @Test
    void shouldCalculateCorrectTuitionFeeWithDiscount() {
        // Logic check: 5000 - 10% = 4500
        assertEquals(4500, tuitionService.calculateTuitionFee(5, 0.10));
    }

    @Test
    void shouldMakePaymentOf600() {
        // Set the initial balance first
        double total = tuitionService.calculateTuitionFee(5, 0);
        testStudent.getTuitionDetails().setBalance(total);

        // Act
        tuitionService.makePayment(testStudent, 600);

        // Assert: 5000 - 600 = 4400
        assertEquals(4400, testStudent.getTuitionDetails().getBalance());
    }

    @Test
    void shouldBeFullyPaid() {
        testStudent.getTuitionDetails().setBalance(5000);
        tuitionService.makePayment(testStudent, 5000);

        assertTrue(tuitionService.isFullyPaid(testStudent));
    }

    @Test
    void shouldNotBeFullyPaid() {
        testStudent.getTuitionDetails().setBalance(5000);
        tuitionService.makePayment(testStudent, 1000);

        assertFalse(tuitionService.isFullyPaid(testStudent));
    }
}