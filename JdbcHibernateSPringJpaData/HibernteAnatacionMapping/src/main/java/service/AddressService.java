package service;

import bl.SessionUtil;
import dao.AddressDAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

import static java.lang.reflect.Modifier.PUBLIC;

public class AddressService extends SessionUtil implements AddressDAO {



    public void add(Address address) {
        openTransactionSession();
        Session session = getSession();
        session.save(address);
        closeTransactionSession();
    }

    public List<Address> getAll() throws SQLException {
        openTransactionSession();
        String sql = "SELECT * from ADDRESS";
        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = query.list();

        closeTransactionSession();
        return addressList;
    }

    public Address getById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();

        String sql = "SELECT * FROM ADDRESS where ID=:id";

        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id",id);

        Address address = (Address) query.getSingleResult();

        closeTransactionSession();
        return address;
    }

    public void update(Address address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(address);
        closeTransactionSession();
    }

    public void remove(Address address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.delete(address);
        closeTransactionSession();
    }
}
