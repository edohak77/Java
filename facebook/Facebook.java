package instigate.facebook;

import java.util.ArrayList;
import java.util.Scanner;

public class Facebook {
    private static ArrayList<User> dataUsers = new ArrayList<>();
    public static void main(String[] args) {
        mainMenu();
    }

    public  static void mainMenu(){
        System.out.println("*******************************");
        System.out.println("> Welcome to Facebook main page");

        System.out.println("*******************************");
        System.out.println();
        System.out.println("> What do you want to do?");
        System.out.println("> choose from the menu");
        System.out.println("=====================================");
        System.out.println("> 1 -Login your accaunt : 2 -New Registration : 3 -Exit ");
        System.out.println("------------------------------------------------------------");
        System.out.println();

        String input = "";
        Scanner scanner = new Scanner(System.in);

        while (!isValidChooseMM(input)){
            System.out.println("> Please input the correct command!");
            input = scanner.nextLine();
        }

        switch (input){
            case "1":
                loginAccaount();
            break;
            case "2":
                newRegistration();
                break;
            case "3":
                System.out.println("> Goodbye!!!");
                break;
        }


    }
    private static void loginAccaount(){
        System.out.println("Login accaount");
        System.out.println("***********************");
        System.out.println();
        System.out.println("---------------------------");
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!isValidChooseLoginM(input)){
            System.out.println("> Please enter your login or press '0' for back:");
            input = scanner.nextLine();
        }
        switch (input){
            case "0":
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                mainMenu();
                break;
                default:

                loggedMypage(input);
                 break;
        }
    }
    private static void newRegistration(){
        System.out.println("=======================");
        System.out.println("> Welcome to Facebook registration page:");
        System.out.println("=======================");
        System.out.println();
        System.out.println("> Press 1 - for regiter or 0 -for back");
        System.out.println("------------------------------------");

        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!isValidRegistrationcomand(input)){
            System.out.println("> Please input valid command");
            input = scanner.nextLine();
        }
        switch (input){
            case "0":
                System.out.println();
                mainMenu();
                break;
            case "1":
                openRegistartionForm();
                break;
        }

    }
    private static boolean isValidChooseMM(String input){

        if (input.equals("1") || input.equals("2") || input.equals("3")  ) return true;
        return false;
    }
    private static boolean isValidChooseLoginM(String input){
        if (input.equals("0") || isValidLogin(input))return true;

        System.out.println("> this login is not valid");
        return false;
    }
    private static boolean isValidLogin(String input){
        for (int i = 0; i < dataUsers.size(); i++) {
            User user = dataUsers.get(i);
            if (input.equals(user.getLogin())) return true;
        }
        return false;
    }
    private static boolean isValidRegistrationcomand(String input){
        if (input.equals("1") || input.equals("0")) return true;
        return false;
    }
    private static void openRegistartionForm(){

        String login = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("> Please enter new login");
        login = scanner.nextLine();
        while (!verifiLogin(login)){
            System.out.println("> Please enter new login");
            login = scanner.nextLine();
        }


        User user = new User();
        user.setLogin(login);
        System.out.println("> Your login is: " + login);
        System.out.println("-------------------------");

        System.out.println("> Please create password for your login");
        String pass  = scanner.nextLine();
        user.setPassword(pass);
        System.out.println("> Your password is: " + pass);
        System.out.println("-------------------------");

        System.out.println("> Please enter your name");
        String name  = scanner.nextLine();
        user.setName(name);
        System.out.println("> Your name is: " + name);
        System.out.println("-------------------------");

        System.out.println("> Please enter your surname");
        String surname  = scanner.nextLine();
        user.setSurname(surname);
        System.out.println("> Your surname is: " + surname);
        System.out.println("-------------------------");
        System.out.println();
        System.out.println();
        System.out.println("> Registration complete:");
        System.out.println("################################");
        System.out.println("> Your login: " + login);
        System.out.println("> Your fullname: " + user.getFullname());
        System.out.println("> Your password: " + pass);
        System.out.println("################################");
        System.out.println("> Go to -> Main menu");
        dataUsers.add(user);
        mainMenu();
    }
    private static boolean verifiLogin(String input){
        for (int i = 0; i < dataUsers.size(); i++) {
            User user = dataUsers.get(i);
            if (user.getLogin().equals(input)){
                System.out.println("> User with this login already exists. Please make up other login for yours accaunt");
                System.out.println();
                return false;
            }

        }
        return true;
    }
    private static void loggedMypage(String login){
        System.out.println("##############################");
        System.out.println("> Login is: " + login);
        Scanner scanner = new Scanner(System.in);
        String password = "";
        System.out.println("> Please enter password or press '0' for back");
        password = scanner.nextLine();

        while (!verifiPassword(password) || password.equals("0")){

            System.out.println("> Please enter password or press '0' for back");
            password = scanner.nextLine();
            if (password.equals("0")){
                mainMenu();
                return;
            }
        }
        System.out.println("##############################");
        itsMyPage(login, password);
    }
    private static boolean verifiPassword(String password){
        for (int i = 0; i < dataUsers.size(); i++) {
            User user = dataUsers.get(i);
            if (password.equals(user.getPassword())){
                return true;
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.println("> uncorrect password!!!!");
        System.out.println("---------------------------------------------------");
        return false;
    }
    private static void itsMyPage(String login, String password){
        User user = new User();
        for (int i = 0; i < dataUsers.size(); i++) {
            if (dataUsers.get(i).getLogin().equals(login) && dataUsers.get(i).getPassword().equals(password)){
                user = dataUsers.get(i);
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.println("> " + user.getFullname() + " welcome to your facebook page");
        System.out.println("---------------------------------------------------");

        System.out.println("> Please choise the command......");
        System.out.println("---------------------------------------------------");
        System.out.println("> 1 -send massasge : 2 -I wont see my massage : 3 -exit to Facebook main page : 0 - close the program");
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!isVerifiCommandInUserPageMenu(input)){
            input = scanner.nextLine();
        }
        switch (input){
            case "0":
                System.out.println("> Goodbye!!!");
                break;
            case "1":
                sendMassage(user);
                break;
            case "2":
                seeMyMassage(user);
                break;
            case "3":
                mainMenu();
                break;
        }
    }
    private static boolean isVerifiCommandInUserPageMenu(String input){
        if (input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3") ) return true;
        return false;
    }
    private static void sendMassage(User user){
        System.out.println("-----------------------------");
        System.out.println("> Now you can sennding massage to other Facebook accaunts");
        Scanner scanner = new Scanner(System.in);
        String input ="";
        while (!oneOrZero(input)){
            System.out.println("> Please press '1' -for create new massage or press '0' -for back");
            input = scanner.nextLine();
        }
        switch (input){
            case "0":
                itsMyPage(user.getLogin(), user.getPassword());
                break;
            case "1":
                System.out.println("> Who do you want to send massage(please enter login)");
                String toUser = "";
                toUser = scanner.nextLine();
                if (isValidLogin(toUser)){
                    User inUser = null;
                    for (int i = 0; i < dataUsers.size(); i++) {
                        if (dataUsers.get(i).getLogin().equals(toUser)){
                            inUser = dataUsers.get(i);
                        }
                    }

                    String massagetext = "";
                    System.out.println("> Enter massage text:");
                    System.out.println("-------------------");
                    massagetext = scanner.nextLine();
                    String massageAuthor = (user.getFullname() + ":");
                    inUser.addMassage(new Massage(massageAuthor, massagetext));
                    String iAuthor = "me:";
                    user.addMassage(new Massage(iAuthor,massagetext));
                }else {
                    System.out.println("> No such user exist!!!!");
                }
                sendMassage(user);

        }
    }
    private static void seeMyMassage(User user){
        System.out.println("-----------------------------");
        System.out.println("> Now you can show yours massages");
        Scanner scanner = new Scanner(System.in);
        String input ="";
        while (!oneOrZero(input)){
            System.out.println("> Please press '1' -for show massages or press '0' -for back");
            input = scanner.nextLine();
        }
        switch (input){
            case "0":
                itsMyPage(user.getLogin(), user.getPassword());
                break;
            case "1":
                ArrayList<Massage> massages = user.getMassageBox();
                for (int i = 0; i < massages.size(); i++) {
                    Massage massage = massages.get(i);
                    System.out.println("...................................");
                    System.out.println("author -> " + massage.getAuthor() + " date: " + massage.getMassagedata());
                    System.out.println("" + "\t" +" - " + massage.getMassageText());
                    System.out.println("...................................");
                }
                seeMyMassage(user);

        }
    }
    private static boolean oneOrZero(String input){
        if (input.equals("1") || input.equals("0"))return true;
        return false;
    }
}
