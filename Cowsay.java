import java.util.*;

class Cowsay {
    static enum Animal { cow };
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
        Animal animal = null;

        // Calculates the length of the string inputed
        for (int i = 0; i < args.length; i++) {
            totalLength += args[i].length() + 1;
        }

        // Checks if needed string is one or multiple lines
        // and calls respective funtion
        if (totalLength > MAXLENGTH) {
            printMultipleLines(args, totalLength);
        } else {
            printSingleLine(args, animal);
        }
    }

    public static void printSingleLine(String[] words, Animal animal) {
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
        switch (animal) {
            case cow:
                printCow();
                break;
            default:
                printCow();
                break;
        }
        System.out.println();
    }
    public static void printMultipleLines(String[] words, int length) {
        // put each new line into array
        // work out the sides for the string
        // work out the top

        int currentLen = 0;
        int totalLen = 0;
        String[] lines = new String[length / MAXLENGTH + 1];
        String line = "";
        String top = " ";
        String bottom = " ";
        boolean empty = false;

        // Goes through the lines and puts them in the words array
        for (int i = 0; i < words.length; i++) {
            totalLen += words[i].length();
            currentLen += words[i].length() + 1;

            // Check for strings of 40
            if (currentLen > MAXLENGTH) {
                // puts the line in the lines array by searching
                // for the empty space
                for (int j = 0; j < lines.length; j++) {
                    if (lines[j] == null) {
                        lines[j] = line;
                        break;
                    }
                }

                line = words[i] + " ";
                currentLen = 0;
            } else {
                // otherwise just adds word to line string
                line += words[i] + " ";
            }
        }
        // Puts the line in the last index
        lines[lines.length - 1] = line;

        // What is the length of the longest line
        int lineSize = longestLine(lines);

        // sets the final line
        lines[lines.length - 1] = finalLine(lineSize, line);

        // gets the top and bottom to the correct size
        for (int i = 0; i < lineSize + 1; i++) {
            top += "_";
            bottom += "-";
        }

        // prints out the text
        System.out.print(top + "\n");
        System.out.print("/ " + finalLine(lineSize, lines[0]) + "\\\n");
        for (int i = 1; i < lines.length - 1; i++) {
            if (lines[i] == null) {
                continue;
            }
            System.out.print("| " + 
                    finalLine(lineSize, lines[i]) + "|\n");
        }
        System.out.print("\\ " + lines[lines.length - 1] + "/\n ");
        System.out.print(bottom + "\n");
        printCow();
    }

    // Gets the longest length of the array
    public static int longestLine(String[] lines) {
        int lineSize = lines[0].length();
        try {
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].length() > lineSize) {
                    lineSize = lines[i].length();
                }
            }
        } catch (NullPointerException e) {
        }
        return lineSize;
    }
    // puts the spaces needed to reach the wanted length
    public static String finalLine(int length, String line) {
        String space = "";
        try {
            for (int i = 0; i < length - line.length(); i++) {
                space += " ";
            }
        } catch (NullPointerException e) {
        }
        return line + space;
    }
}
