package suvenirDB.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import suvenirDB.interfaces.ManufacturerDAO;
import suvenirDB.interfaces.SuvenirsDAO;
import suvenirDB.lib.Manufacturer;
import suvenirDB.lib.Suvenir;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("sqlSuvenirsDAO")
public class SQLSuvenirsDBDAO implements SuvenirsDAO, ManufacturerDAO {

    private static NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insertSuvenir(Suvenir suvenir) {

        try {
            int manufacturerID = insertManufacturer(suvenir);
            String sql = "insert into suvenirs.suvenir(name, madeInDate, price, manufacturerID) values (:name, :madeInDate, :price, :manufID)";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            MapSqlParameterSource param = new MapSqlParameterSource();
            param.addValue("name",suvenir.getName());
            param.addValue("madeInDate", suvenir.getMadeInYear());
            param.addValue("price", suvenir.getPrice());
            param.addValue("manufID",manufacturerID);

            jdbcTemplate.update(sql,param,keyHolder);
            suvenir.setId(keyHolder.getKey().intValue());
        }catch (Exception e){
            suvenir.setId(getSuvenirID(suvenir));
            System.out.println("This suvenir exist into your database...");

        }

    }

    @Override
    public void deleteSuvenir(Suvenir suvenir) {
        int id = suvenir.getId();
        deleteSuvenir(id);
    }

    @Override
    public void deleteSuvenir(int id) {
        try {
            String sql = "delete from suvenirs.suvenir where id= :suvID";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("suvID", id);
            jdbcTemplate.update(sql,params);
        }catch (Exception e){

            System.out.println("Suvenir is this Id not exist...");
        }

    }

    @Override
    public Suvenir getSuvenirByID(int suvenirId) {
        String sql ="select * from suvenirs.suvenir where id= :suvID";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("suvID",suvenirId);
        return jdbcTemplate.queryForObject(sql,param, new SuvenirRowMapper());
    }

    @Override
    public List<Suvenir> getSuvenirsByManufacturer(Manufacturer manufacturer) {
        int manufID = getManufacturerIDByNameContry(manufacturer.getName(), manufacturer.getContry());
        String sql = "select * from suvenirs.suvenir where manufacturerID= :manufacturID";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("manufacturID", manufID);
        return jdbcTemplate.query(sql,params,new SuvenirRowMapper());
    }

    @Override
    public List<Suvenir> getSuvenirsByManufacturerID(int manufacturerID) {
        Manufacturer manufacturer = getManufacturerByID(manufacturerID);
        return getSuvenirsByManufacturer(manufacturer);
    }

    @Override
    public List<Suvenir> getSuvenirsByMadeInContry(String contry) {
        List<Manufacturer> manufacturerList = getManufacturersByContry(contry);
        List<Suvenir> out = new ArrayList<Suvenir>();
        for (Manufacturer manuf: manufacturerList) {
            List<Suvenir> suvenirList = getSuvenirsByManufacturer(manuf);
            for (Suvenir suv: suvenirList) {
                out.add(suv);
            }
        }
        return out;
    }

    @Override
    public List<Manufacturer> getManufacturersByLowPrice(double price) {
        List<Suvenir>suvenirList = getSuvenirsByLowPrice(price);
        List<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
        for (Suvenir suv: suvenirList) {
            manufacturerList.add(getManufacturerByID(suv.getManufacturer().getId()));
        }
        return manufacturerList;
    }

    private List<Suvenir> getSuvenirsByLowPrice(double price){
        String sql = "select * from suvenirs.suvenir where price< :suvPrice";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("suvPrice", price);
        return jdbcTemplate.query(sql,params,new SuvenirRowMapper());
    }
    @Override
    public List<Manufacturer> getManufacturerBySuvenirNameInThisYear(String suvenirName, String madeInYear) {
        List<Suvenir> suvenirList = getSuvenirsByNameAndYear(suvenirName, madeInYear);
        List<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
        for (Suvenir suv:suvenirList ) {
            manufacturerList.add(getManufacturerByID(suv.getManufacturer().getId()));
        }
        return manufacturerList;
    }

    private List<Suvenir>getSuvenirsByNameAndYear(String suvenirname, String year){
        String sql = "select * from suvenirs.suvenir where name= :suvName AND madeInDate= :madeYear";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("madeYear",year);
        params.addValue("suvName",suvenirname);
        return jdbcTemplate.query(sql,params,new SuvenirRowMapper());
    }

    @Override
    public int getSuvenirID(Suvenir suvenir) {
        String sql = "select id from suvenirs.suvenir where name= :suvName and price= :suvPrice and " +
                "madeInDate= :madeDate and manufacturerID= :manufID";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("suvName", suvenir.getName());
        param.addValue("suvPrice", suvenir.getPrice());
        param.addValue("madeDate", suvenir.getMadeInYear());
        param.addValue("manufID", suvenir.getManufacturer().getId());
        return jdbcTemplate.queryForObject(sql,param,Integer.class);

    }

    @Override
    public void deliteManufacturerWithSuvenirs(Manufacturer manufacturer) {

    }

    @Override
    public int insertManufacturer(Suvenir suvenir) {
        int id = 0;
        try {
            String sql = "insert into suvenirs.manufacturer(name, contry) values (:name, :contry)";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("name",suvenir.getManufacturer().getName());
            params.addValue("contry", suvenir.getManufacturer().getContry());
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(sql, params, keyHolder);
            suvenir.getManufacturer().setId(keyHolder.getKey().intValue());
            id = suvenir.getManufacturer().getId();
            return id;
        }catch (Exception e){
            String name = suvenir.getManufacturer().getName();
            String contry = suvenir.getManufacturer().getContry();
            id = getManufacturerIDByNameContry(name,contry);
            suvenir.getManufacturer().setId(id);
//            System.out.println(name + " " + contry);
//            System.out.println(id);
            return id;
        }

    }

    @Override
    public Manufacturer getManufacturerByID(int manufacturerID) {
        String sql = "select * from suvenirs.manufacturer where id= :manifId ";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("manifId",manufacturerID );
        return jdbcTemplate.queryForObject(sql,param, new MaunfacturerRowMapper());

    }

    @Override
    public int getManufacturerIDByNameContry(String name, String contry) {
        String sql = "select * from suvenirs.manufacturer where name= :manufName AND contry= :manufContry";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("manufName", name);
        params.addValue("manufContry",contry);
        Manufacturer manufacturer = jdbcTemplate.queryForObject(sql,params,new MaunfacturerRowMapper());
        return manufacturer.getId();
    }

    @Override
    public List<Manufacturer> getManufacturersByContry(String contry) {
       String sql ="select * from suvenirs.manufacturer where contry= :manufContry";
       MapSqlParameterSource params = new MapSqlParameterSource();
       params.addValue("manufContry",contry);
       return jdbcTemplate.query(sql,params,new MaunfacturerRowMapper());
    }

    public static final class MaunfacturerRowMapper implements RowMapper<Manufacturer>{

        @Override
        public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(rs.getString("name"));
            manufacturer.setContry(rs.getString("contry"));
            manufacturer.setId(rs.getInt("id"));
            return manufacturer;
        }
    }

    public static final class SuvenirRowMapper implements RowMapper<Suvenir>{

        @Override
        public Suvenir mapRow(ResultSet rs, int rowNum) throws SQLException {
            Suvenir suvenir = new Suvenir();
            suvenir.setId(rs.getInt("id"));
            suvenir.setMadeInYear(rs.getString("madeInDate"));
            suvenir.setPrice(rs.getDouble("price"));
            suvenir.setName(rs.getString("name"));
            int manufID = rs.getInt("manufacturerID");

            Manufacturer manufacturer = getManufacturByID(manufID);
            suvenir.setManufacturer(manufacturer);
            return suvenir;
        }

        private Manufacturer getManufacturByID(int id){
            String sql = "select * from suvenirs.manufacturer where id= :manifID";
            MapSqlParameterSource params =  new MapSqlParameterSource();
            params.addValue("manifID",id);
            return jdbcTemplate.queryForObject(sql,params,new MaunfacturerRowMapper());
        }
    }
}
