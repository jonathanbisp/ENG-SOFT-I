import java.util.Scanner;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();

        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "Cp850"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("VM does not support mandatory encoding UTF-8");
        }

        while (true) {
            Scanner scan = new Scanner(System.in);

            ArrayList<String> input = new ArrayList<String>(Arrays.asList(scan.nextLine().split(" ")));

            String cmd = input.get(0);
            input.remove(cmd);

            console.service(cmd, input);
        }
    }
}
