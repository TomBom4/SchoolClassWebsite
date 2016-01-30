package io.github.tombom4.webApp.tools;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Thomas Kirz, Sebastian Vogt
 * @version 1.0 22.12.2015
 */
public class QuadraticFunction {
    /**
     * Parameters of the function (abc for ax² + bx + c and ade for a(x + d)² + e
     */
    private double a, b, c, d, e;

    /**
     * The vertex of the function
     */
    Point2D.Double vertex;

    /**
     * The zeroes of the function
     */
    private double zero1;
    private double zero2;

    /**
     * * Initializes a function with a, b and c and generates d, e, the vertex and the zeroes
     *
     * @throws IllegalArgumentException if a is zero
     */
    public QuadraticFunction(double a, double b, double c) throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("a must not be 0!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        generateVertex();
        generateZero();
    }

    /**
     * @return the parameter a of the function
     */
    public double getA() {
        return a;
    }

    /**
     * @return the parameter b of the function
     */
    public double getB() {
        return b;
    }

    /**
     * @return the parameter c of the function
     */
    public double getC() {
        return c;
    }

    /**
     * @return the parameter d of the function
     */
    public double getD() {
        return d;
    }

    /**
     * @return the parameter e of the function
     */
    public double getE() {
        return e;
    }

    /**
     * Calculates y of the function for a given x
     *
     * @return y
     */
    public double getImageOf(double x) {
        return a * x * x + b * x + c;
    }

    /**
     * Gets the vertex of the function as a Point2D
     *
     * @return the vertex
     */
    public Point2D.Double getVertex() {
        return vertex;
    }

    /**
     * @return the zero 1
     */
    public double getZero1(){
        return zero1;
    }

    /**
     * @return the zero 2
     */
    public double getZero2(){
        return zero2;
    }

    /**
     * Generates the parameters d and e of the function f(x) = a(x + d)² + e
     * Used in constructor QuadraticFunction(double a, double b, double c)
     */
    private void generateVertex() {
        d =  b / (2 * a);
        e = (4 * a * c - b * b) / (4 * a);

        vertex = new Point2D.Double(-d, e);
    }

    /**
     * Generates the zeroes of the function
     */
    private void generateZero(){
        zero1 = Math.sqrt(-(e / a)) - d;
        zero2 = -Math.sqrt(-(e / a)) - d;
    }

    /**
     * Generates x-values
     */
    public double generateY(double x){
        double y = (a * (x * x)) + (b * x) + c;
        return y;
    }

    /**
     * This method returns all images of a function for an ArrayList
     * @param list the ArrayList containing Doubles to be get an image
     * @return the HashMap with x as key and y as value
     */
    public HashMap<Double, Double> getImagesOf(ArrayList<Double> list) {
        HashMap<Double, Double> images = new HashMap<>();
        list.forEach(x -> images.put(x, getImageOf(x)));
        return images;
    }

    /**
     * This method returns all images of a function with x starting with start, ending with end and
     *
     * @param start
     * @param end
     * @param step
     * @return
     * @throws IllegalArgumentException
     */
    public HashMap<Double, Double> getImagesOf(double start, double end, double step) throws IllegalArgumentException {
        ArrayList<Double> list = new ArrayList<>();
        for (double i = start; i <= end; i += step) {
            list.add(i);
        }
        return getImagesOf(list);
    }

    /**
     * Generates a string of the function like ax²+ bx + c
     * @return the string
     */
    public String toNormalString() {
        String part1, part2, part3;

        part1 = a + "x²";

        if (b > 0) {
            part2 = " + " + b + "x";
        } else if (b < 0) {
            part2 = " - " + -b + "x";
        } else {
            part2 = "";
        }

        if (c > 0) {
            part3 = " + " + c;
        } else if (c < 0) {
            part3 = " - " + -c;
        } else {
            part3 = "";
        }

        return part1 + part2 + part3;
    }

    /**
     * Generates a string of the function like a(x + d)²+ e
     * @return the string
     */
    public String toVertexString() {
        String part1, part2;
        if (d > 0) {
            part1 = a + "(x + " + d + ")²";
        } else if (d < 0) {
            part1 = a + "(x - " + -d + ")²";
        } else {
            part1 = a + "x²";
        }

        if (e > 0) {
            part2 = " + " + e;
        } else if (e < 0) {
            part2 = " - " + -e;
        } else {
            part2 = "";
        }

        return part1 + part2;
    }

    /**
     * Generates a string for the zeroes
     * @return the string
     */
    public String toZeroString(){
        if (a / e < 0) {
            return zero1 + ", " + zero2;
        } else {
            return "No zeroes";
        }
    }
}
