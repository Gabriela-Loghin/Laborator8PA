package Optional;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static DAOMovies daomovie;
    private static DAOGenres daogenre;
    private static DAOPerson daoperson;
    private static DAOActor daoactor;
    private static DAODirector daodirector;

    public static void getMovies() {
        try (CSVReader reader = new CSVReader ( new FileReader ( "C:\\Users\\Q\\Downloads\\Optionalnr8\\NewCompulsory8\\set\\Dataset\\IMDb movies.csv" ) )) {
            reader.readNext ();
            List<String[]> movies = reader.readAll ();
            movies.forEach ( movieDB -> {
                try {
                    daomovie.createMovie ( Integer.parseInt ( movieDB[0].replaceAll ( "\\D+" , "" )
                    ) , movieDB[1] , java.sql.Date
                            .valueOf ( movieDB[4] ) , (int) Double.parseDouble ( movieDB[6] ) , (int) Double
                            .parseDouble ( movieDB[20] ) );
                    Genre genre = new Genre ( movieDB[5] );
                    if (daogenre.findByNume ( movieDB[5] ) != null)
                        daogenre.createGenre ( genre.getId () , genre.getNume () );


                } catch (IllegalArgumentException e) {
                    // System.out.println(e.getMessage());
                }
            } );
        } catch (IOException | CsvException exception) {
            //exception.printStackTrace();
        }
    }

    public static void getPersons() {
        try (CSVReader reader = new CSVReader ( new FileReader ( "C:\\Users\\Q\\Downloads\\Optionalnr8\\NewCompulsory8\\set\\Dataset\\IMDb names.csv" ) )) {
            reader.readNext ();
            List<String[]> personsDB = reader.readAll ();
            personsDB.forEach ( personDB -> {
                try {
                    daoperson.createPerson ( Integer.parseInt ( personDB[0].replaceAll ( "\\D+" , "" ) ) , personDB[1] );
                } catch (IllegalArgumentException e) {
                    // System.out.println(e.getMessage());
                }
            } );
        } catch (IOException | CsvException exception) {
            //exception.printStackTrace();
        }
    }

    public static void getActors() {
        try (CSVReader reader = new CSVReader ( new FileReader ( "C:\\Users\\Q\\Downloads\\Optionalnr8\\NewCompulsory8\\set\\Dataset\\IMDb title_principals.csv" ) )) {
            reader.readNext ();
            List<String[]> personsDB = reader.readAll ();
            personsDB.forEach ( personDB -> {
                try {
                    Person person = daoperson.findByID ( Integer.parseInt ( personDB[2].replaceAll ( "\\D+" , "" ) ) );
                    if (person == null) {
                        return;
                    }
                    if (personDB[3].equals ( "actor" )) {
                        daoactor.createActor ( person.getId () , person.getNume () );
                    }
                } catch (IllegalArgumentException e) {
                    // System.out.println(e.getMessage());
                }
            } );
        } catch (IOException | CsvException exception) {
            //exception.printStackTrace();
        }
    }

    public static void getDirectors() {
        try (CSVReader reader = new CSVReader ( new FileReader ( "C:\\Users\\Q\\Downloads\\Optionalnr8\\NewCompulsory8\\set\\Dataset\\IMDb title_principals.csv" ) )) {
            reader.readNext ();
            List<String[]> personsDB = reader.readAll ();
            personsDB.forEach ( personDB -> {
                try {
                    Person person = daoperson.findByID ( Integer.parseInt ( personDB[2].replaceAll ( "\\D+" , "" ) ) );
                    if (person == null) {
                        return;
                    }
                    if (personDB[3].equals ( "director" )) {
                        daodirector.createDirector ( person.getId () , person.getNume () );
                    }
                } catch (IllegalArgumentException e) {
                    // System.out.println(e.getMessage());
                }
            } );
        } catch (IOException | CsvException exception) {
            //exception.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Connect connectionDB = Connect.getInstance ();

        daomovie = new DAOMovies ( connectionDB.getConnection () );
        daogenre = new DAOGenres ( connectionDB.getConnection () );
        daoperson = new DAOPerson ( connectionDB.getConnection () );
        daoactor = new DAOActor ( connectionDB.getConnection () );
        daodirector = new DAODirector ( connectionDB.getConnection () );
        //  getMovies();
        getPersons();
        //getActors ();
      //  getDirectors();

    }
}