package pojo;

import interfaces.Instrumentalist;

public  class Pianist implements Instrumentalist {
    String name;
    String song;

    @Override
    public void playMusic() {
        System.out.println("-----------------------------------------------");
        System.out.println("I `am pianist " + this.name + " and i play " + this.song + " song!!!");
        System.out.println("-----------------------------------------------");
    }

    public Pianist(String name, String song) {
        this.name = name;
        this.song = song;
    }

    public Pianist() {
    }
}
