package instigate.tic_tac_toe.lib;

public class CompLogisticAnalizer {
    private static String[][] table;
    private static String mySimbol;
    private static String userSimbol;

    public int[] compLocicalAnalize(String[][] table, String mySimbol, String userSimbol) {
        CompLogisticAnalizer.table = table;
        CompLogisticAnalizer.mySimbol = mySimbol;
        CompLogisticAnalizer.userSimbol = userSimbol;

        int[] point;
        if (pointForWin(mySimbol) != null && isValidField(pointForWin(mySimbol))) {
            point = pointForWin(mySimbol);
            return point;
        } else if (pointForWin(userSimbol) != null && isValidField(pointForWin(userSimbol))) {
            point = pointForWin(userSimbol);
            return point;
        } else {
            point = anyPoint();
        }

        return point;
    }

    private int[] anyPoint() {
        int[] point = new int[2];
        if (scanForCenter()) point = new int[]{1, 1};
        else if (table[0][0].equals(" ")) point = new int[]{0, 0};
        else if (table[0][2].equals(" ")) point = new int[]{0, 2};
        else if (table[2][0].equals(" ")) point = new int[]{2, 0};
        else if (table[2][2].equals(" ")) point = new int[]{2, 2};
        else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (table[i][j].equals(" ")) {
                        point = new int[]{i, j};
                        break;
                    }
                }
            }
        }
        return point;
    }

    private int[] pointForWin(String simbol) {
        int[] point = null;
        //horizineize
        if (table[0][0].equals(simbol) && table[0][1].equals(simbol)) point = new int[]{0, 2};
        else if (table[0][1].equals(simbol) && table[0][2].equals(simbol)) point = new int[]{0, 0};
        else if (table[0][0].equals(simbol) && table[0][2].equals(simbol)) point = new int[]{0, 1};

        else if (table[1][0].equals(simbol) && table[1][1].equals(simbol)) point = new int[]{1, 2};
        else if (table[1][1].equals(simbol) && table[1][2].equals(simbol)) point = new int[]{1, 0};
        else if (table[1][0].equals(simbol) && table[1][2].equals(simbol)) point = new int[]{1, 1};

        else if (table[2][0].equals(simbol) && table[2][1].equals(simbol)) point = new int[]{2, 2};
        else if (table[2][1].equals(simbol) && table[2][2].equals(simbol)) point = new int[]{2, 0};
        else if (table[2][0].equals(simbol) && table[2][2].equals(simbol)) point = new int[]{2, 1};

            //vertical
        else if (table[0][0].equals(simbol) && table[1][0].equals(simbol)) point = new int[]{2, 0};
        else if (table[1][0].equals(simbol) && table[2][0].equals(simbol)) point = new int[]{0, 0};
        else if (table[0][0].equals(simbol) && table[2][0].equals(simbol)) point = new int[]{1, 0};

        else if (table[0][1].equals(simbol) && table[1][1].equals(simbol)) point = new int[]{2, 1};
        else if (table[1][1].equals(simbol) && table[2][1].equals(simbol)) point = new int[]{0, 1};
        else if (table[0][1].equals(simbol) && table[2][1].equals(simbol)) point = new int[]{1, 1};

        else if (table[0][2].equals(simbol) && table[1][2].equals(simbol)) point = new int[]{2, 2};
        else if (table[1][2].equals(simbol) && table[2][2].equals(simbol)) point = new int[]{0, 2};
        else if (table[0][2].equals(simbol) && table[2][2].equals(simbol)) point = new int[]{1, 2};

            //diaganal
        else if (table[0][0].equals(simbol) && table[1][1].equals(simbol)) point = new int[]{2, 2};
        else if (table[1][1].equals(simbol) && table[2][2].equals(simbol)) point = new int[]{0, 0};
        else if (table[0][0].equals(simbol) && table[2][2].equals(simbol)) point = new int[]{1, 1};

        else if (table[0][2].equals(simbol) && table[1][1].equals(simbol)) point = new int[]{2, 0};
        else if (table[1][1].equals(simbol) && table[2][0].equals(simbol)) point = new int[]{0, 2};
        else if (table[2][0].equals(simbol) && table[0][2].equals(simbol)) point = new int[]{1, 1};

        return point;
    }

    private boolean scanForCenter() {
        if (table[1][1].equals(" ")) return true;
        return false;
    }

    private boolean isValidField(int[]point) {
        if (table[point[0]][point[1]].equals(" ")) return true;
        return false;
    }
}
