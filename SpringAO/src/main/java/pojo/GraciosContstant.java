package pojo;

import interfaces.Contestant;

public class GraciosContstant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("I`m Contestant");
    }
}
