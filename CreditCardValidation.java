import java.util.Scanner;
public class CreditCardValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long cardNumber = input.nextLong();

        // Check if the card number is valid
        if (isValid(cardNumber)) {
            System.out.println("The card number is valid.");
        } else {
            System.out.println("The card number is invalid.");
        }
    }

    public static boolean isValid(long number) {
        int sum = 0;
        boolean doubleDigit = false; // To keep track of whether doubling digits

        // Convert card number to a string
        String cardNumber = Long.toString(number);

        // Start from the rightmost digit (the last digit of the card number)
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i)); // Get the current digit

        if (doubleDigit) {
                digit *= 2; // Double the digit
            if (digit > 9) {
                    digit = digit % 10 + 1; // If the doubled digit is 2 digits add them together
                }
            }

            sum += digit; // Add the current digit to the running sum
            doubleDigit = !doubleDigit; // Toggle the doubleDigit flag for the next iteration
        }

        // Check if the sum is divisible by 10 and if the card type is valid
        return (sum % 10 == 0) && isValidCardType(cardNumber);
    }

    public static boolean isValidCardType(String cardNumber) {
        char firstDigit = cardNumber.charAt(0); // Get the first digit
        char secondDigit = cardNumber.charAt(1); // Get the second digit

        if (cardNumber.length() == 15 && firstDigit == '3' && (secondDigit == '4' || secondDigit == '7')) {
            return true;
        }
        else if (cardNumber.length() == 16 && firstDigit == '4') {
            return true;
        }
        else if (cardNumber.length() == 16 && firstDigit == '5' && secondDigit >= '1' && secondDigit <= '5') {
            return true;
        }
        else if (cardNumber.length() == 16 && firstDigit == '6') {
            return true;
        }

        // If none of the above conditions are met, the card type is not recognized
        return false;
    }
}
