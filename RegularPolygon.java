public class RegularPolygon {
    private int n;          // Number of sides
    private double side;    // Length of side
    private double x;       // x-coordinate of center
    private double y;       // y-coordinate of center

    // Default constructor with no arguments
    public RegularPolygon() {
        // Calls the constructor with arguments using default values
        this(3, 1, 0, 0);
    }

    // Constructor with number of sides and length of side
    public RegularPolygon(int n, double side) {
        // Calls the constructor with all arguments, but sets x and y to default values
        this(n, side, 0, 0);
    }

    // Full constructor with all parameters
    public RegularPolygon(int n, double side, double x, double y) {
        // Assigns the values provided by the constructor to the object's data fields
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Method to calculate and return the perimeter of the polygon
    public double getPerimeter() {
        return n * side;
    }

    // Method to calculate and return the area of the polygon
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }

    // Inner class for testing the RegularPolygon class
    public static class TestRegularPolygon {
        public static void main(String[] args) {
            // Create RegularPolygon objects using different constructors
            RegularPolygon polygon1 = new RegularPolygon();
            RegularPolygon polygon2 = new RegularPolygon(6, 4);
            RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

            // Call the method to print information for each polygon
            printPolygonInfo(polygon1, "Polygon 1");
            printPolygonInfo(polygon2, "Polygon 2");
            printPolygonInfo(polygon3, "Polygon 3");
        }

        // Method to print information about a polygon
        public static void printPolygonInfo(RegularPolygon polygon, String label) {
            System.out.println(label + ":");
            System.out.println("Perimeter: " + polygon.getPerimeter());
            System.out.println("Area: " + polygon.getArea());
            System.out.println();
        }
    }
}
