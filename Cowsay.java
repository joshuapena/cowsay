import java.util.*;

class Cowsay {
    // Prints out the cow
    static void printCow() {
        System.out.print("        \\   ^__^\n" +
                "         \\  (oo)\\_______\n" +
                "            (__)\\       )\\/\\\n" +
                "                 ||----w |\n" +
                "                 ||     ||\n");
    }
    // Max length of a line should be 40
    static int MAXLENGTH = 40;

    public static void main(String args[]) {
        int totalLength = 0;

        // Calculates the length of the string inputed
        for (int i = 0; i < args.length; i++) {
            totalLength += args[i].length() + 1;
        }

        // Checks if needed string is one or multiple lines
        // and calls respective funtion
        if (totalLength > MAXLENGTH) {
            printMultipleLines(args);
        } else {
            printSingleLine(args);
        }
    }

    public static void printSingleLine(String[] words) {
        int totalLen = 0;
        String line = "< ";
        String top = " ";
        String bottom = " ";

        for (int i = 0; i < words.length; i++) {
            totalLen += words[i].length() + 1;
            line += words[i] + " ";
        }
        line += ">";

        // creates the '_' and '-' for the top and bottom layer
        for (int i = 0; i < totalLen + 1; i++) {
            top += "_";
            bottom += "-";
        }

        // Prints out the cow and words
        System.out.print(top + "\n" + line + "\n" + bottom + "\n");
        printCow();
        System.out.println();
    }
    public static void printMultipleLines(String[] words) {
        System.out.print("foo\n");

        // Check for strings of 40
        // put each new line into array
        // work out the sides for the string
        // work out the top
        /*
        int currentLen = 0;
        int totalLen = 0;
        String words = "< ";
        String top = " ";
        String bottom = " ";

        for (int i = 0; i < args.length; i++) {
            totalLen += args[i].length();
            currentLen += args[i].length() + 1;
            if (currentLen > MAXLENGTH) {
                words += "\n" + args[i];
                currentLen = 0;
            } else {
                words += args[i] + " ";
            }
            System.out.print(currentLen + "\n");
        }
        words += ">";

        for (int i = 0; i < totalLen + 4; i++) {
            top += "_";
            bottom += "-";
        }
        */

    }
}
