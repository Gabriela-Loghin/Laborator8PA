package Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DAOActor {
    Connection connectionDB;

    public DAOActor(Connection connection) {
        this.connectionDB = connection;
    }

    public void createActor(int id, String nume) {
        try {
            String sql = "INSERT INTO actors VALUES (?,?)";
            PreparedStatement pst = connectionDB.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, nume);

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Actor findByID(int id) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM actors WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet actorRows = statement.executeQuery();
            if (actorRows.next()) {
                return new Actor(actorRows.getInt(0),
                        actorRows.getString(1));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return null;


    }

    public Actor findByNume(String nume) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM actors WHERE nume = ?");
            statement.setString(1, nume);
            ResultSet actorRows = statement.executeQuery();
            if (actorRows.next()) {
                return new Actor(actorRows.getInt(0),
                        actorRows.getString(1));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return null;


    }
}


