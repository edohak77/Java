package instigate.simcards;

public class Tarif {

    private MobileOperators operatorName;
    private String tarifName;

    private double pr_IncomingCalls;

    private double pr_toMyTarif;
    private double pr_toMyOperator;
    private double pr_toInMyContry;
    private double pr_toOther;
    private double pr_OutingFromIRouming;

    private double pr_ForMBInternet;
    private double pr_ForMBInternetInRouming;

    private double pr_SMS;

    public Tarif(MobileOperators operatorName, String tarifName, double pr_IncomingCalls, double pr_toMyTarif, double pr_toMyOperator, double pr_toInMyContry, double pr_toOther, double pr_OutingFromIRouming, double pr_ForMBInternet, double pr_ForMBInternetInRouming, double pr_SMS) {
        if (pr_IncomingCalls < 0 || pr_toMyTarif < 0 || pr_toMyOperator < 0 || pr_toInMyContry < 0 ||
            pr_toOther < 0 || pr_OutingFromIRouming < 0 || pr_ForMBInternet < 0 || pr_ForMBInternetInRouming < 0 || pr_SMS < 0){
            System.out.println("invalide data inputing");
            return;
        }
        this.operatorName = operatorName;
        this.tarifName = tarifName;
        this.pr_IncomingCalls = pr_IncomingCalls;
        this.pr_toMyTarif = pr_toMyTarif;
        this.pr_toMyOperator = pr_toMyOperator;
        this.pr_toInMyContry = pr_toInMyContry;
        this.pr_toOther = pr_toOther;
        this.pr_OutingFromIRouming = pr_OutingFromIRouming;
        this.pr_ForMBInternet = pr_ForMBInternet;
        this.pr_ForMBInternetInRouming = pr_ForMBInternetInRouming;
        this.pr_SMS = pr_SMS;
    }

    public MobileOperators getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(MobileOperators operatorName) {
        this.operatorName = operatorName;
    }

    public String getTarifName() {
        return tarifName;
    }

    public void setTarifName(String tarifName) {
        this.tarifName = tarifName;
    }

    public double getPr_IncomingCalls() {
        return pr_IncomingCalls;
    }

    public void setPr_IncomingCalls(double pr_IncomingCalls) {
        this.pr_IncomingCalls = pr_IncomingCalls;
    }

    public double getPr_toMyTarif() {
        return pr_toMyTarif;
    }

    public void setPr_toMyTarif(double pr_toMyTarif) {
        this.pr_toMyTarif = pr_toMyTarif;
    }

    public double getPr_toMyOperator() {
        return pr_toMyOperator;
    }

    public void setPr_toMyOperator(double pr_toMyOperator) {
        this.pr_toMyOperator = pr_toMyOperator;
    }

    public double getPr_toInMyContry() {
        return pr_toInMyContry;
    }

    public void setPr_toInMyContry(double pr_toInMyContry) {
        this.pr_toInMyContry = pr_toInMyContry;
    }

    public double getPr_toOther() {
        return pr_toOther;
    }

    public void setPr_toOther(double pr_toOther) {
        this.pr_toOther = pr_toOther;
    }

    public double getPr_OutingFromIRouming() {
        return pr_OutingFromIRouming;
    }

    public void setPr_OutingFromIRouming(double pr_OutingFromIRouming) {
        this.pr_OutingFromIRouming = pr_OutingFromIRouming;
    }

    public double getPr_ForMBInternet() {
        return pr_ForMBInternet;
    }

    public void setPr_ForMBInternet(double pr_ForMBInternet) {
        this.pr_ForMBInternet = pr_ForMBInternet;
    }

    public double getPr_ForMBInternetInRouming() {
        return pr_ForMBInternetInRouming;
    }

    public void setPr_ForMBInternetInRouming(double pr_ForMBInternetInRouming) {
        this.pr_ForMBInternetInRouming = pr_ForMBInternetInRouming;
    }

    public double getPr_SMS() {
        return pr_SMS;
    }

    public void setPr_SMS(double pr_SMS) {
        this.pr_SMS = pr_SMS;
    }
    //    public Tarif() {};
}
