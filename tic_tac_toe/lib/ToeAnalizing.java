package instigate.tic_tac_toe.lib;

public class ToeAnalizing {
    private static String[][] table;

    public static String gameEnd(String[][] table){
        if (winIsGame(table)){
            return "W";
        }else if (tableIsFull(table)){
            return "F";
        }
        return "N";
    }

    private static boolean winIsGame(String[][] table){
        if (    (table[0][0].equals(table[0][1]) && table[0][1].equals(table[0][2]) && !table[0][0].equals(" ")) ||
                (table[1][0].equals(table[1][1]) && table[1][1].equals(table[1][2]) && !table[1][0].equals(" ")) ||
                (table[2][0].equals(table[2][1]) && table[2][1].equals(table[2][2]) && !table[2][0].equals(" ")) ||

                (table[0][0].equals(table[1][0]) && table[1][0].equals(table[2][0]) && !table[0][0].equals(" ")) ||
                (table[0][1].equals(table[1][1]) && table[1][1].equals(table[2][1]) && !table[0][1].equals(" ")) ||
                (table[0][2].equals(table[1][2]) && table[1][2].equals(table[2][2]) && !table[0][2].equals(" ")) ||

                (table[0][0].equals(table[1][1]) && table[1][1].equals(table[2][2]) && !table[0][0].equals(" ")) ||
                (table[0][2].equals(table[1][1]) && table[1][1].equals(table[2][0]) && !table[0][2].equals(" "))
        ) return true;
        return false;
    }
    private static boolean tableIsFull(String[][] table){
        for (String[]arTab : table ) {
            for (String str : arTab) {
                if (str.equals(" ")) return false;
            }
        }
        return true;
    }
}
