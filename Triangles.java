public class Triangles extends GeometricObject {
    // Three sides of the triangle
    private double side1;
    private double side2;
    private double side3;

    // Constructor: Create a triangle with default sides (all set to 1.0)
    public Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    // Constructor: Create a triangle with specified sides
    public Triangle(double side1, double side2, double side3) {
        // Set the sides using provided values
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Get the length of side1
    public double getSide1() {
        return side1;
    }

    // Get the length of side2
    public double getSide2() {
        return side2;
    }

    // Get the length of side3
    public double getSide3() {
        return side3;
    }

    // Calculate and return the area of the triangle
    public double calculateArea() {
        // Use Heron's formula for area calculation
        double s = (side1 + side2 + side3) / 2; // Half of the perimeter
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Square root of the product
    }

    // Calculate and return the perimeter of the triangle
    public double calculatePerimeter() {
        // Add all sides to find the perimeter
        return side1 + side2 + side3;
    }

    // Get a string description of the triangle
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }

    public static void main(String[] args) {
        // Create a default triangle
        Triangle defaultTriangle = new Triangle();
        System.out.println("Default Triangle:");
        System.out.println("Area: " + defaultTriangle.calculateArea());
        System.out.println("Perimeter: " + defaultTriangle.calculatePerimeter());
        System.out.println(defaultTriangle);

        // Create a custom triangle
        Triangle customTriangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("\nCustom Triangle:");
        System.out.println("Area: " + customTriangle.calculateArea());
        System.out.println("Perimeter: " + customTriangle.calculatePerimeter());
        System.out.println(customTriangle);
    }
}
