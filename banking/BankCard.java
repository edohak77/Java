package instigate.banking;

public class BankCard {
    private long cardNumber;
    private int civ;
    private double hashiv = 0;

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    private String bankName;

    public BankCard(long cardNumber, int civ) {
        this.cardNumber = cardNumber;
        this.civ = civ;
    }

    public double getHashiv() {
        return hashiv;
    }

    public void setHashiv(double hashiv) {
        this.hashiv = hashiv;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "cardNumber=" + cardNumber +
                ", civ=" + civ +
                ", hashiv=" + hashiv +
                '}';
    }
}
