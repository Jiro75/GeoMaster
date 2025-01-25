import java.util.Scanner;

public class Main {

    // Represents a 2D shape with methods to calculate area and perimeter.
    interface Shapes2D {
        float area();
        float perimeter();
    }

    // Represents a 3D shape with methods to calculate surface area, lateral area, and volume.
    interface Shapes3D {
        float surfaceArea();
        float lateralArea();
        float volume();
    }

    // Represents a circle
    static class Circle implements Shapes2D {
        private double r;

        Circle(double r) {
            validateInput(r, "Radius");
            this.r = r;
        }

        @Override
        public float area() {
            return (float) (Math.PI * r * r);
        }

        @Override
        public float perimeter() {
            return (float) (2 * Math.PI * r);
        }
    }

    // Represents a rectangle
    static class Rectangle implements Shapes2D {
        private double length;
        private double width;

        Rectangle(double length, double width) {
            validateInput(length, "Length");
            validateInput(width, "Width");
            this.length = length;
            this.width = width;
        }

        @Override
        public float area() {
            return (float) (length * width);
        }

        @Override
        public float perimeter() {
            return (float) (2 * (length + width));
        }
    }

    // Represents a sphere
    static class Sphere implements Shapes3D {
        private double radius;

        Sphere(double radius) {
            validateInput(radius, "Radius");
            this.radius = radius;
        }

        @Override
        public float surfaceArea() {
            return (float) (4 * Math.PI * radius * radius);
        }

        @Override
        public float lateralArea() {
            return surfaceArea();
        }

        @Override
        public float volume() {
            return (float) ((4.0 / 3.0) * Math.PI * radius * radius * radius);
        }
    }

    // Represents a cylinder
    static class Cylinder implements Shapes3D {
        private double radius;
        private double height;

        Cylinder(double radius, double height) {
            validateInput(radius, "Radius");
            validateInput(height, "Height");
            this.radius = radius;
            this.height = height;
        }

        @Override
        public float surfaceArea() {
            return (float) (2 * Math.PI * radius * (radius + height));
        }

        @Override
        public float lateralArea() {
            return (float) (2 * Math.PI * radius * height);
        }

        @Override
        public float volume() {
            return (float) (Math.PI * radius * radius * height);
        }
    }

    // Validates user input to ensure it's positive and non-zero
    private static void validateInput(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be greater than zero.");
        }
    }

    // Entry Point
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dimensions for the shapes:");

        // Rectangle
        System.out.print("Rectangle Length: ");
        double rectLength = scanner.nextDouble();
        System.out.print("Rectangle Width: ");
        double rectWidth = scanner.nextDouble();
        Shapes2D rectangle = new Rectangle(rectLength, rectWidth);
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());

        // Circle
        System.out.print("Circle Radius: ");
        double circleRadius = scanner.nextDouble();
        Shapes2D circle = new Circle(circleRadius);
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        // Sphere
        System.out.print("Sphere Radius: ");
        double sphereRadius = scanner.nextDouble();
        Shapes3D sphere = new Sphere(sphereRadius);
        System.out.println("Sphere Surface Area: " + sphere.surfaceArea());
        System.out.println("Sphere Lateral Area: " + sphere.lateralArea());
        System.out.println("Sphere Volume: " + sphere.volume());

        // Cylinder
        System.out.print("Cylinder Radius: ");
        double cylinderRadius = scanner.nextDouble();
        System.out.print("Cylinder Height: ");
        double cylinderHeight = scanner.nextDouble();
        Shapes3D cylinder = new Cylinder(cylinderRadius, cylinderHeight);
        System.out.println("Cylinder Surface Area: " + cylinder.surfaceArea());
        System.out.println("Cylinder Lateral Area: " + cylinder.lateralArea());
        System.out.println("Cylinder Volume: " + cylinder.volume());

        scanner.close();
    }
}
