package instigate.tic_tac_toe;

import java.util.Scanner;

public class TempTOE {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String input = " ";
        while (!input.equals('y') || !input.equals('n')){
            System.out.println("Do you want go to first?  (y/n)");
            input = scanner.next();
            System.out.println(input);
        }
    }
}
