import java.util.Scanner;

public class MainDiagonalSum {

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Create a 4x4 matrix to store user input
        double[][] matrix = new double[4][4];

        // Prompt the user to enter a 4x4 matrix row by row
        System.out.println("Enter a 4-by-4 matrix row by row:");
        
        // Loop through each row and column of the matrix
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                // Read a double value from the user and store it in the matrix
                matrix[row][col] = scanner.nextDouble();
            }
        }

        // Calculate the sum of the elements on the major diagonal
        double sum = sumMajorDiagonal(matrix);
        
        // Display the result to the user
        System.out.println("Sum of the elements in the major diagonal is " + sum);

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to calculate the sum of major diagonal elements
    public static double sumMajorDiagonal(double[][] m) {
        // Initialize a variable to store the sum
        double sum = 0.0;
        
        // Loop through the rows of the matrix
        for (int i = 0; i < m.length; i++) {
            // Add the element at the current row and column index to the sum
            // Since the row and column index are the same for major diagonal elements
            sum += m[i][i];
        }
        
        // Return the calculated sum
        return sum;
    }
}
