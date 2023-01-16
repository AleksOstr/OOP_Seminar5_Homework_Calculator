package model;

public class Num {
    public static class Fraction extends Num {
        private long numerator;
        private long denominator;

        public Fraction(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public long getNumerator() {
            return numerator;
        }

        public long getDenominator() {
            return denominator;
        }

        @Override
        public String toString() {
            if (numerator == 0) {
                return "0";
            } else if (numerator == denominator) {
                return "1";
            }
            return String.format("%d/%d", numerator, denominator);
        }

        public Fraction simplify() {
            long limit = Math.min(Math.abs(numerator), denominator);
            for (int i = 2; i <= limit; i++) {
                if (numerator % i == 0 && denominator % i == 0) {
                    numerator /= i;
                    denominator /= i;
                }
            }
            return this;
        }
    }

    public static class Complex extends Num {
        private double realPart;
        private double imaginaryPart;

        public Complex(double realPart, double imaginaryPart) {
            this.realPart = realPart;
            this.imaginaryPart = imaginaryPart;
        }

        public double getRealPart() {
            return realPart;
        }

        public double getImaginaryPart() {
            return imaginaryPart;
        }

        @Override
        public String toString() {
            if (realPart == 0 && imaginaryPart == 0) {
                return "0";
            } else if (realPart == 0) {
                return String.format("%.2fi", imaginaryPart);
            } else if (imaginaryPart == 0) {
                return String.format("%.2f", realPart);
            } else if (imaginaryPart < 0) {
                return String.format("%.2f%.2fi", realPart, imaginaryPart);
            } else {
                return String.format("%.2f + %.2fi", realPart, imaginaryPart);
            }
        }
    }
}
