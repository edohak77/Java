package suvenirDB.interfaces;

import suvenirDB.lib.Manufacturer;
import suvenirDB.lib.Suvenir;

import java.util.Date;
import java.util.List;

public interface SuvenirsDAO {
    void insertSuvenir(Suvenir suvenir);
    void deleteSuvenir(Suvenir suvenir);
    void deleteSuvenir(int id);
    Suvenir getSuvenirByID(int suvenirId);
    List<Suvenir> getSuvenirsByManufacturer(Manufacturer manufacturer);
    List<Suvenir> getSuvenirsByManufacturerID(int manufacturerID);
    List<Suvenir> getSuvenirsByMadeInContry(String contry);
    List<Manufacturer> getManufacturersByLowPrice(double price);
    List<Manufacturer> getManufacturerBySuvenirNameInThisYear(String suvenirName, String madeInYear);
    int getSuvenirID(Suvenir suvenir);
    void deliteManufacturerWithSuvenirs(Manufacturer manufacturer);

}
