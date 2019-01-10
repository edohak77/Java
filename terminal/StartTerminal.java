package instigate.terminal;

import instigate.terminal.elements.ComandMatcher;
import instigate.terminal.elements.PrintDirectory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StartTerminal {
    private static PrintDirectory printDirectory;
    private static File file ;
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        printDirectory = new PrintDirectory();
        String username  = System.getProperty("user.name");
        file =  new File("/home" + "/" + username);
        scanner = new Scanner(System.in);
        String input = "";

        while (!input.equals("exit")){
            String comandText = null;
            String tempInput = "";
            printDirectory.printMainDirectory();
            tempInput = scanner.nextLine();
            String[]splitInput = tempInput.split(" ");
            try {
                    file = ComandMatcher.matches(file, tempInput);
            } catch (Exception e) {
                System.out.println("> Uncorrect comand or file name !!!");
                continue;
            }finally {
                printDirectory.setDirectory(file);
                input = splitInput[0];
            }
        }

    }

}
