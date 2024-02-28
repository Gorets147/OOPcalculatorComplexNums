package model.operations;

import model.ComplexNumber;
import model.Operation;

public class Multiplication extends ComplexNumber implements Operation {


    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        double realResult = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imaginaryResult = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        return new ComplexNumber(realResult, imaginaryResult);
    }
}