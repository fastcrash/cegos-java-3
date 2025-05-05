package org.largeger.testing.bmi;

public class BMICalculator {
    private double height; // in m
    private double weight; // in kg

    public BMICalculator(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    public String getBMIClassification() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Untergewicht";
        } else if (bmi < 25) {
            return "Normalgewicht";
        } else if (bmi < 30) {
            return "Übergewicht";
        } else {
            return "Adipositas";
        }
    }

    public double weightDifferenceToIdeal() {
        double idealWeight = calculateIdealWeight();
        return weight - idealWeight;
    }

    public double calculateIdealWeight() {
        if (getBMIClassification().equals("Untergewicht")) {
            return 18.5 * height * height;
        } else if (getBMIClassification().equals("Normalgewicht")) {
            return weight;
        } else {
            return 25 * height * height;
        }
    }
}
