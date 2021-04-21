package Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOPerson {
    Connection connectionDB;

    public DAOPerson(Connection connection) {
        this.connectionDB = connection;
    }

    public void createPerson(int id, String nume) {
        try {
            String sql = "INSERT INTO persons VALUES (?,?)";
            PreparedStatement pst = connectionDB.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, nume);

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Person findByID(int id) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM persons WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet personRows = statement.executeQuery();
            if (personRows.next()) {
                return new Person(personRows.getInt(0),
                        personRows.getString(1));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return null;


    }

    public Person findByNume(String nume) {
        try {
            PreparedStatement statement = connectionDB.prepareStatement("SELECT * FROM personss WHERE nume = ?");
            statement.setString(1, nume);
            ResultSet personRows = statement.executeQuery();
            if (personRows.next()) {
                return new Person(personRows.getInt(0),
                        personRows.getString(1));
            }
            statement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getSQLState());
        }
        return null;


    }
}
