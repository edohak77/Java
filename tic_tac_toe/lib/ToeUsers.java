package instigate.tic_tac_toe.lib;

import instigate.tic_tac_toe.interfaces.ToeGO;

import java.util.Arrays;
import java.util.Scanner;

public class ToeUsers implements ToeGO {
    private static String[][] table;
    private static String simbol;

    public ToeUsers(String[][] table) {
        ToeUsers.table = table;
    }

    public static void setSimbol(String simbol) {
        ToeUsers.simbol = simbol;
    }

    public static String getSimbol() {
        return simbol;
    }

    @Override
    public void go(String[][] matrix) {
        System.out.println("User is go! Please select a field!!!");
        matrix = table;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            input = scanner.nextLine();
            if (isValidComand(input)) break;
        }
       setField(input);
    }

    private boolean isValidComand(String input) {
        if (!isValidInput(input)) {
            System.out.println("Uncorrect comad! Please reselect...");
            int[][] tempTable = new int[3][3];
            int in = 1;
            for (int i = 2; i >= 0; i--) {
                for (int j = 0; j < 3; j++) {
                    tempTable[i][j] = in;
                    in++;
                }
            }
            for (int k[] : tempTable) {
                for (int l : k) {
                    System.out.print("|" + l);
                }
                System.out.println("|");
                System.out.println("-------");
            }
            return false;
        }
        if (!isValidField(input)) {
            System.out.println("This field is busy.Reselect a field !!!");
            return false;
        }
        return true;
    }

    private boolean isValidField(String input) {
        switch (input) {
            case "1":
                System.out.println(table[2][0].equals(" "));
                if (table[2][0].equals(" ")) return true;
                return false;
            case "2":
                if (table[2][1].equals(" ")) return true;
                return false;
            case "3":
                if (table[2][2].equals(" ")) return true;
                return false;
            case "4":
                if (table[1][0].equals(" ")) return true;
                return false;
            case "5":
                if (table[1][1].equals(" ")) return true;
                return false;
            case "6":
                if (table[1][2].equals(" ")) return true;
                return false;
            case "7":
                if (table[0][0].equals(" ")) return true;
                return false;
            case "8":
                if (table[0][1].equals(" ")) return true;
                return false;
            case "9":
                if (table[0][2].equals(" ")) return true;
                return false;
            default:
                return false;
        }

    }

    private boolean isValidInput(String input) {
        String validString = "123456789";
        if (validString.indexOf(input) != -1) return true;
        return false;
    }

    private void setField(String input) {
        switch (input) {
            case "1":
                table[2][0] = simbol;
                return;
            case "2":
                table[2][1] = simbol;
                return;
            case "3":
                table[2][2] = simbol;
                return;
            case "4":
                table[1][0] = simbol;
                return;
            case "5":
                table[1][1] = simbol;
                return;
            case "6":
                table[1][2] = simbol;
                return;
            case "7":
                table[0][0] = simbol;
                return;
            case "8":
                table[0][1] = simbol;
                return;
            case "9":
                table[0][2] = simbol;
                return;
            default:
                return;
        }


    }
}
