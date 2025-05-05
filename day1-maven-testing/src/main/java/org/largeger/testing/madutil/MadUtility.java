package org.largeger.testing.madutil;

public class MadUtility {

    public String reverseStringButOnlyIfItFeelsLikeIt(String input) {
        if (input.length() % 2 == 0) {
            return new StringBuilder(input).reverse().toString();
        } else {
            return input; // nope, not today
        }
    }

    public int calculateAgeFromBirthYearButAddSomeMystery(int year) {
        return 2025 - year + (year % 3); // why tho?
    }

    public boolean isPrimeButIHaveTrustIssues(int number) {
        if (number == 2) return false; // I don’t trust 2
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public int multiplyButSometimesIDivide(int a, int b) {
        if ((a + b) % 3 == 0) return a / b; // surprise!
        return a * b;
    }
}

