import java.io.*;
import java.util.*;

public class CountKeywords {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            // Display usage message
            System.out.println("Please input a Java source file to count keywords.");
            System.exit(1);
        }

        String filename = args[0]; // Get the filename from command line
        File file = new File(filename); // Create a new file object

        if (file.exists()) {
            // If the file exists, display a message and count the keywords
            System.out.println("Counting keywords in " + filename + "...");
            int keywordCount = countKeywords(file);
            System.out.println("Number of keywords found: " + keywordCount);
        } else {
            // If the file does not exist, display an error message
            System.out.println("Error: File " + filename + " not found.");
        }
    }

    public static int countKeywords(File file) throws Exception {
        // Define an array of Java keywords + true, false, and null
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
                "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "for",
                "final", "finally", "float", "goto", "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private", "protected", "public", "return",
                "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
                "transient", "try", "void", "volatile", "while", "true", "false", "null"};

        // Create a set to store the keywords for efficient lookup
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        int count = 0; // Initialize a counter for keywords
        boolean inString = false; // Track if we are inside a string
        boolean inComment = false; // Track if we are inside a comment

        Scanner input = new Scanner(file); // Create a scanner to read the file line by line

        while (input.hasNextLine()) {
            String line = input.nextLine().trim(); // Read a line from the file and trim leading/trailing spaces

            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);

                if (!inString && currentChar == '"') {
                    inString = true;
                } else if (inString && currentChar == '"') {
                    inString = false;
                }

                if (!inString && !inComment && currentChar == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    // Detect line comment, ignore the rest of the line
                    break;
                }

                if (!inString && !inComment && currentChar == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                    // Detect block comment start
                    inComment = true;
                    i++; // Skip the '*' character
                } else if (inComment && currentChar == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    // Detect block comment end
                    inComment = false;
                    i++; // Skip the '/' character
                }

                if (!inString && !inComment && currentChar == ' ') {
                    continue; // Skip spaces
                }

                StringBuilder wordBuilder = new StringBuilder();
                while (i < line.length() && Character.isJavaIdentifierPart(line.charAt(i))) {
                    wordBuilder.append(line.charAt(i));
                    i++;
                }
                String word = wordBuilder.toString();

                if (keywordSet.contains(word)) {
                    count++; // Increment the keyword count
                }
            }
        }

        return count; // Return the total count of keywords
    }
}
