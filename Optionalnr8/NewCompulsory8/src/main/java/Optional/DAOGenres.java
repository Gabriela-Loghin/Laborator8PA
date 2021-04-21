package Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOGenres {
    Connection connectionDB;

    public DAOGenres(Connection connectionDB) {
        this.connectionDB = connectionDB;
    }

    public void createGenre(int id, String nume) {
        try {
            String sql = "INSERT INTO genres VALUES (?,?)";
            PreparedStatement pst = connectionDB.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, nume);

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Genre findByID(int id) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM genres WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet genreRows = statement.executeQuery();
            if (genreRows.next()) {
                return new Genre(genreRows.getInt(0),
                        genreRows.getString(1));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return null;
    }

    public Genre findByNume(String name) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM genres WHERE nume = ?");
            statement.setString(1, name);
            ResultSet genreRows = statement.executeQuery();
            if (genreRows.next()) {
                return new Genre(genreRows.getInt(0),
                        genreRows.getString(1));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return null;
    }
}
