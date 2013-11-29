package dataSource;

import domain.Vogn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

//=== Maps between objects and tables
//=== Encapsulates SQL-statements
// hau
public class VognMapper {

    /**
     * Henter alle vogne fra databasen
     * 
     * @param con
     * @return DefaultTableModel med alle rækker fra tabellen vogn
     * @throws SQLException 
     */
    public DefaultTableModel getAllVogn(Connection con) throws SQLException {
        DefaultTableModel dtm = null;

        String SQLString = "select * from vogn";

        PreparedStatement statement = null;

        statement = con.prepareStatement(SQLString);
        ResultSet rs = statement.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Vogn nummer");
        columnNames.add("Vogn type");
        columnNames.add("Status");
        columnNames.add("Ordre nummer");
        columnNames.add("Reserveret fra");
        columnNames.add("Reserveret til");
        int columnCount = metaData.getColumnCount();
//        for (int column = 1; column <= columnCount; column++) {
//            columnNames.add(metaData.getColumnName(column));
//        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    /**
     * Gemmer en tuple i databasen baseret på det vogn-opjekt der bliver oprettet
     * 
     * @param v
     * @param con
     * @throws SQLException 
     */
    public boolean saveNewVogn(Vogn v, Connection con) throws SQLException {
        int rowsInserted = 0;
        String SQLString2
                = "insert into Vogn "
                + "values (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        {

            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, v.getVognID());
            statement.setString(2, v.getvType());
            statement.setString(3, v.getStatus());
            statement.setInt(4, v.getOno());
            statement.setString(5, v.getReserveretFra());
            statement.setString(6, v.getReserveretTil());

            rowsInserted = statement.executeUpdate();

            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in VognMapper - saveNewVogn");
                System.out.println(e.getMessage());
            }

            return rowsInserted == 1;
        }
    }

    /**
     * Henter en tuple fra tabellen vogn
     * 
     * @param vognID
     * @param con
     * @return Et vogn-opjekt baseret på den hentede tuple
     * @throws SQLException 
     */
    public Vogn getVogn(int vognID, Connection con) throws SQLException {
        Vogn v = null;
        String SQLString1 = // get vogn
                "select * "
                + "from vogn "
                + "where vognno = ?";
        PreparedStatement statement = null;

        //=== get vogn
        statement = con.prepareStatement(SQLString1);
        statement.setInt(1, vognID);     // primary key value
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            v = new Vogn(vognID,
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
        }

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in VognMapper - getVogn");
            System.out.println(e.getMessage());
        }

        return v;
    }

    /**
     * Opdaterer status af vogn-opjektet og gemmer det i databasen
     * 
     * @param vognID
     * @param status
     * @param con
     * @throws SQLException 
     */
    public boolean updateVognStatus(int vognID, String status, Connection con) throws SQLException {
        int rowUpdated = 0;
        String origStat;

        String SQLString1 = // querry status
                "select status "
                + "from vogn "
                + "where vognno = ?";

        String SQLString2 = "UPDATE vogn "
                + "SET status = ? "
                + "WHERE vognno = ? "; // updates status if not match

        PreparedStatement statement = null;

        statement = con.prepareStatement(SQLString1);
        statement.setInt(1, vognID);
//            statement.setString(2,stat );
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            origStat = rs.getString(1);
            if (origStat.compareTo(status) != 0) {
                statement = con.prepareStatement(SQLString2);
                statement.setString(1, status);
                statement.setInt(2, vognID);
                rowUpdated = statement.executeUpdate();
            }
        }

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in vognMapper - updateVogn");
            System.out.println(e.getMessage());
        }

        return rowUpdated == 1;
    }

    /**
     * Opdaterer ono af vogn-opjektet og gemmer det i databasen
     * 
     * @param vognID
     * @param Ono
     * @param con
     * @throws SQLException 
     */
    public boolean updateVognOno(int vognID, int Ono, Connection con) throws SQLException {
        int rowUpdated = 0;
        int origOno;

        String SQLString1 = // querry status
                "select Ono "
                + "from vogn "
                + "where vognno = ?";

        String SQLString2 = "UPDATE vogn "
                + "SET Ono = ? "
                + "WHERE vognno = ? "; // updates status if not match

        PreparedStatement statement = null;

        statement = con.prepareStatement(SQLString1);
        statement.setInt(1, vognID);
//            statement.setString(2,stat );
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            origOno = rs.getInt(1);
            if (origOno != Ono) {
                statement = con.prepareStatement(SQLString2);
                statement.setInt(1, Ono);
                statement.setInt(2, vognID);
                rowUpdated = statement.executeUpdate();
            }
        }

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in vognMapper - updateVogn");
            System.out.println(e.getMessage());
        }

        return rowUpdated == 1;
    }

    /**
     * Opdaterer datoFra af vogn-opjektet og gemmer det i databasen
     * 
     * @param vognID
     * @param From
     * @param con
     * @throws SQLException 
     */
    public boolean updateVognDatoFra(int vognID, String From, Connection con) throws SQLException {
        int rowUpdated = 0;
        String origFrom;

        String SQLString1 = // querry status
                "select reservedfrom "
                + "from vogn "
                + "where vognno = ?";

        String SQLString2 = "UPDATE vogn "
                + "SET reservedfrom = ? "
                + "WHERE vognno = ? "; // updates status if not match

        PreparedStatement statement = null;

        //=== get vogn
        statement = con.prepareStatement(SQLString1);
        statement.setInt(1, vognID);
//            statement.setString(2,stat );
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            origFrom = rs.getString(1);
            if (origFrom.compareTo(From) != 0) {
                statement = con.prepareStatement(SQLString2);
                statement.setString(1, From);
                statement.setInt(2, vognID);
                rowUpdated = statement.executeUpdate();
            }
        }

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in vognMapper - updateFromDato");
            System.out.println(e.getMessage());
        }

        return rowUpdated == 1;
    }

    /**
     * Opdaterer datoTil af vogn-opjektet og gemmer det i databasen
     * 
     * @param vognID
     * @param To
     * @param con
     * @throws SQLException 
     */
    public boolean updateVognDatoTil(int vognID, String To, Connection con) throws SQLException {
        int rowUpdated = 0;
        String origTo;

        String SQLString1 = // querry status
                "select reservedtil "
                + "from vogn "
                + "where vognno = ?";

        String SQLString2 = "UPDATE vogn "
                + "SET reservedtil = ? "
                + "WHERE vognno = ? "; // updates status if not match

        PreparedStatement statement = null;

        //=== get vogn
        statement = con.prepareStatement(SQLString1);
        statement.setInt(1, vognID);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            origTo = rs.getString(1);
            if (origTo.compareTo(To) != 0) {
                statement = con.prepareStatement(SQLString2);
                statement.setString(1, To);
                statement.setInt(2, vognID);
                rowUpdated = statement.executeUpdate();
            }
        }
        // must close statement
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in vognMapper - updateFromDato");
            System.out.println(e.getMessage());
        }

        return rowUpdated == 1;
    }

    /**
     * Flytter tuplen med det givne vognID til vognRemoved tabellen og 
     * sletter den fra vogn
     * 
     * @param vognID
     * @param con
     * @throws SQLException 
     */
    public boolean removeVogn(int vognID, Connection con) throws SQLException {
        int vognRemoved = 0;
        String SQLString1 = "insert into vognRemoved "
                + "select * from vogn where vognno = " + vognID;
        String SQLString2 = "Delete from vogn where vognno = " + vognID;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;

        //== insert value
        statement = con.prepareStatement(SQLString1);
        statement2 = con.prepareStatement(SQLString2);
        vognRemoved = statement.executeUpdate(); // delete vogn
        statement2.executeUpdate();

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in VognMapper - removeVogn");
            System.out.println(e.getMessage());
        }

        return vognRemoved == 1;
    }

    /**
     * Sletter en tuple i vognRemoved, er kun til brug i tests.
     * 
     * MÅ IKKE BRUGES I PROGRAMMET!
     * 
     * @param vognID
     * @param con
     * @throws SQLException 
     */
    public boolean deleteVogn(int vognID, Connection con) throws SQLException {
        int vognDeleted = 0;

        String SQLString = "Delete from vognRemoved where vognno = " + vognID;
        PreparedStatement statement = null;

        //== insert value
        statement = con.prepareStatement(SQLString);
        vognDeleted = statement.executeUpdate(); // delete vogn

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in VognMapper - deleteVogn");
            System.out.println(e.getMessage());
        }

        return vognDeleted == 1;
    }
}
