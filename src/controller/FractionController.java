package controller;

import model.FractionCalc;
import model.Num;

public class FractionController {
    private FractionCalc fCalc;

    public FractionController(FractionCalc fCalc) {
        this.fCalc = fCalc;
    }

    public Num.Fraction sum(String input1, String input2) {
        Num.Fraction frac1 = parseStringToFraction(input1);
        Num.Fraction frac2 = parseStringToFraction(input2);
        return fCalc.sum(frac1, frac2);
    }

    public Num.Fraction diff(String input1, String input2) {
        Num.Fraction frac1 = parseStringToFraction(input1);
        Num.Fraction frac2 = parseStringToFraction(input2);
        return fCalc.diff(frac1, frac2);
    }

    public Num.Fraction mult(String input1, String input2) {
        Num.Fraction frac1 = parseStringToFraction(input1);
        Num.Fraction frac2 = parseStringToFraction(input2);
        return fCalc.mult(frac1, frac2);
    }

    public Num.Fraction div(String input1, String input2) {
        Num.Fraction frac1 = parseStringToFraction(input1);
        Num.Fraction frac2 = parseStringToFraction(input2);
        return fCalc.div(frac1, frac2);
    }

    private Num.Fraction parseStringToFraction(String input) {
        String[] fraction = input.split("/");
        if (fraction.length == 1) {
            return new Num.Fraction(Long.parseLong(fraction[0]), 1);
        } else {
            return new Num.Fraction(Long.parseLong(fraction[0]), Long.parseLong(fraction[1]));
        }
    }

    public void validateInputFraction(String input) throws Exception {
        String[] fraction = input.split("/");
        if (fraction.length == 1 || !fraction[1].equals("0")) {
            return;
        }
        throw new Exception("Denominator can't be 0");
    }
}
