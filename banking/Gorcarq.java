package instigate.banking;

public class Gorcarq {
    public static void main(String[] args) {

        Client cl1 = new Client("Edo", "1234");
        Bank vtbBank = new Bank("VTB");
        Bancomat bancomat1 = new Bancomat();

        vtbBank.addClint(cl1);
        long crdNum =  vtbBank.getClientCardNumber("1234");

        vtbBank.addMoney("1234",5000);
        vtbBank.addMoney("1234", 1000);

        bancomat1.hashviStugum(vtbBank,crdNum);
        bancomat1.getMoney(vtbBank,crdNum,1000);
        bancomat1.hashviStugum(vtbBank,crdNum);

        Client cl2 = new Client("Samo", "4567");
        vtbBank.addClint(cl2);
        vtbBank.addMoney("4567", 5360);
        long crdNum2 = vtbBank.getClientCardNumber("4567");
        bancomat1.hashviStugum(vtbBank, crdNum2);


    }
}
