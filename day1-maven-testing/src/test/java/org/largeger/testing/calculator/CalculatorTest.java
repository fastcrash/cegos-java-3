package org.largeger.testing.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Arrange
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void plus() {
        // Act
        calculator.plus(5);
        // Assert
        assertEquals(5, calculator.getResult());
    }

    @Test
    void minus() {
        // Act
        calculator.minus(3);
        // Assert
        assertEquals(-3, calculator.getResult());
    }

    @Test
    void times() {
        // Act
        calculator.times(4);
        // Assert
        assertEquals(0, calculator.getResult());
    }

    @Test
    void divided() {
        // Act
        calculator.divided(2);
        // Assert
        assertEquals(0, calculator.getResult());
    }

//    @Test
//    void divideByZero() {
//        // Act
//        assertThrows(ArithmeticException.class, () -> calculator.divided(0));
//    }
}
