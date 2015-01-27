import static java.lang.System.*;
import java.io.*;
import java.util.*;

class jt {
    static int exit_status = 0;
    
    public static void main (String[] args) {
        File file = null;
        try {
            file = new File(args[0]);
        } catch (ArrayIndexOutOfBoundsException error) {
            error("please enter a file to write tasks to as first arguement%n");
        }

        // prints out current tasks
        if (args.length == 1) {
            node head = makeList(args[0]);
            readFile(head);
        }
        // removes task
        else if (args[1].equals("-f") || args[1].equals("-r")) {
            node head = makeList(args[0]);
            head = removeItem(Integer.parseInt(args[2]), head);
            //readFile(head);
            writeFile(head, file);
        } 
        else if (args[1].equals("-e")) {
            node head = makeList(args[0]);
            if (args.length <= 3) error("please enter a string to edit to%n");
            head = editTask(args, head, Integer.parseInt(args[2]));
            writeFile(head, file);
        }
        // adds new task
        else if (args.length > 2) {
            node head = makeList(args[0]);
            addTask(args, head);
            writeFile(head, file);
        }

        exit(exit_status);
    }

    static void error (String format, Object... args) {
        err.printf(format, args);
        exit_status = 1;
        exit(exit_status);
    }

    static void writeFile(node head, File file) {
        try {
            int taskNum = 1;
            PrintWriter writer = new PrintWriter(file);
            node curr = head;
            while (curr != null) {
                writer.printf("%d %s%n", taskNum, curr.value);
                curr = curr.link;
                taskNum++;
            }
            writer.close();
        } catch (FileNotFoundException error) {
            error("please enter a file to write to%n");
        }
    }

    static void addTask(String[] args, node head) {
        node curr = head;
        node prev = null;
        node temp = new node();
        int taskNum = 0;
        String taskString = "";
        while (curr != null) {
            prev = curr;
            curr = prev.link;
            taskNum++;
        }

        for (int i = 1; i < args.length; i++) {
            taskString += args[i];
        }

        temp.id = taskNum;
        temp.value = taskString;
        temp.link = null;
        prev.link = temp;
    }

    static node editTask(String[] args, node head, int index) {
        node curr = head;

        while(curr != null) {
            if (curr.id == index) break;

            curr = curr.link;
        }
        if (curr != null) {
            String taskString = "";
            for (int i = 3; i < args.length; i++) {
                taskString += args[i] + " ";
            }
            curr.value = taskString;
        } else {
            error("not an avaliable task to edit%n");
        }

        return head;
    }

    static node removeItem(int index, node head) {
        node curr = head;
        node prev = null;
        //for (int i = 0; i < index - 1; i++) {
        while (curr != null) {
            if (curr.id == index) break;

            prev = curr;
            curr = prev.link;
        }
        if (curr != null) {
            if (prev == null) head = curr.link;
                else          prev.link = curr.link;
        } else {
            error("not an available task index%n");
        }

        return head;
    }

    static void readFile(node curr) {
        out.printf("List%n");
        while (curr != null) {
            out.printf("%d : %s%n", curr.id, curr.value);
            curr = curr.link;
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
                temp.value = fileInput.nextLine();
                temp.link = null;
                if (tail == null) head = temp;
                            else tail.link = temp;
                tail = temp;
            }
        } catch (FileNotFoundException error) {
            error("please enter a file to write to%n");
        }

        return head;
    }
}
