package com.sk.employee_service;

import com.sk.employee_service.utils.Calculator;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp() {
//        Arrange
        calculator = new Calculator();
    }

    @Test
    public void multiplyTest_success() {
//        Act
        Integer result = calculator.multiply(4, 5);
//        Assert
        assertEquals(20, result);

    }
}
