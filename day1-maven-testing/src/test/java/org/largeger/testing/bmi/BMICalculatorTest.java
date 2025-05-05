package org.largeger.testing.bmi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    private BMICalculator normalWeight;
    private BMICalculator overWeight;
    private BMICalculator obese;
    private BMICalculator underWeight;

    @BeforeEach
    void setUp() {
        normalWeight = new BMICalculator(1.80, 70);
        overWeight = new BMICalculator(1.70, 80);
        obese = new BMICalculator(1.60, 120);
        underWeight = new BMICalculator(1.75, 50);
    }

    @Test
    void calculateBMI() {
        assertEquals(21.6, normalWeight.calculateBMI(), 0.1);
        assertEquals(27.7, overWeight.calculateBMI(), 0.1);
        assertEquals(46.9, obese.calculateBMI(), 0.1);
        assertEquals(16.3, underWeight.calculateBMI(), 0.1);
    }

    @Test
    void getBMIClassification() {
        assertEquals("Normalgewicht", normalWeight.getBMIClassification());
        assertEquals("Übergewicht", overWeight.getBMIClassification());
        assertEquals("Adipositas", obese.getBMIClassification());
        assertEquals("Untergewicht", underWeight.getBMIClassification());
    }

    @Test
    void weightDifferenceToIdeal() {
        assertEquals(0, normalWeight.weightDifferenceToIdeal(), 0.1);
        assertEquals(80 - overWeight.calculateIdealWeight(), overWeight.weightDifferenceToIdeal(), 0.1);
        assertEquals(120 - (25 * 1.6 * 1.6), obese.weightDifferenceToIdeal(), 0.1);
        assertEquals(50 - (18.5 * 1.75 * 1.75), underWeight.weightDifferenceToIdeal(), 0.1);
    }

    @Test
    void calculateIdealWeight() {
        assertEquals(70.0, normalWeight.calculateIdealWeight(), 0.1);
        assertEquals(72.25, overWeight.calculateIdealWeight(), 0.1);
        assertEquals(64.0, obese.calculateIdealWeight(), 0.1);
        assertEquals(18.5 * 1.75 * 1.75, underWeight.calculateIdealWeight(), 0.1);
    }
}
