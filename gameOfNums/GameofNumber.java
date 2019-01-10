package instigate.gameOfNums;

import java.util.ArrayList;
import java.util.Scanner;

public class GameofNumber {

    public static int gameEndNumber;
    public static int gameStartNumber = 0;
    private static ArrayList<Integer> winNumbers;

    public static void main(String[] args) throws InterruptedException {
        gameWelcome();

    }

    private static void gameWelcome() throws InterruptedException {
        System.out.println("==========================");
        System.out.println("||--- Welcome to Game---||");
        System.out.println("==========================");
        System.out.println("> choose from the menu");
        System.out.println("-----------------------------");
        System.out.println("> Press: 1 -> StartTerminal : 0 -> exit");
        Scanner scanner = new Scanner(System.in);
        Integer startMenu = -1;

        while (!isValidChooseStartMenu(startMenu)) {
            System.out.println("> Please enter a coorect command!");
            startMenu = scanner.nextInt();
        }

        switch (startMenu) {
            case 1:
                startGame();
                break;
            case 0:
                return;

        }

    }

    private static boolean isValidChooseStartMenu(int startMenu) {
        if (startMenu == 1 || startMenu == 0) return true;
        return false;
    }

    private static void startGame() throws InterruptedException {
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("> Thanks for gaming with me. Game is started at feu minute:");
        System.out.println("> want you to play first ?");
        String choose = "";
        Scanner scanner = new Scanner(System.in);
        while (!isValidChooseFirstGaming(choose)) {
            System.out.println("> Press y/n");
            choose = scanner.nextLine();
        }

        switch (choose) {
            case "n":
                gameEndNumber = compSaeRandomNumber();
                compPlay();
                break;
            case "y":
                gameEndNumber = compSaeRandomNumber();
                userPlay();
                break;
        }
    }

    private static boolean isValidChooseFirstGaming(String choose) {
        if (choose.equals("y") || choose.equals("n") || choose.equals("Y") || choose.equals("N")) return true;
        return false;
    }

    private static int compSaeRandomNumber() {
        int randNum = (int) rnd(21, 50);
        System.out.println("I sae a random number is: " + randNum);
        winNumbers = new ArrayList<>();
        int temp = randNum-1;
        while (temp >=0) {
            winNumbers.add(temp);
            temp -= 4;
        }
//        for (int i = 0; i < winNumbers.size(); i++) {
//            System.out.print(winNumbers.get(i) + " ");
//        }
//        System.out.println();
        return randNum;
    }

    private static void userPlay() throws InterruptedException {
        if (gameStartNumber < gameEndNumber) {
            System.out.println(" OUR SUM to this minute: " + gameStartNumber + " GRAND NUMBER IS: " + gameEndNumber);
            System.out.println("================================");
            Scanner scanner = new Scanner(System.in);
            int choose = 0;

            while (!isValidUserPlayChoose(choose)) {
                System.out.println("> Please choose from 1,2, or 3");
                choose = scanner.nextInt();
            }

            gameStartNumber += choose;
            System.out.println("********************************");
            compPlay();
        } else {
            System.out.println("GRAND NUMBER IS: " + gameEndNumber);
            System.out.println("You WIN !!!");
            return;
        }
    }

    private static boolean isValidUserPlayChoose(int choose) {
        if (choose == 1 || choose == 2 || choose == 3) return true;
        return false;
    }

    private static void compPlay() throws InterruptedException {
        if (gameStartNumber < gameEndNumber) {
            System.out.println(" OUR SUM to this minute: " + gameStartNumber + " GRAND NUMBER IS: " + gameEndNumber);
            System.out.println("==================================================");
            System.out.println("> Please take me a feu minutes for think");
            int count = (int) rnd(2,15);
            for (int i = 0; i < count; i++) {
                System.out.print('.');
                Thread.sleep(350);
            }
            System.out.println();
            System.out.println("OK!, I will make this move");
            int sum = aiToWin();
            gameStartNumber += sum;
            System.out.println("I choose " + sum);
            System.out.println("and You ???");
            System.out.println("---------------------------");
            userPlay();
        } else {
            System.out.println("    GRAND NUMBER IS: " + gameStartNumber);
            System.out.println("#### You Lost ####");
            return;
        }
    }

    private static int aiToWin() {
        int sum = 1;
            for (int i = winNumbers.size() - 1, j = winNumbers.size() - 2; i > 0; i--, j--) {
                if (gameStartNumber > winNumbers.get(i) && gameStartNumber < winNumbers.get(j)) {
//                    System.out.println("gamestartNumber = " + gameStartNumber +
//                                        " : i = " + winNumbers.get(i) +
//                                        " : j = " + winNumbers.get(j));
                    int temp = winNumbers.get(j) - gameStartNumber;
                    sum = temp;
//                    System.out.println("sum = " + sum);
                    System.out.println("-----------------------");
                    return sum;
                }
            }

        return sum;
    }

    public static long rnd(long min, long max) {
        max -= min;
        return (long) (Math.random() * ++max) + min;
    }
}
