package model;

public class ComplexCalc implements Calculable<Num.Complex>{
    @Override
    public Num.Complex sum(Num.Complex num1, Num.Complex num2) {
        double real1 = num1.getRealPart();
        double real2 = num2.getRealPart();
        double imag1 = num1.getImaginaryPart();
        double imag2 = num2.getImaginaryPart();
        return new Num.Complex(real1 + real2, imag1 + imag2);
    }

    @Override
    public Num.Complex diff(Num.Complex num1, Num.Complex num2) {
        double real1 = num1.getRealPart();
        double real2 = num2.getRealPart();
        double imag1 = num1.getImaginaryPart();
        double imag2 = num2.getImaginaryPart();
        return new Num.Complex(real1 - real2, imag1 - imag2);
    }

    @Override
    public Num.Complex mult(Num.Complex num1, Num.Complex num2) {
        double real1 = num1.getRealPart();
        double real2 = num2.getRealPart();
        double imag1 = num1.getImaginaryPart();
        double imag2 = num2.getImaginaryPart();
        return new Num.Complex(real1 * real2 - imag1 * imag2, real1 * imag2 + imag1 * real2);
    }

    @Override
    public Num.Complex div(Num.Complex num1, Num.Complex num2) {
        double real1 = num1.getRealPart();
        double real2 = num2.getRealPart();
        double imag1 = num1.getImaginaryPart();
        double imag2 = num2.getImaginaryPart();
        return new Num.Complex((real1 * real2 + imag1 * imag2) / (real2 * real2 + imag2 * imag2),
                (real2 * imag1 - real1 * imag2) / (real2 * real2 + imag2 * imag2));
    }
}
