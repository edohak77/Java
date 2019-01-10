package instigate.tic_tac_toe;

import instigate.tic_tac_toe.interfaces.ToeGO;
import instigate.tic_tac_toe.lib.ToeAnalizing;
import instigate.tic_tac_toe.lib.ToeComp;
import instigate.tic_tac_toe.lib.ToeUsers;

import java.util.Scanner;

public class Main {
    private static String[][]table;
    private final static String firstSimbol = "X";
    private final static String secondSimbol = "O";
    private static ToeUsers user;
    private static ToeComp comp;
    private static ToeGO first;
    private static ToeGO second;
    private static boolean userWin = false;

    public static void main(String[] args) {
        table = new String[3][3];
        table = initializeTable(table);
        showTable(table);
        comp = new ToeComp();
        comp.setTable(table);
        user = new ToeUsers(table);
        goFirst();


        while (ToeAnalizing.gameEnd(table).equals("N")){
                first.go(table);
                showTable(table);

            if (ToeAnalizing.gameEnd(table).equals("N")){
                second.go(table);
                showTable(table);
            }else if (ToeAnalizing.gameEnd(table).equals("W")){
                if (first == user) userWin = true;
            }else {
                System.out.println("Draw game...");
            }
        }
        if (userWin = true) System.out.println("You win!!!");
        else System.out.println("You lost!!!");
    }

    private static String[][] initializeTable(String[][] table){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j]=" ";
            }
        }
        return table;
    }

    private static void showTable(String[][] table){
        for (String[] arTable: table ) {
            for (String str: arTable ) {
                System.out.print("|" + str);
            }
            System.out.println("|");
            System.out.println("-------");
        }
    }

    private static void goFirst(){
        Scanner scanner =new Scanner(System.in);
        String input = "";
        while (!isValidInput(input)){
            System.out.println("Do you want go to first?  (y/n)");
            input = scanner.next();
        }
        if (input.equals("y")) {
            user.setSimbol(firstSimbol);
            comp.setMySimbol(secondSimbol);
            comp.setUserSimbol(firstSimbol);
            first = user;
            second = comp;
        }else {
            user.setSimbol(secondSimbol);
            comp.setMySimbol(firstSimbol);
            comp.setUserSimbol(secondSimbol);
            first = comp;
            second = user;
        }
    }

    private static boolean isValidInput(String input){
        if (input.equals("y") || input.equals("n")) return true;
        return false;
    }

}
