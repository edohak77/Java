package suvenirDB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import suvenirDB.DAO.SQLSuvenirsDBDAO;
import suvenirDB.lib.Manufacturer;
import suvenirDB.lib.Suvenir;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SQLSuvenirsDBDAO suvenirsDBDAO = (SQLSuvenirsDBDAO)context.getBean("sqlSuvenirsDAO");


//
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setContry("USA");
        manufacturer.setName("FFF");
//
        Suvenir suvenir = new Suvenir();
        suvenir.setName("Caxracu");
        suvenir.setPrice(129.0);
        suvenir.setMadeInYear("2019");
        suvenir.setManufacturer(manufacturer);

        suvenirsDBDAO.insertSuvenir(suvenir);



//        List<Suvenir>suvenirList = suvenirsDBDAO.getSuvenirsByManufacturer(manufacturer);
//        for (Suvenir suv:suvenirList) {
//            System.out.println(suv.getName() + " " + suv.getPrice() + " " + suv.getMadeInYear());
//        }

//        List<Suvenir> suvenirList= suvenirsDBDAO.getSuvenirsByMadeInContry("USA");
//        for (Suvenir suv: suvenirList ) {
//            System.out.println(suv.getName() + " " + suv.getPrice() + " " + suv.getMadeInYear() + " " +
//                    suv.getManufacturer().getContry());
//        }

    }
}
