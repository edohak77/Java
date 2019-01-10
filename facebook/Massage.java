package instigate.facebook;

import java.util.Date;

public class Massage {

    private String author = "";
    private String massageText = "";
    private Date massagedata = new Date();

    public Massage() {
    }

    public Massage(String author, String massageText) {
        this.author = author;
        this.massageText = massageText;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMassageText(String massageText) {
        this.massageText = massageText;
    }

    public String getAuthor() {
        return author;
    }

    public String getMassageText() {
        return massageText;
    }

    public Date getMassagedata() {
        return massagedata;
    }
}
