package model;

public class FractionCalc implements Calculable<Num.Fraction>{
    @Override
    public Num.Fraction sum(Num.Fraction num1, Num.Fraction num2) {
        long numer1 = num1.getNumerator();
        long numer2 = num2.getNumerator();
        long denom1 = num1.getDenominator();
        long denom2 = num2.getDenominator();
        return new Num.Fraction(numer1 * denom2 + numer2 * denom1, denom1 * denom2).simplify();
    }

    @Override
    public Num.Fraction diff(Num.Fraction num1, Num.Fraction num2) {
        long numer1 = num1.getNumerator();
        long numer2 = num2.getNumerator();
        long denom1 = num1.getDenominator();
        long denom2 = num2.getDenominator();
        return new Num.Fraction(numer1 * denom2 - numer2 * denom1, denom1 * denom2).simplify();
    }

    @Override
    public Num.Fraction mult(Num.Fraction num1, Num.Fraction num2) {
        long numer1 = num1.getNumerator();
        long numer2 = num2.getNumerator();
        long denom1 = num1.getDenominator();
        long denom2 = num2.getDenominator();
        return new Num.Fraction(numer1 * numer2, denom1 * denom2).simplify();
    }

    @Override
    public Num.Fraction div(Num.Fraction num1, Num.Fraction num2) {
        long numer1 = num1.getNumerator();
        long numer2 = num2.getNumerator();
        long denom1 = num1.getDenominator();
        long denom2 = num2.getDenominator();
        return new Num.Fraction(numer1 * denom2, numer2 * denom1).simplify();
    }
}
