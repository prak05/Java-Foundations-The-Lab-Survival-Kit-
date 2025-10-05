import java.util.Scanner;

abstract class Shape {
    Scanner sc = new Scanner(System.in);
    double half = 0.5, area;
    final double pi = 3.14;

    abstract void printArea();
}

class Rectangle extends Shape {
    void printArea() {
        System.out.print("Enter length: ");
        double l = sc.nextDouble();
        System.out.print("Enter breadth: ");
        double b = sc.nextDouble();
        area = l * b;
        System.out.println("Area of Rectangle = " + area);
    }
}

class Triangle extends Shape {
    void printArea() {
        System.out.print("Enter base: ");
        double b = sc.nextDouble();
        System.out.print("Enter height: ");
        double h = sc.nextDouble();
        area = half * b * h;
        System.out.println("Area of Triangle = " + area);
    }
}

class Circle extends Shape {
    void printArea() {
        System.out.print("Enter radius: ");
        double r = sc.nextDouble();
        area = pi * r * r;
        System.out.println("Area of Circle = " + area);
    }
}

class MainClass {
    public static void main(String[] args) {
        Shape rect = new Rectangle();
        Shape tri = new Triangle();
        Shape circ = new Circle();

        rect.printArea();
        tri.printArea();
        circ.printArea();
    }
}

