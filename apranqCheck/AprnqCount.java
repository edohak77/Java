package instigate.apranqCheck;

import java.util.ArrayList;

public class AprnqCount {
    ArrayList<Apranq> anvanacank = new ArrayList<Apranq>();

    public void add(Apranq apranq) {
        anvanacank.add(apranq);
//        System.out.println(apranq.getName() + " ->  apranqy avelacvel e dzer anvanacankum");
    }

    public void remvoe(Apranq apranq){
        if (!anvanacank.contains(apranq)){
            System.out.println("Ays apranqntesaky anvanacankum goyutyun chuni");
        }else {
            anvanacank.remove(apranq);
            System.out.println(apranq.getName() + "- y navanacankic heracvat e");
        }

    }

    public void check(){
        double sum = 0;
        ArrayList <Apranq> stugum = new ArrayList<>();
        for (Apranq a : anvanacank) {

            double sumOfnames = qanak(a) * a.getPrice();

            if (!stugum.contains(a)){
                System.out.println("name -> " + a.getName() + " : " + qanak(a)  + " X " + a.getPrice() + " = " + sumOfnames);
                stugum.add(a);
                sum += sumOfnames;
            }

            sumOfnames = 0;
        }
        System.out.println("---------------------");
        System.out.println("Yndameny -> " + sum + "  arjeqi apranqner");
    }
    private int qanak(Apranq ap){
        int sum = 0;
        for (Apranq k : anvanacank) {
            if (k == ap){
                sum ++;
            }
        }
        return sum;

    }


}


