// Import the Stack class, which will help with symbol matching.
import java.util.Stack;

// Define a class named 'GroupSymCheck'.
public class GroupSymCheck {

    // This method checks if grouping symbols in the given input are correctly matched.
    public static boolean checkSymbols(String input) {
        // Create a stack to keep track of opening symbols as they are encountered.
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the input string.
        for (char character : input.toCharArray()) {
            // If the character is an opening symbol (e.g., '(', '{', '['), push it onto the stack.
            if (isOpeningSymbol(character)) {
                stack.push(character);
            } else if (isClosingSymbol(character)) {
                // If the character is a closing symbol:
                // 1. Check if the stack is empty, or
                // 2. Check if the closing symbol matches the last opening symbol on the stack.
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), character)) {
                    // If there's no matching opening symbol or the stack is empty, return false.
                    return false;
                }
            }
        }

        // If the stack is empty at the end all symbols are correctly matched.
        return stack.isEmpty();
    }

    // Helper method to check if a character is an opening symbol.
    private static boolean isOpeningSymbol(char symbol) {
        return symbol == '(' || symbol == '{' || symbol == '[';
    }

    // Helper method to check if a character is a closing symbol.
    private static boolean isClosingSymbol(char symbol) {
        return symbol == ')' || symbol == '}' || symbol == ']';
    }

    // Helper method to check if an opening and closing symbol form a matching pair.
    private static boolean isMatchingPair(char openSymbol, char closeSymbol) {
        return (openSymbol == '(' && closeSymbol == ')') ||
               (openSymbol == '{' && closeSymbol == '}') ||
               (openSymbol == '[' && closeSymbol == ']');
    }
}
