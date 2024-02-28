package model.operations;

import model.ComplexNumber;
import model.Operation;

public class Addition implements Operation {
    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        double realResult = a.getReal() + b.getReal();
        double imaginaryResult = a.getImaginary() + b.getImaginary();
        return new ComplexNumber(realResult, imaginaryResult);
    }
}