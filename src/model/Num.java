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
            for (int i = 2; i <= limit ; i++) {
                if (numerator % i == 0 && denominator % i == 0) {
                    numerator /= i;
                    denominator /= i;
                }
            }
            return this;
        }
    }
}
