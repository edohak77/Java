package instigate.facebook;

import java.util.ArrayList;

public class User {
    private String login= "";
    private String name = "";
    private String surname = "";
    private String fullname = "";
    private String password = "1111";
    private ArrayList<Massage> massageBox = new ArrayList<>();

    public User(String login, String name, String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.fullname = new String(name + " " + surname);
        this.password = "1111";
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
        fullname = new String(name + " " + surname);
    }

    public void setSurname(String surname) {
        this.surname = surname;
        fullname = new String(name + " " + surname);
    }

    public User() {
    }

    public String getFullname() {
        return fullname;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void addMassage(Massage massage){
        massageBox.add(massage);
    }

    public ArrayList<Massage> getMassageBox() {
        return massageBox;
    }
}
