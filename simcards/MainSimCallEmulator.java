package instigate.simcards;

public class MainSimCallEmulator {
    public static void main(String[] args) {
        Tarif tarif1 = new Tarif(MobileOperators.MTS,
                "base",0,0,
                5,15,45,
                55,10,25,1);

        UseSims sim1MTS = new UseSims(tarif1,"+37493111111");
        sim1MTS.setBalance(1000);

        System.out.println("balance: " + sim1MTS.getBalance());

        Tarif tarif2 = new Tarif(MobileOperators.MTS,
                "mobil",0,0,
                5,15,45,
                55,10,25,1);
        UseSims sim2MTS = new UseSims(tarif2,"+37494222222");

        sim1MTS.callTo(sim2MTS,2,false);
        System.out.println("---------------------------------------");
        System.out.println("balance after call to sim2: " + sim1MTS.getBalance());

        Tarif tarif3 = new Tarif(MobileOperators.BEELINE,
                "base",0,0,
                5,15,45,
                55,10,25,1);

        UseSims sim3Belline = new UseSims(tarif3,"+37499222707");
        sim1MTS.callTo(sim3Belline,1,false);

        System.out.println("---------------------------------------");
        System.out.println("balance after call to sim3: " + sim1MTS.getBalance());

        sim1MTS.useInternet(2,false);

        System.out.println("---------------------------------------");
        System.out.println("balance after use internet: " + sim1MTS.getBalance());

        sim1MTS.sendSMS();
        System.out.println("---------------------------------------");
        System.out.println("balance after send SMS: " + sim1MTS.getBalance());
    }
}
