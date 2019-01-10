package instigate.simcards;

public abstract class Sim {


    public abstract void callTo(UseSims toSim, double minutes, boolean rouming);
    abstract public double getBalance();
    abstract public void setBalance(double money);
    abstract public void useInternet(double MBs, boolean rouming);
    abstract public void sendSMS();

}
