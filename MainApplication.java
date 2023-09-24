// This is the starting point program.
public class MainApplication {

    // This is the main method that gets executed when program is run.
    public static void main(String[] args) {
        // Check if there is exactly one command-line argument provided.
        if (args.length != 1) {
            // If not, print a usage message and exit the program with an error code.
            System.out.println("Usage: java MainApplication <input>");
            System.exit(1); // Exit with an error code of 1.
        }

        // Get the first (and only) command-line argument, which should be the input code.
        String input = args[0];

        // Call the 'checkSymbols' method from the 'GroupSymCheck' class to check if
        // grouping symbols in the input code are correctly matched.
        if (GroupSymCheck.checkSymbols(input)) {
            // If they are correctly matched, print a message indicating success.
            System.out.println("All grouping symbols are correctly matched.");
        } else {
            // If they are not correctly matched, print an error message.
            System.out.println("Error: Unmatched grouping symbols.");
        }
    }
}
