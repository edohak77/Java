package instigate.apranqCheck;

public class Apranq {
    private String name;
    private double price;
//    private long id = 10000;


    public Apranq(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
