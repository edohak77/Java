package instigate.banking;

import java.util.ArrayList;

public class Bancomat {
    public void hashviStugum(Bank bank, long cardNum){
        Bank b = bank;
        bank.hashviStugumQartov(cardNum);
    }

    public void getMoney(Bank bank, long cardNum, double money){
        Bank b = bank;
        double mon = (money + (money*2/100));
        System.out.println("Ձեր հաշվից կգանձվի միջնորդավճար 2%");
        System.out.println("-------------------------------------");
        b.getMoney(cardNum, mon);
    }
}