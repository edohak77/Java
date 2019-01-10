package instigate.tic_tac_toe.lib;

import instigate.tic_tac_toe.interfaces.ToeGO;

public class ToeComp implements ToeGO {
    private static String[][]table;
    private static String mySimbol;
    private static String userSimbol;

    public static void setTable(String[][] table) {
        ToeComp.table = table;
    }

    public static void setMySimbol(String mySimbol) {
        ToeComp.mySimbol = mySimbol;
    }

    public static void setUserSimbol(String userSimbol) {
        ToeComp.userSimbol = userSimbol;
    }


    public ToeComp() {
    }

    @Override
    public void go(String[][] matrix) {
        System.out.println("Comp is go!");
        int[]point = getCompLocisticpoint(table);
        table[point[0]][point[1]] = mySimbol;
    }

    private int[] getCompLocisticpoint(String[][] tab){
        tab = table;
        int point[];
        CompLogisticAnalizer logic = new CompLogisticAnalizer();

        point = logic.compLocicalAnalize(tab,mySimbol,userSimbol);

        return point;

    }
}
