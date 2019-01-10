package suvenirDB.lib;

import java.util.Date;

public class Suvenir {
    private String name;
    private Manufacturer manufacturer;

    public String getMadeInYear() {
        return madeInYear;
    }

    public void setMadeInYear(String madeInYear) {
        this.madeInYear = madeInYear;
    }

    private String madeInYear;
    private double price;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
