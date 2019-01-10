package videoteka.sql;

import videoteka.lib.Actor;
import videoteka.lib.Film;
import videoteka.lib.Producer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public  class VideotekaChange {
    private SQLConnector sqlConnector;
    private Statement statement;

    public VideotekaChange(SQLConnector sqlConnector) throws SQLException, ClassNotFoundException {
        this.sqlConnector = sqlConnector;
        statement = sqlConnector.getStatmen();
//        sqlConnector.connectDb();
    }

    //new Film add method & all privte methods for this method
    //---------------------------------------------------------------------------------
    public void addFilm(Film film) throws SQLException, ParseException {
        wrireProducerData(film.getProducer());
        int producerId = getProducerId(film.getProducer());
//        System.out.println("prod ID: " + producerId);
        writeFilm(film, producerId);
        writeAcors(film);
        int[] actorsId = getActorsId(film);
//        for (int i : actorsId ) {
//            System.out.print(" id = " + i);
//        }
        System.out.println();

        int filmId = getFilmId(film, producerId);
//        System.out.println("filmID = " + filmId);
        writeBindingKeyForFilmActors(actorsId,filmId);

//        sqlConnector.closeStatement(statement);
//        if (sqlConnector.getConnection() != null)
//        sqlConnector.getConnection().close();
    }

    private void writeBindingKeyForFilmActors(int[] actorsId, int filmId) {
//        System.out.println("infunciton : filmId = " + filmId);
        int F_id = filmId;
        for (int id :actorsId ) {
            try{
                statement.executeUpdate("INSERT INTO Videoteka.FilmActor SET BK = '"+F_id+"', actorId = '"+id+"'");
            }catch (Exception e){
                continue;
            }

        }
    }

    private int[] getActorsId(Film film) throws SQLException {
        int[] ids = new int[film.getActorList().size()];
        List<Actor> actorList = film.getActorList();
        int i = 0;
        int id = -1;
        for (Actor actor : actorList) {
            ResultSet resultSet = statement.executeQuery("SELECT Videoteka.Actors.id from Videoteka.Actors where Videoteka.Actors.name = '"+actor.getName()+"' && " +
                    "Videoteka.Actors.birthdate = '"+actor.getBirthDate()+"' ");
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            ids[i] = id;
            i++;
        }


        return ids;
    }

    private void writeAcors(Film film) {
        List<Actor> actorList = film.getActorList();
        for (Actor actor : actorList) {
            try{
                statement.executeUpdate("INSERT INTO Videoteka.Actors SET name = '"+actor.getName()+"', " +
                        "birthdate = '"+actor.getBirthDate()+"'");
            }catch (Exception e){
                continue;
            }
        }
    }

    private int getFilmId(Film film, int producerId) throws SQLException {
        int filmId = -1;
        String title = film.getName();
        ResultSet resultSet = statement.executeQuery("SELECT Videoteka.Films.id FROM Videoteka.Films where producerId = '"+producerId+"'&& " +
                "title = '"+film.getName()+"' && contry = '"+film.getContry()+"' && reliseDate = '"+film.getReliseDate()+"'");
        while (resultSet.next()){
            filmId = resultSet.getInt("id");
        }
        return filmId;
    }

    private void writeFilm(Film film, int producerId) {
        String title = film.getName();
        LocalDate date = film.getReliseDate();
        String contry = film.getContry();
        try {
            statement.executeUpdate("INSERT INTO Videoteka.Films SET title = '"+title+"', reliseDate = '"+date+"'," +
                    "contry = '"+contry+"', producerId = '"+producerId+"'");
        }catch (Exception e){
            System.out.println("Not film added!!!: This film is already in your video library...");
            return;
        }

    }

    private int getProducerId(Producer producer) throws SQLException {
        String prodName = producer.getName();
        LocalDate date = producer.getBirthDate();
        String keyPathern = prodName + "-" + date;
        int id = -1;
        ResultSet resultSet = statement.executeQuery("SELECT Producer.id from Videoteka.Producer where Producer.birthDate = '"+date+"' && Producer.name = '"+prodName+"'");
        while (resultSet.next()){
            id = resultSet.getInt("id");
        }
        return id;
    }

    private void wrireProducerData(Producer producer) {
        String prodName = producer.getName();
        LocalDate prodBirthdate = producer.getBirthDate();
        try{
            statement.executeUpdate("INSERT INTO Producer set name = '"+prodName+"', birthDate = '"+prodBirthdate+"'");
        } catch (SQLException e) {
            return;
        }
    }
    //---------------------------------------------------------------------------------------------
    public void exit() throws SQLException {
        sqlConnector.closeStatement(statement);
        if (sqlConnector.getConnection() != null){
            sqlConnector.getConnection().close();
            System.out.println("We are disconnected!!!");
        }
    }
}
