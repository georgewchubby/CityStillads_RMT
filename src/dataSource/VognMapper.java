package dataSource;

import domain.Vogn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//=== Maps between objects and tables
//=== Encapsulates SQL-statements
// hau
public class VognMapper {
    //== load a vogn and the associated vogn details

    public Vogn getVogn(int vognID, Connection con) {
        Vogn v = null;
        String SQLString1 = // get order
                "select * "
                + "from orders "
                + "where ono = ?";

        // foreign key match 
        PreparedStatement statement = null;

        try {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, vognID);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                v = new Vogn(vognID,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }

        } catch (Exception e) {
            System.out.println("Fail in VognMapper - getVogn");
            System.out.println(e.getMessage());
        } finally // must close statement
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

    //== Insert new order (tuple)
    public boolean saveNewVogn(Vogn v, Connection con) {
        int rowsInserted = 0;
        String SQLString1
                = "select orderseq.nextval  "
                + "from dual";
        String SQLString2
                = "insert into orders "
                + "values (?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                o.setOno(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, o.getOno());
            statement.setInt(2, o.getCustomerNo());
            statement.setInt(3, o.getEmployeeNo());
            statement.setString(4, o.getReceived());
            statement.setString(5, o.getStartDato());
            statement.setString(6, o.getSlutDato());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - saveNewOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - saveNewOrder");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    /*
     *---------------------Update Vogn-----------------------------------------  
     */
    public boolean updateVogn(Vogn o, Connection con) {
        int rowUpdated = 0;
        String SQLString = "";
        Vogn origVogn = getVogn(o.getVognID(), con);
        if (o.getCustomerNo() != origOrder.getCustomerNo()
                && o.getEmployeeNo() == origOrder.getEmployeeNo()) {
            SQLString = "UPDATE Order "
                    + "SET cno =" + o.getCustomerNo() + "where ono = " + o.getOno() + ";";
        }
        if (o.getCustomerNo() == origOrder.getCustomerNo()
                && o.getEmployeeNo() != origOrder.getEmployeeNo()) {
            SQLString = "UPDATE Order "
                    + "SET eno =" + o.getEmployeeNo() + "where ono = " + o.getOno() + ";";
        } else if (o.getCustomerNo() != origOrder.getCustomerNo()
                && o.getEmployeeNo() != origOrder.getEmployeeNo()) {
            SQLString = "UPDATE Order "
                    + "SET cno =" + o.getCustomerNo() + "," + "eno = "
                    + o.getEmployeeNo() + "where ono = " + o.getOno() + ";";
        }

        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - updateOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - updateOrder");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }

    //-----------------------Delet Order--------------------------------------//
    public boolean deleteOrder(int ono, Connection con) {
        int orderDeleted = 0;
        String SQLString = "DELETE  FROM Order "
                + "WHERE ono = " + ono + ";";
        String SQLString2 = "DELETE FROM odetails WHERE ono = " + ono;
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString2);
            orderDeleted = statement.executeUpdate(); // delete order details
            statement = con.prepareStatement(SQLString);
            orderDeleted = statement.executeUpdate(); // delete order
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - deleteOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - deleteOrder");
                System.out.println(e.getMessage());
            }
        }
        return orderDeleted == 1;
    }
}
