package com.sda.functionInterface;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        lambdaImplementation();


        Double number = 5.0;
        Double aDouble = pow2(number);
        System.out.println(aDouble);

        Double aDoubleFunction = pow2Function.apply(number);
        System.out.println(aDoubleFunction);

        double oblicz = oblicz(pow3Function, 4.0);
        System.out.println(oblicz);

    }

    private static void lambdaImplementation() {
        String title = "napis";
        System.out.println(title);

        // lambda -> tylko do interfejsu funkcyjnego
        Parenethesisable parenethesisable = x -> "\"" + x + "\"";
        System.out.println(parenethesisable.addParenethesis(title));
    }

    private static Double pow2(Double a) {
        return a * a;
    }

    private static double oblicz ( Function<Double, Double> function, double x){
        return function.apply(x);
    }
    static Function<Double, Double> pow2Function = (a) -> a*a;
    static Function<Double, Double> pow3Function = (a) -> a*a*a;

}
