package instigate.apranqCheck;

public class Supermarket {
    public static void main(String[] args) {
        Apranq grich = new Apranq("grich",100);
        Apranq asex = new Apranq("asex",200);
        Apranq sok = new Apranq("sok",400);
        Apranq avto = new Apranq("avto",500);
        AprnqCount gnumner = new AprnqCount();

        gnumner.add(grich);
        gnumner.add(asex);
        gnumner.add(sok);
        gnumner.add(avto);
        gnumner.add(avto);
        gnumner.add(avto);
        gnumner.remvoe(avto);

        gnumner.check();
    }
}
