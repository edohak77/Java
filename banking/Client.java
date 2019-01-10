package instigate.banking;

import java.util.ArrayList;

public class Client {
    private String name;
    private String pasport;

    ArrayList<BankCard> bankCards = new ArrayList<>();

    public Client(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", pasport='" + pasport + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getPasport() {
        return pasport;
    }
}
