package compulsory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DAOMovies {
    Connection connectionDB;

    public DAOMovies (Connection connection) {
        this.connectionDB = connection;
    }

    public void createMovie(int id, String titlu, Date premiera, int durata, int top) {
        try {
            String sql = "INSERT INTO movies VALUES (?,?,?,?,?)";
            PreparedStatement pst = connectionDB.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, titlu);
            pst.setDate(3, (java.sql.Date) premiera);
            pst.setInt(4, durata);
            pst.setInt(5, top);

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getNextException());
        }

    }

    public void findByID(int id) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM movies WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet movieRows = statement.executeQuery();
            if (movieRows.next() == true) {
                System.out.println(movieRows.getInt(1) + " " + movieRows.getString(2) + " " + movieRows.getDate(3) + " " + movieRows.getInt(4) + movieRows.getInt(5));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }


    }

    public void findByTitlu(String title) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM movies WHERE titlu = ?");
            statement.setString(1, title);
            ResultSet movieRows = statement.executeQuery();
            if (movieRows.next() == true) {
                System.out.println(movieRows.getInt(1) + " " + movieRows.getString(2) + " " + movieRows.getDate(3) + " " + movieRows.getInt(4) + movieRows.getInt(5));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }


    }
}
