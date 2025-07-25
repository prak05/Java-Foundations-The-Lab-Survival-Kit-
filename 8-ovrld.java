import java.util.Scanner;

class Ovrld {
    void area(int x) {
        System.out.println("Area of square is " + (x * x) + " sq units");
    }

    void area(float y, float z) {
        System.out.println("Area of rectangle is " + (y * z) + " sq units");
    }

    void area(double d) {
        double s = Math.PI * d * d;
        System.out.println("Area of circle is " + s + " sq units");
    }
}

class OverloadTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ovrld ob = new Ovrld();

        System.out.println("Enter the side of the square:");
        int x = sc.nextInt();
        ob.area(x);

        System.out.println("Enter the length and breadth of the rectangle:");
        float y = sc.nextFloat();
        float z = sc.nextFloat();
        ob.area(y, z);

        System.out.println("Enter the radius of the circle:");
        double d = sc.nextDouble();
        ob.area(d);

        sc.close();
    }
}

