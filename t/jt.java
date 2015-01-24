import static java.lang.System.*;
import java.io.*;
import java.util.*;

class jt {
    /*
    static class node {
        String value;
        int id;
        node link;
    }
    */

    public static void main (String[] args) {
        //try {
        File file = new File(args[0]);
        //} catch (ArrayIndexOutOfBoundsException error) {
            //File file = new File("temp.txt");
        //}

        if (args.length == 1) {
            node head = makeList(args[0]);
            readFile(head);
        } else if (args[1].equals("-r")) {
            out.printf("foo%n");
            node head = makeList(args[0]);
            removeItem(Integer.parseInt(args[2]), head);
            readFile(head);
        }

        // writes to file
        //writeFile(file, args);
        
        // makes list
        //node head = makeList(args[0]);

        // reads file
        //readFile(head);
    }

    static void removeItem(int index, node head) {
        node curr = head;
        node prev = null;
        for (int i = 0; i < index - 1; i++) {
            prev = curr;
            curr = prev.link;
        }
        prev.link = curr.link;
    }

    static void readFile(node curr) {
        out.printf("List%n");
        while (curr != null) {
            out.printf("%d : %s%n", curr.id, curr.value);
            curr = curr.link;
        }
    }

    static void writeFile(File file, String[] args) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (int i = 1; i < args.length; i++) {
                writer.printf("%d %s\n", i, args[i]);
            }
            writer.close();
        } catch (FileNotFoundException error) {
        }
    }

    static node makeList(String file) {
        node head = null;
        node tail = null;

        try {
            Scanner fileInput = new Scanner(new FileInputStream(file));
            while (fileInput.hasNext()) {
                node temp = new node();
                temp.id = fileInput.nextInt();
                temp.value = fileInput.next();
                temp.link = null;
                if (tail == null) head = temp;
                            else tail.link = temp;
                tail = temp;
            }
        } catch (FileNotFoundException error) {
        } catch (ArrayIndexOutOfBoundsException error) {
        }

        return head;
    }
}
