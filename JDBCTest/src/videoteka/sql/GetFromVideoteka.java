package videoteka.sql;

import videoteka.lib.Actor;
import videoteka.lib.Film;
import videoteka.lib.Producer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetFromVideoteka {
    private SQLConnector connector;
    private Statement statement;

    public GetFromVideoteka(SQLConnector sqlConnector) throws SQLException, ClassNotFoundException {
        this.connector = sqlConnector;
        this.statement = connector.getStatmen();
    }


    //this method`s is for get Films in DB (get film`s produced by on this year or last)
    //------------------------------------------------------------------------------------
    public List<Film> thisYearAndLastFilms() throws ParseException {
        List<Film> films = new ArrayList<>();
        List<MatchesFilms> matchesFilmsList = new ArrayList<>();
        ResultSet resultSet = null;
        Date date = new Date();
        SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate end = LocalDate.now();
        int year = date.getYear()+1900 -1;
        int month = date.getMonth();
        LocalDate startDate  = LocalDate.of(year,month,1);
        try {
            resultSet = statement.executeQuery("SELECT * FROM Videoteka.Films where reliseDate BETWEEN '"+startDate+"' AND '"+end+"'");
            while (resultSet.next()){
                MatchesFilms matchesFilm = new MatchesFilms();
                matchesFilm.setBirthDate(spd.parse(resultSet.getString("reliseDate")));
                matchesFilm.setContry(resultSet.getString("contry"));
                matchesFilm.setTitle(resultSet.getString("title"));
                matchesFilm.setId(resultSet.getInt("id"));
                matchesFilm.setProducerId(resultSet.getInt("producerId"));
                matchesFilmsList.add(matchesFilm);
            }
        }catch (Exception e){
            System.out.println("In this year or last films not found" + e);
        }
        for (MatchesFilms mFilm : matchesFilmsList) {
            Film film = MtachesParseToFilm(mFilm);
            films.add(film);
        }
        return films;
    }

    private Film MtachesParseToFilm(MatchesFilms mFilm) {
        Film film = null;
        String title = mFilm.getTitle();
        String contry = mFilm.getContry();
        int producerId = mFilm.getProducerId();
        int filmId = mFilm.getId();

        Date date = mFilm.birthDate;
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = date.toInstant();
        LocalDate reliseDate = instant.atZone(zoneId).toLocalDate();

        List<Actor> actorList = getACtorsList(filmId);
        Producer producer = getProducer(producerId);
        film = new Film(title,contry,producer,reliseDate,actorList);
        return film;
    }

    private List<Actor> getACtorsList(int filmId) {
        List<Actor> actorList = new ArrayList<>();
        List<Integer> actorsId = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * from  Videoteka.FilmActor where BK = '"+filmId+"'");
            while (resultSet.next()){
                actorsId.add(resultSet.getInt("actorId"));
            }
        }catch (Exception e){
            System.out.println("On this film not found any acotr: " + e);
        }

        for (int i : actorsId) {
            Actor actor = getActor(i);
            actorList.add(actor);
        }

        return actorList;
    }

    private Actor getActor(int actorId) {
        Actor actor = null;
        ResultSet resultSet = null;
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = null;
        SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            resultSet = statement.executeQuery("SELECT * FROM Videoteka.Actors where id = '"+actorId+"' ");
            while (resultSet.next()){
                Date date = spd.parse(resultSet.getString("birthdate"));
                instant = date.toInstant();
                LocalDate birthDate = instant.atZone(zoneId).toLocalDate();
                actor = new Actor(resultSet.getString("name"),birthDate);
            }
        }catch (Exception e){
            System.out.println("On this id not found any actor: " + e);
        }

        return actor;
    }

    private Producer getProducer(int producerId) {
        Producer producer = null;
        ResultSet resultSet = null;
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = null;
        LocalDate birthDate = null;
        SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");

        try {
            resultSet = statement.executeQuery("SELECT * FROM Videoteka.Producer where id = '"+producerId+"'");
            while (resultSet.next()){
                Date date = spd.parse(resultSet.getString("birthDate"));
                instant = date.toInstant();
                birthDate = instant.atZone(zoneId).toLocalDate();
                producer = new Producer(resultSet.getString("name"),birthDate);
            }
        }catch (Exception e){
            System.out.println("On this ID any producer not found" + e);
        }

        return producer;
    }
    //------------------------------------------------------------------------------------

    public void exit(){
        connector.closeStatement(statement);
        try {
            connector.getConnection().close();
            System.out.println("We are disconnect!!!");
        } catch (SQLException e) {
            System.out.println("connection is null!!!");
            return;
        }
    }

    private class MatchesFilms{
        private int id;
        private String title;
        private Date birthDate;
        private String contry;
        private int producerId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        public String getContry() {
            return contry;
        }

        public void setContry(String contry) {
            this.contry = contry;
        }

        public int getProducerId() {
            return producerId;
        }

        public void setProducerId(int producerId) {
            this.producerId = producerId;
        }
    }
}
