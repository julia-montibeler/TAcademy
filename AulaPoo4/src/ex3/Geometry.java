package ex3;

public class Geometry {
    public static double squareArea(double width) {
        return width*width;
    }

    public static double rectangleArea(double width, double height) {
        return width*height;
    }

    public static double circleArea(double radius) {
        return Math.PI*radius*radius;
    }

    public static double triangleArea(double width, double height) {
        return (width*height)/2;
    }

    public static double cubeArea(double width) {
        return width*width*width;
    }

    public static double parallelepipedArea(double width, double height, double length) {
        return width*height*length;
    }

    public static double trapezeArea(double height, double a, double b) {
        return ((a+b)*height)/2;
    }

    public static double sphereArea(double radius) {
        return Math.PI*radius*radius*4;
    }

}
