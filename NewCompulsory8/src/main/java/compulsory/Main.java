package compulsory;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        Connect connectionDB = Connect.getInstance ();

        DAOMovies movie = new DAOMovies ( connectionDB.getConnection () );
//        movie.createMovie ( 3 , "After" , Date.valueOf ( "2018-09-8" ) , 120 , 1 );
//        movie.createMovie ( 2 , "Twilight" , Date.valueOf ( "2008-10-09" ) , 180, 3 );
//        movie.createMovie ( 1 , "Pistruiatul" , Date.valueOf ( "1989-06-01" ) , 120 , 2 );
        movie.findByID ( 2 );
        movie.findByTitlu ( "Twilight" );

        DAOGenres genre = new DAOGenres ( connectionDB.getConnection () );
//        genre.createGenre ( 1 , "Romance" );
//        genre.createGenre ( 2 , "Action" );
//        genre.createGenre ( 3 , "Comedy" );
        genre.findByNume ( "Romance" );
        genre.findByID ( 2 );

    }
}