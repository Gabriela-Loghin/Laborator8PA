package Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAODirector {
    Connection connectionDB;

    public DAODirector(Connection connection) {
        this.connectionDB = connection;
    }

    public void createDirector(int id, String nume) {
        try {
            String sql = "INSERT INTO directors VALUES (?,?)";
            PreparedStatement pst = connectionDB.prepareStatement(sql);
            pst.setInt(0, id);
            pst.setString(1, nume);

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Director findByID(int id) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM directors WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet movieRows = statement.executeQuery();
            if (movieRows.next()) {
                System.out.println(movieRows.getInt(0) +
                        " " +
                        movieRows.getString(1));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return null;

    }

    public Director findByNume(String nume) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM directors WHERE nume = ?");
            statement.setString(1, nume);
            ResultSet directorRows = statement.executeQuery();
            if (directorRows.next()) {
                return new Director(directorRows.getInt(0),
                        directorRows.getString(1));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return null;


    }
}