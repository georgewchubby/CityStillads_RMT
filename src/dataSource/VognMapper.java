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
    
    //== Get all vogne
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

    //== Save a new vogn
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
            {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Fail in VognMapper - saveNewVogn");
                    System.out.println(e.getMessage());
                }
            }
            return rowsInserted == 1;
        }
    }

    //== Load a vogn
    public Vogn getVogn(int vognID, Connection con) throws SQLException {
        Vogn v = null;
        String SQLString1 = // get order
                "select * "
                + "from vogn "
                + "where vognno = ?";
        PreparedStatement statement = null;

        //=== get order
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
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in VognMapper - getVogn");
                System.out.println(e.getMessage());
            }
        }
        return v;
    }

    //== Update status of a vogn
    public boolean updateVognStatus(int vognID, String stat, Connection con) throws SQLException {
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
            if (origStat.compareTo(stat) != 0) {
                statement = con.prepareStatement(SQLString2);
                statement.setString(1, stat);
                statement.setInt(2, vognID);
                rowUpdated = statement.executeUpdate();
            }
        }
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in vognMapper - updateVogn");
                System.out.println(e.getMessage());
            }
        }

        return rowUpdated == 1;
    }

    //== Update ono of a vogn
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
            System.out.println("origOno   " + origOno);
            if (origOno != Ono) {
                statement = con.prepareStatement(SQLString2);
                statement.setInt(1, Ono);
                statement.setInt(2, vognID);
                rowUpdated = statement.executeUpdate();
            }
        }
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in vognMapper - updateVogn");
                System.out.println(e.getMessage());
            }
        }

        return rowUpdated == 1;
    }

    //== Update from date of a vogn
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

        //=== get order
        statement = con.prepareStatement(SQLString1);
        statement.setInt(1, vognID);
//            statement.setString(2,stat );
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            origFrom = rs.getString(1);
            System.out.println("origFrom   " + origFrom);
            if (origFrom.compareTo(From) != 0) {
                statement = con.prepareStatement(SQLString2);
                statement.setString(1, From);
                statement.setInt(2, vognID);
                rowUpdated = statement.executeUpdate();
            }
        }
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in vognMapper - updateFromDato");
                System.out.println(e.getMessage());
            }
        }

        return rowUpdated == 1;
    }

    //== Update to date of a vogn
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
        try {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, vognID);
//            statement.setString(2,stat );
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                origTo = rs.getString(1);
                System.out.println("origTo   " + origTo);
                if (origTo.compareTo(To) != 0) {
                    statement = con.prepareStatement(SQLString2);
                    statement.setString(1, To);
                    statement.setInt(2, vognID);
                    rowUpdated = statement.executeUpdate();
                }
            }
        } catch (Exception e) {
            System.out.println("Fail in vognMapper - updateFromDato");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in vognMapper - updateFromDato");
                System.out.println(e.getMessage());
            }
        }

        return rowUpdated == 1;
    }

    //== Delete a vogn
    public boolean deleteVogn(int vognID, Connection con) throws SQLException {
        int vognDeleted = 0;
        String SQLString = "DELETE FROM Vogn "
                + "WHERE vognno = " + vognID;

        PreparedStatement statement = null;

        //== insert value
        statement = con.prepareStatement(SQLString);
        vognDeleted = statement.executeUpdate(); // delete vogn

        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in VognMapper - deleteOrder");
                System.out.println(e.getMessage());
            }
        }
        return vognDeleted == 1;
    }
}
