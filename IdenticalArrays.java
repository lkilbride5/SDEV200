import java.util.Scanner;

public class IdenticalArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first 3x3 array
        System.out.println("Enter the first 3x3 array:");
        int[][] m1 = readArray(input);

        // Prompt the user to enter the second 3x3 array
        System.out.println("Enter the second 3x3 array:");
        int[][] m2 = readArray(input);

        // Check if the two arrays are identical
        if (areIdentical(m1, m2)) {
            System.out.println("The two arrays are identical.");
        } else {
            System.out.println("The two arrays are not identical.");
        }
    }

    // Function to read a 3x3 array from the user
    public static int[][] readArray(Scanner input) {
        int[][] array = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = input.nextInt();
            }
        }
        return array;
    }

    // Function to check if two arrays are identical
    public static boolean areIdentical(int[][] m1, int[][] m2) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Compare corresponding elements of the two arrays
                if (m1[i][j] != m2[i][j]) {
                    // If any elements are not equal, the arrays are not identical
                    return false;
                }
            }
        }
        // If all elements are equal, the arrays are identical
        return true;
    }
}
