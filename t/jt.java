import static java.lang.System.*;
import java.io.*;
import java.util.*;

class jt {
    public static void main (String[] args) {

        try {
            Scanner fileInput = new Scanner(new FileInputStream(args[0]));
            while (fileInput.hasNext()) {
                out.printf("%s\n", fileInput.next());
            }
        } catch (FileNotFoundException error) {
        } catch (ArrayIndexOutOfBoundsException error) {
        }

        try {
            File file = new File("/Users/joshuapena/mytasks/file.txt");
            PrintWriter writer = new PrintWriter(file);
            for (int i = 1; i < args.length; i++) {
                writer.printf("%s\n", args[i]);
            }
            writer.printf("EOF\n");
            writer.close();
        } catch (FileNotFoundException error) {
        }
    }
}
