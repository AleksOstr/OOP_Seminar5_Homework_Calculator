package model;

public interface Calculable<T extends Num> {
    T sum(T num1, T num2);
    T diff(T num1, T num2);
    T mult(T num1, T num2);
    T div(T num1, T num2);
}
