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

    /**
     * Henter alle dele fra databasen
     *
     * @param con
     * @return DefaultTableModel med alle rækker fra tabellen parts
     * @throws SQLException
     */
    public static DefaultTableModel getAllParts(Connection con) throws SQLException {
        DefaultTableModel dtm = null;

        String SQLString = "select * from parts";

        PreparedStatement statement = null;

        statement = con.prepareStatement(SQLString);
        ResultSet rs = statement.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Del nummer");
        columnNames.add("Navn");
        columnNames.add("Beskrivelse");
        columnNames.add("Antal");
        int columnCount = metaData.getColumnCount();

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
     * Henter en tuple fra tabellen parts
     *
     * @param pno
     * @param con
     * @return Et part-objekt med pno'et der bliver givet som parameter
     * @throws SQLException
     */
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
        ResultSet rs = statement.executeQuery(); //get part
        if (rs.next()) {
            part = new Part(pno,
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4));
        }
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in partMapper - getPart");
            System.out.println(e.getMessage());
        }

        return part;
    }

    /**
     * Gemmer en tuple i databasen baseret på det part-object der bliver oprettet
     *
     * @param p
     * @param con
     * @throws SQLException
     */
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
        rowsInserted = statement.executeUpdate(); // save new part

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in PartMapper - saveNewPart");
            System.out.println(e.getMessage());
        }
        return rowsInserted == 1;
    }

    /**
     * Gemmer en ny tuple hvor pno bliver tildelt automatisk
     *
     * @param p
     * @param con
     * @throws SQLException
     */
    public boolean saveNewPart(Part p, Connection con) throws SQLException {
        int rowsInserted = 0;
        String SQLString = "insert into parts (pno, pname, description, qty) "
                + "values (part_seq.nextval,?,?,?)";

        PreparedStatement statement = null;

        //== insert tuple
        statement = con.prepareStatement(SQLString);
        statement.setString(1, p.getPnavn());
        statement.setString(2, p.getPbeskrivelse());
        statement.setInt(3, p.getQty());
        rowsInserted = statement.executeUpdate(); // save new part

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
        return rowsInserted == 1;
    }

    /**
     * Opdaterer qty af part-objektet og gemmer det i databasen
     *
     * @param pno
     * @param qty
     * @param con
     * @throws SQLException
     */
    public boolean updatePartQty(int pno, int qty, Connection con) throws SQLException {
        int partUpdated = 0;
        String SQLString
                = "Update Parts "
                + "set qty = ? where pno = ?";
        PreparedStatement statement = null;

        //== insert tuple
        statement = con.prepareStatement(SQLString);
        statement.setInt(1, qty);
        statement.setInt(2, pno);
        partUpdated = statement.executeUpdate(); // update qty

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in PartMapper - updatePartQty");
            System.out.println(e.getMessage());
        }

        return partUpdated == 1;
    }

    /**
     * Opdaterer beskrivelsen af part-objektet og gemmer den i databasen
     *
     * @param p
     * @param con
     * @throws SQLException
     */
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
        rowUpdated = statement.executeUpdate(); // update part

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in PartMapper - updatePart");
            System.out.println(e.getMessage());
        }

        return rowUpdated == 1;
    }

    /**
     * Flytter tuplen med det givne pno til partsRemoved tabellen og 
     * sletter den fra parts
     *
     * @param pno
     * @param con
     * @throws SQLException
     */
    public boolean removePart(int pno, Connection con) throws SQLException {
        int partRemoved = 0;
        
        String SQLString1 = "insert into partsRemoved " + 
                "select * from parts where pno = " + pno;
        String SQLString2 = "Delete from parts where pno = " + pno;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;

        //== insert value
        statement = con.prepareStatement(SQLString1);
        statement2 = con.prepareStatement(SQLString2);
        partRemoved = statement.executeUpdate(); // remove part
        statement2.executeUpdate(); // delete part

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in PartMapper - removePart");
            System.out.println(e.getMessage());
        }

        return partRemoved == 1;
    }
    
    /**
     * Sletter en tuple i partsRemoved, er kun til brug i tests.
     * 
     * MÅ IKKE BRUGES I PROGRAMMET!
     *
     * @param pno
     * @param con
     * @throws SQLException
     */
    public boolean deletePart(int pno, Connection con) throws SQLException {
        int partDeleted = 0;

        String SQLString = "Delete from partsRemoved where pno = " + pno;
        PreparedStatement statement = null;

        //== insert value
        statement = con.prepareStatement(SQLString);
        partDeleted = statement.executeUpdate(); // delete part

        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fail in PartMapper - deletePart");
            System.out.println(e.getMessage());
        }

        return partDeleted == 1;
    }
}
