package instigate.banking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private int countHashivner = 0;
    private long bankCardNumber = 1000_0000;

    private int civCounter = 100;

    private Map<BankCard,Client> clintsMap = new HashMap<BankCard,Client>();

    public Bank(String name) {
        this.name = name;
    }

    public void addClint(Client client){
        addBanKCard(client);
    }

    private void addBanKCard(Client client){
        BankCard bankCard = new BankCard(getNewCardNumber(),getNewCiv());
        bankCard.setBankName(this.name);
        clintsMap.put(bankCard,client);
    }

    public void viewClintInfo(String passport){
       for (Map.Entry<BankCard,Client> item : clintsMap.entrySet()){
           Client cl = item.getValue();
           if (cl.getPasport().equals(passport)){
               System.out.println("- Հաճախորդի տվյալներ ։ " + cl.toString() + " : " + item.getKey().toString());
           }else {
               System.out.println("- N_\"" + passport + "\" անձնագրով հաճախորդ " + this.name +
                       " բանկում գրանցված չէ․․․");
           }
       }
    }

    private long getNewCardNumber(){
        this.bankCardNumber ++;
        return this.bankCardNumber;
    }

    private int getNewCiv(){
        this.civCounter++;
        return this.civCounter;
    }

    public void addMoney(String passport, double money){
        if(money < 0){
            System.out.println("Դուք չեք կարող մուտքագրել բացասական գումար ??????????");
            return;
        }else if (money == 0){
            System.out.println("0- ական գումար մուտքագրելը անիմաստ գործողություն է! Գործուղությունը չի կատարվել․․․");
            return;
        }
        for (Map.Entry<BankCard,Client> item : clintsMap.entrySet()){
            String pas = item.getValue().getPasport();
            double sum = item.getKey().getHashiv();
            if (pas.equals(passport)){
                sum += money;
                item.getKey().setHashiv(sum);
                return;
            }

        }
        System.out.println("- գործարք: [գումարի ավելացում հաշվին] -> N_\"" + passport + "\" անձնագրով հաճախորդ " + this.name +
                " բանկում գրանցված չէ․․․");
    }

    public void getMoney(String passport, double money){
        if(money < 0){
            System.out.println("Դուք չեք կարող ելքագրել բացասական գումար ??????????");
            return;
        }else if (money == 0){
            System.out.println("0- ական գումար ելքագրել անիմաստ գործողություն է! Գործուղությունը չի կատարվել․․․");
            return;
        }
        for (Map.Entry<BankCard,Client> item : clintsMap.entrySet()){
            Client cl = item.getValue();
            BankCard bc = item.getKey();
            String pas = cl.getPasport();
            double sum = bc.getHashiv();

            if (pas.equals(passport)){
                if (sum >= money){
                    sum -= money;
                    bc.setHashiv(sum);
                }else {
                    System.out.println("- Ձեր հաշվի վրա բավարար գումար չկա ։ գումարը հաշվի վրա ֊> " + sum);
                }
                return;
            }
        }
        System.out.println("- գործարք: [հաշվից գումարի հանում] -> N_\""
                + passport + "\" անձնագրով հաճախորդ " + this.name +
                " բանկում գրանցված չէ․․․");
    }

    public void hashviStugum(String passport){
        for (Map.Entry<BankCard,Client> item : clintsMap.entrySet()){
            Client cl = item.getValue();
            BankCard bc = item.getKey();
            String pas = cl.getPasport();
            double sum = bc.getHashiv();

            if (pas.equals(passport)){
                System.out.println("- Հաճախորդ {անուն: " + cl.getName() + ", անձնագիր: N_" + cl.getPasport()
                        + ", բանկային քարտ: N_" + bc.getCardNumber()
                        + ", գուարը հաշվի վրա: " + sum + "}");
                return;
            }
        }
        System.out.println("- [հաշվի ստւգում] -> N_\""
                + passport + "\" անձնագրով հաճախորդ " + this.name +
                " բանկում գրանցված չէ․․․");
    }

    public void hashviStugumQartov(long card){
        long num = 0;
        for (Map.Entry<BankCard,Client> item : clintsMap.entrySet()){
            Client cl = item.getValue();
            BankCard bc = item.getKey();
            String pas = cl.getPasport();
            double sum = bc.getHashiv();
            num = getClientCardNumber(pas);

            if (num == card){
                System.out.println("- Հաճախորդ {անուն: " + cl.getName() + ", անձնագիր: N_" + cl.getPasport()
                        + ", բանկային քարտ: N_" + bc.getCardNumber()
                        + ", գումարը հաշվի վրա: " + sum + "}");
                return;
            }
        }
        System.out.println("- [հաշվի ստւգում բանկային քարտով] -> N_\""
                +card + "\" բանկային քարտ " + this.name +
                " բանկում գոյություն չունի․․․");
    }

    public long getClientCardNumber(String passport){
            for (Map.Entry<BankCard,Client> item : clintsMap.entrySet()){
                Client cl = item.getValue();
                BankCard bc = item.getKey();
                String pas = cl.getPasport();
                double sum = bc.getHashiv();
                long card = bc.getCardNumber();
                if (pas.equals(passport)){

                    return card;
                }
            }
            return 0;
        }

    public Bank bank(long cradNumber){
        for (Map.Entry<BankCard, Client> item : clintsMap.entrySet()){
            BankCard bc = item.getKey();
            long number = bc.getCardNumber();
            if (number == cradNumber){
                return this;
            }
        }
        return null;
    }

    public void getMoney(long cradNum, double money){
        if(money < 0){
            System.out.println("Դուք չեք կարող ելքագրել բացասական գումար ??????????");
            return;
        }else if (money == 0){
            System.out.println("0- ական գումար ելքագրել անիմաստ գործողություն է! Գործուղությունը չի կատարվել․․․");
            return;
        }
        long cn = 0;
        for (Map.Entry<BankCard,Client> item : clintsMap.entrySet()){
            Client cl = item.getValue();
            BankCard bc = item.getKey();
            String pas = cl.getPasport();
            long num = getClientCardNumber(pas);
            double sum = bc.getHashiv();
            cn = num;
            if (num == cradNum){
                if (sum >= money){
                    sum -= money;
                    bc.setHashiv(sum);
                }else {
                    System.out.println("- Ձեր հաշվի վրա բավարար գումար չկա ։ գումարը հաշվի վրա ֊> " + sum);
                }
                return;
            }
        }
        System.out.println("- գործարք: [հաշվից գումարի հանում քարտով] -> N_\""
                + cn + "\" բանկային քարտ " + this.name +
                " բանկում գրանցված չէ․․․");
    }
}
