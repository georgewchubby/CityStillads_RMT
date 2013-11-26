package dataSource;

import domain.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

//=== Maps between objects and tables
//=== Encapsulates SQL-statements
// hau
public class PartMapper {

    //== Get all parts
    public static DefaultTableModel getAllParts(Connection con) throws SQLException {
        DefaultTableModel dtm = null;

        String SQLString = "select * from parts";

        PreparedStatement statement = null;

        statement = con.prepareStatement(SQLString);
        ResultSet rs = statement.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

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

    //== Load a part
    public Part getPart(int pno, Connection con) throws SQLException {
        Part part = null;
        String SQLString1
                = "select * "
                + "from parts "
                + "where pno = ?";

        PreparedStatement statement = null;

        //=== get Part
        statement = con.prepareStatement(SQLString1);
        statement.setInt(1, pno);     // primary key value
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            part = new Part(pno,
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4));
        }

        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in partMapper - getPart");
                System.out.println(e.getMessage());
            }
        }
        return part;
    }

    //== Insert new Part (tuple)
    public boolean saveNewPartWitnum(Part p, Connection con) throws SQLException {
        int rowsInserted = 0;
        String SQLString
                = "insert into parts "
                + "values (?,?,?,?)";
        PreparedStatement statement = null;

        //== insert tuple
        statement = con.prepareStatement(SQLString);
        statement.setInt(1, p.getPnum());
        statement.setString(2, p.getPnavn());
        statement.setString(3, p.getPbeskrivelse());
        statement.setInt(4, p.getQty());
        rowsInserted = statement.executeUpdate();
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in PartMapper - saveNewPart");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    //== Insert new Part (tuple) auto part number assigned
    public boolean saveNewPart(Part p, Connection con) throws SQLException {
        int rowsInserted = 0;
        String SQLString = "insert into parts (pno, pname, description, qty) "
                + "values (part_seq.nextval,?,?,?)";

        PreparedStatement statement = null;

        //== insert tuple
        statement = con.prepareStatement(SQLString);
        //statement.setInt(1, p.getPnum());
        statement.setString(1, p.getPnavn());
        statement.setString(2, p.getPbeskrivelse());
        statement.setInt(3, p.getQty());
        rowsInserted = statement.executeUpdate();

        {
            try {

                statement.close();

            } catch (SQLException e) {
                System.out.println("Fail in PartMapper - saveNewPart statement close");
                System.out.println(e.getMessage());
                try {
                    throw new Exception("Informative exeption- new part number is = " + p.getPnum());
                } catch (Exception ex) {
                    Logger.getLogger(PartMapper.class.getName()).log(Level.FINE, null, ex);
                }
            }
        }

        return rowsInserted == 1;
    }

    //== Update Part qty
    public boolean updatePartQty(int pnum, int qty, Connection con) throws SQLException {
        int partUpdated = 0;
        String SQLString
                = "Update Parts "
                + "set qty = ? where pno = ?";
        PreparedStatement statement = null;

        //== insert tuple
        statement = con.prepareStatement(SQLString);
        statement.setInt(1, qty);
        statement.setInt(2, pnum);
        partUpdated = statement.executeUpdate();

        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in PartMapper - updatePartQty");
                System.out.println(e.getMessage());
            }
        }
        return partUpdated == 1;
    }

    //== Update part
    public boolean updatePart(Part p, Connection con) throws SQLException {
        int rowUpdated = 0;
        String SQLString = "";
        Part origPart = getPart(p.getPnum(), con);
        if (p.getPnavn().compareTo(origPart.getPnavn()) != 0
                && p.getPbeskrivelse().compareTo(origPart.getPbeskrivelse()) == 0) {
            SQLString = "UPDATE Parts "
                    + "SET pname = '" + p.getPnavn() + "' where pno = " + p.getPnum();
        } else if (p.getPnavn().compareTo(origPart.getPnavn()) == 0
                && p.getPbeskrivelse().compareTo(origPart.getPbeskrivelse()) != 0) {
            SQLString = "UPDATE Parts "
                    + "SET description = '" + p.getPbeskrivelse() + "' where pno = " + p.getPnum();
        } else if (p.getPnavn().compareTo(origPart.getPnavn()) != 0
                && p.getPbeskrivelse().compareTo(origPart.getPbeskrivelse()) != 0) {
            SQLString = "UPDATE Parts "
                    + "SET pname = '" + p.getPnavn() + "', " + "description = '"
                    + p.getPbeskrivelse() + "' where pno = " + p.getPnum();
        }

        PreparedStatement statement = null;

        //== insert value
        statement = con.prepareStatement(SQLString);
        rowUpdated = statement.executeUpdate();

        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in PartMapper - updatePart");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }

    //== Delete part
    public boolean deletePart(int pnum, Connection con) throws SQLException {
        int partDeleted = 0;
        String SQLString = "Delete from parts where pno = " + pnum;
        PreparedStatement statement = null;

        //== insert value
        statement = con.prepareStatement(SQLString);
        partDeleted = statement.executeUpdate(); // delete order

        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in PartMapper - deletePart");
                System.out.println(e.getMessage());
            }
        }
        return partDeleted == 1;
    }
}
