package com.company;

import java.util.Scanner;

public class Task {
    private final int[] parameters = {1,2,4,2,3,1,2}; //A ... G
    private final double EPSILON = 0.001;
    public void run(){
        double [] point = {1,1,1};
        double [] der;
        do{
            System.out.println("Punkt [" + point[0] + ", " + point[1] + ", " + point[2] + "] f(x) = " + f(point[0], point[1], point[2]));
            point = new double[]{x1(point[1], point[2]), x2(point[0], point[2]), x3(point[0], point[1])};
            der = new double[]{point[0],point[1],point[2]};
        }while(isInEpsilon(der) && isInRange(point));
    }
    private boolean isInEpsilon(double[] der){
        return Math.abs(der[0])>= EPSILON && Math.abs(der[1])>= EPSILON && Math.abs(der[2])>= EPSILON;
    }
    private boolean isInRange(double[] point){
        return !Double.isInfinite(point[0]) && !Double.isInfinite(point[1]) && !Double.isInfinite(point[2]);
    }
    private double f(double x1, double x2,double x3){
        return 2 * parameters[0] * x1 * x1 + parameters[1] * x2 * x2 + parameters[2] * x3 * x3 + parameters[3] * x1 * x2 * x3 + parameters[4] * x1 + parameters[5] * x2 + parameters[6] * x3;
    }
    private double x1(double x2, double x3){
        return -x2*x3 - parameters[3]/parameters[4];
    }
    private double x2(double x1, double x3){
        return (parameters[3]*x1 * x3 + parameters[5])/parameters[3];
    }
    private double x3(double x1, double x2){
        return (parameters[3]*x1*x2 + parameters[6])/parameters[5];
    }
}
