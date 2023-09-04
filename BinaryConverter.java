public class BinaryConverter {
    // Method for converting binary string to decimal
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the input string contains only '0' and '1' characters
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        // Convert the binary string to decimal
        int decimal = 0; // Initialize decimal value
        int power = 0; // Initial the exponent for the conversion
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            char ch = binaryString.charAt(i);
            if (ch == '1') {
                decimal += Math.pow(2, power); // Calculate 2^power and add to the decimal value 
            }
            power++;
        }

        return decimal;
    }
// Main method for binary to decimal conversion
    public static void main(String[] args) {
        try {
            String binaryString = "1301";
            int decimalValue = bin2Dec(binaryString); // Convert binary to decimal
            System.out.println("Binary: " + binaryString);
            System.out.println("Decimal: " + decimalValue);
        } catch (BinaryFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}