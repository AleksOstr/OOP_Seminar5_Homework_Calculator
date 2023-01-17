package controller;

import model.ComplexCalc;
import model.Num;

public class ComplexController {
    private ComplexCalc compCalc;

    public ComplexController(ComplexCalc compCalc) {
        this.compCalc = compCalc;
    }

    private Num.Complex parseStringToComplex(String input) {
        String str = input.replace("i", "");
        String[] complex = str.split(" ");
        if (input.contains("i") && complex.length == 1) {
            return new Num.Complex(0, Double.parseDouble(complex[0]));
        } else if (!input.contains("i") && complex.length == 1) {
            return new Num.Complex(Double.parseDouble(complex[0]), 0);
        }
        return new Num.Complex(Double.parseDouble(complex[0]), Double.parseDouble(complex[1]));
    }

    public Num.Complex sum(String input1, String input2) {
        Num.Complex complex1 = parseStringToComplex(input1);
        Num.Complex complex2 = parseStringToComplex(input2);
        return compCalc.sum(complex1, complex2);
    }

    public Num.Complex diff(String input1, String input2) {
        Num.Complex complex1 = parseStringToComplex(input1);
        Num.Complex complex2 = parseStringToComplex(input2);
        return compCalc.diff(complex1, complex2);
    }

    public Num.Complex mult(String input1, String input2) {
        Num.Complex complex1 = parseStringToComplex(input1);
        Num.Complex complex2 = parseStringToComplex(input2);
        return compCalc.mult(complex1, complex2);
    }

    public Num.Complex div(String input1, String input2) {
        Num.Complex complex1 = parseStringToComplex(input1);
        Num.Complex complex2 = parseStringToComplex(input2);
        return compCalc.div(complex1, complex2);
    }

    public void validateDivider(String input) throws Exception {
        Num.Complex complex = parseStringToComplex(input);
        double real = complex.getRealPart();
        double imag = complex.getImaginaryPart();
        if ((real * real + imag * imag) != 0) {
            return;
        }
        throw new Exception("Divider can't be 0");
    }
}
