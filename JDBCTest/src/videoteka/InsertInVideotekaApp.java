package videoteka;

import videoteka.lib.Actor;
import videoteka.lib.Film;
import videoteka.lib.Producer;
import videoteka.sql.SQLConnector;
import videoteka.sql.VideotekaChange;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsertInVideotekaApp {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        SQLConnector connector = new SQLConnector();
        connector.connectDb();

        //------------------------------------------------------------------------------------------------
//        Actor actor1 = new Actor("Edo",LocalDate.of(1977,3,1));
//        Actor actor2 = new Actor("Aram",LocalDate.of(1958,12,26));
//        Actor actor3 = new Actor("Spo",LocalDate.of(1997,11,21));
//
//        List<Actor> actorList = new ArrayList<>();
//        actorList.add(actor1);
//        actorList.add(actor2);
//        actorList.add(actor3);
//
//        Producer producer = new Producer("Lena", LocalDate.of(1777,3,25));
//
//        Film film1 = new Film("Titanik","USA", producer, LocalDate.of(2018,6,14), actorList);
//
//    //----------------------------------------------------------------------------------------------------------
//        Actor actor21 = new Actor("Vlad",LocalDate.of(1988,8,4));
//        Actor actor22 = new Actor("Gaspar",LocalDate.of(1996,10,18));
//        Actor actor23 = new Actor("Exo",LocalDate.of(2001,9,14));
//
//        List<Actor> actorList2 = new ArrayList<>();
//        actorList2.add(actor21);
//        actorList2.add(actor22);
//        actorList2.add(actor23);
//
//
//        Producer producer2 = new Producer("Grig", LocalDate.of(1964,11,25));
//
//        Film film2 = new Film("Buran","Canada", producer2, LocalDate.of(2017,12,14), actorList2);
//------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------------
        Actor actor31 = new Actor("Simon",LocalDate.of(1988,8,4));
        Actor actor32 = new Actor("Jim",LocalDate.of(1996,10,18));
        Actor actor33 = new Actor("Silvia",LocalDate.of(2001,9,14));

        List<Actor> actorList3 = new ArrayList<>();
        actorList3.add(actor31);
        actorList3.add(actor32);
        actorList3.add(actor33);


        Producer producer3 = new Producer("Aram", LocalDate.of(1958,12,26));

        Film film3 = new Film("Hin Kino","Canada", producer3, LocalDate.of(2012,10,20), actorList3);


        VideotekaChange videotekaChange = new VideotekaChange(connector);
//        videotekaChange.addFilm(film1);
//        videotekaChange.addFilm(film2);
        videotekaChange.addFilm(film3);

        videotekaChange.exit();

    }
}
