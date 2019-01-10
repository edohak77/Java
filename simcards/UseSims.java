package instigate.simcards;

import java.util.List;

public class UseSims extends Sim {
    private double balance = 0;
    private Tarif tarif;
    public String simNumber;


    public UseSims(Tarif tarif, String simNumber) {
        String regex = "^\\+[1-9]{1}[0-9]{3,14}$";
        if (!simNumber.matches(regex)){
            System.out.println("unformating phone number");
            return;
        }
        this.tarif = tarif;
        this.simNumber = simNumber;
    }

    @Override
    public void callTo(UseSims toSim, double minutes, boolean rouming) {
        if (minutes < 0){
            System.out.println("no correct minutes");
            return;
        }

        if (balance < tarif.getPr_OutingFromIRouming()){
            System.out.println("is not enough money on your balance");
            return;
        }

        Tarif toCallSim = toSim.getTarif();
        if (toCallSim.getOperatorName().equals(tarif.getOperatorName()) && toCallSim.getTarifName().equals(tarif.getTarifName()) && rouming == false){
            balance-=tarif.getPr_toMyTarif() * minutes;
        }else if (toCallSim.getOperatorName().equals(tarif.getOperatorName()) && !toCallSim.getTarifName().equals(tarif.getTarifName()) && rouming == false){
            balance-=tarif.getPr_toMyOperator() * minutes;
        }else if (toCallSim.getOperatorName().equals(MobileOperators.OTHER)){
            balance-=tarif.getPr_toOther() * minutes;
        }else if(rouming == true){
            balance-=tarif.getPr_OutingFromIRouming() * minutes;
        }else {
            balance-=tarif.getPr_toInMyContry() * minutes;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double money) {
        if (money >0 ){
            balance+=money;
        }else {
            System.out.println("You can`t add negative amaunt");
        }
    }

    @Override
    public void useInternet(double MBs, boolean rouming) {
        if (MBs < 0 ) {
            System.out.println("invalid MBs");
            return;
        }
        if (balance <= 150){
            System.out.println("is not enough money on your balance");
            return;
        }
        if (rouming == false) balance-= MBs*tarif.getPr_ForMBInternet();
        else balance -= MBs*tarif.getPr_ForMBInternetInRouming();
    }

    @Override
    public void sendSMS() {
        if (balance < tarif.getPr_SMS()){
            System.out.println("is not enough money on your balance");
            return;
        }
        balance-=tarif.getPr_SMS();
    }

    public Tarif getTarif() {
        return tarif;
    }

    public String getSimNumber() {
        return simNumber;
    }

}
