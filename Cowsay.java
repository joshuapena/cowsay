import java.util.*;

class Cowsay {
    static void printCow() {
        System.out.print("        \\   ^__^\n" +
                "         \\  (oo)\\_______\n" +
                "            (__)\\       )\\/\\\n" +
                "                 ||----w |\n" +
                "                 ||     ||\n");
    }

    public static void main(String args[]) {
        int stringLen = 0;
        String words = "< ";
        String top = " ";
        String bottom = " ";

        for (int i = 0; i < args.length; i++) {
            stringLen += args[i].length();
            words += args[i] + " ";
        }
        words += ">";

        for (int i = 0; i < stringLen + 4; i++) {
            top += "_";
            bottom += "-";
        }

        System.out.print(top + "\n");
        System.out.print(words + "\n");
        System.out.print(bottom + "\n");
        printCow();
        System.out.println();
    }
}
