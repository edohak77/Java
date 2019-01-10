package suvenirDB.interfaces;

import suvenirDB.lib.Manufacturer;
import suvenirDB.lib.Suvenir;

import java.util.List;

public interface ManufacturerDAO {
    int insertManufacturer(Suvenir suvenir);
    Manufacturer getManufacturerByID(int manufacturerID);
    int getManufacturerIDByNameContry(String name, String contry);
    List<Manufacturer> getManufacturersByContry(String contry);

}
