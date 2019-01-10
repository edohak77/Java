package videoteka;

import videoteka.lib.Actor;
import videoteka.lib.Film;
import videoteka.sql.GetFromVideoteka;
import videoteka.sql.SQLConnector;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class GetsFromVideotekaApp {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        SQLConnector connector = new SQLConnector();
        connector.connectDb();
        GetFromVideoteka videoteka = new GetFromVideoteka(connector);
        List<Film> films =videoteka.thisYearAndLastFilms();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");

        for (Film f: films) {
            System.out.println(f.getName());
            System.out.println("*************************");
            System.out.println("made in: " + f.getContry());
            System.out.println("date: " + f.getReliseDate());
            System.out.println("producer; " + f.getProducer().getName() + " " + f.getProducer().getBirthDate());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("actors in: ");
            System.out.println("- - - - - - - - - - - - - - - - ");
            for (Actor actor : f.getActorList() ) {
                System.out.println(actor.getName() + " " + actor.getBirthDate());
            }
            System.out.println("- - - - - - - - - - - - - -  - - ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("*************************");
        }
        if (films.size() == 0) System.out.println("films is null");

        videoteka.exit();
    }
}
