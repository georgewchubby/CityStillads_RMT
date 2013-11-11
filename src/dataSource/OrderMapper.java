package dataSource;

import domain.Order;
import domain.Pakke;
import domain.Pakke;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

//=== Maps between objects and tables
//=== Encapsulates SQL-statements
// hau
public class OrderMapper {
    //== load an order and the associated order details

    public boolean saveOrder(Order o, Connection con) {
        int rowsInserted = 0;
        String SQLString
                = "insert into orders "
                + "values (?,?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique ono

            statement = con.prepareStatement(SQLString);
            statement.setLong(1, o.getOno());
            statement.setLong(2, o.getCustomerNo());
            statement.setInt(3, o.getEmployeeNo());
            statement.setString(4, o.getReceived());
            statement.setString(5, o.getStartDato());
            statement.setString(6, o.getSlutDato());
            statement.setString(7, o.getProjectLocation());

            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - saveOrder test");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - saveOrder on close");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    //== Insert new order (tuple)
    public boolean saveNewOrder(Order o, Connection con) {
        int rowsInserted = 0;
        String SQLString1
                = "select ono_seq.nextval "
                + "from orders";
        String SQLString2
                = "insert into orders "
                + "values (?,?,?,?,?,?,?)";
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
            statement.setString(7, o.getProjectLocation());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - saveNewOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - saveNewOrder on close");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    // fixed pakkeListen som blevet til Pakke klasse
    public Order getOrder(int ono, Connection con) {
        Order o = null;
        ArrayList<Pakke> pl = null;
        String SQLString1 = // get order
                "select * "
                + "from orders "
                + "where ono = ?";
        String SQLString2 = // get Pakkeliste
                "select pk.pno, pk.qty "
                + "from Pakkeliste pk "
                + "where pk.ono = ? ";         // foreign key match 
        PreparedStatement statement = null;

        try {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, ono);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                o = new Order(ono,
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }

            //=== get order details
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, ono);          // foreign key value
            rs = statement.executeQuery();

            while (rs.next()) {
                Pakke p = new Pakke(
                        ono,
                        rs.getInt(1),
                        rs.getInt(2));
                pl.add(p);
            }
            o.addDetail(pl);
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - getOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - getOrder");
                System.out.println(e.getMessage());
            }
        }
        return o;
    }

    //== Insert new order detail (tuple)
    public boolean saveNewOrderDetail(ArrayList<Pakke> pl, Connection con) {
        int rowsInserted = 0;
        String SQLString
                = "insert into pakkeliste "
                + "values (?,?,?)";
        PreparedStatement statement = null;
        for (int i = 0; i < pl.size(); i++) {

            try {
                //== insert tuple
                statement = con.prepareStatement(SQLString);
                statement.setLong(1, pl.get(i).getOno());
                statement.setLong(2, pl.get(i).getPno());
                statement.setInt(3, pl.get(i).getQty());
                rowsInserted = statement.executeUpdate();

            } catch (Exception e) {
                System.out.println("Fail in OrderMapper - saveNewOrderDetail");
                System.out.println(e.getMessage());
            } finally // must close statement
            {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Fail in OrderMapper - saveNewOrderDetail");
                    System.out.println(e.getMessage());
                }
            }
        }
        return rowsInserted == 1;
    }

    /*
     *---------------------Update Order-----------------------------------------  
     */
    public boolean updateOrder2(Order o, Connection con) {
        int rowUpdated = 0;
        String SQLString = "";
        Order origOrder = getOrder(o.getOno(), con);

        if (origOrder.getCustomerNo() != o.getCustomerNo()
                && origOrder.getEmployeeNo() != o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) != 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) != 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) != 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) != 0) {

            SQLString = "UPDATE ORDERS SET "
                    + "CNO = " + o.getCustomerNo() + ", "
                    + "ENO = " + o.getEmployeeNo() + ", "
                    + "RECEIVED = '" + o.getReceived() + "', "
                    + "DELIV_DATE = '" + o.getStartDato() + "', "
                    + "PKUP_DATE = '" + o.getSlutDato() + "', "
                    + "PROJECT_LOCATION = '" + o.getProjectLocation() + "'"
                    + " where ONO = " + o.getOno();

        } else if (origOrder.getCustomerNo() != o.getCustomerNo()
                && origOrder.getEmployeeNo() != o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) != 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) != 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) != 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) == 0) {

            SQLString = "UPDATE ORDERS SET "
                    + "CNO = " + o.getCustomerNo() + ", "
                    + "ENO = " + o.getEmployeeNo() + ", "
                    + "RECEIVED = '" + o.getReceived() + "', "
                    + "DELIV_DATE = '" + o.getStartDato() + "', "
                    + "PKUP_DATE = '" + o.getSlutDato() + "'"
                    + "where ONO =" + o.getOno();

        } else if (origOrder.getCustomerNo() != o.getCustomerNo()
                && origOrder.getEmployeeNo() != o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) != 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) != 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) == 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) == 0) {

            SQLString = "UPDATE ORDERS SET "
                    + "CNO = " + o.getCustomerNo() + ", "
                    + "ENO = " + o.getEmployeeNo() + ", "
                    + "RECEIVED = '" + o.getReceived() + "', "
                    + "DELIV_DATE = '" + o.getStartDato() + "'"
                    + "where ONO = " + o.getOno();

        } else if (origOrder.getCustomerNo() != o.getCustomerNo()
                && origOrder.getEmployeeNo() != o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) != 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) == 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) == 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) == 0) {

            SQLString = "UPDATE ORDERS SET "
                    + "CNO = " + o.getCustomerNo() + ", "
                    + "ENO = " + o.getEmployeeNo() + ", "
                    + "RECEIVED = '" + o.getReceived() + "'"
                    + "where ONO =" + o.getOno();

        } else if (origOrder.getCustomerNo() != o.getCustomerNo()
                && origOrder.getEmployeeNo() != o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) == 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) == 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) == 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) == 0) {

            SQLString = "UPDATE ORDERS SET "
                    + "CNO = " + o.getCustomerNo() + ", "
                    + "ENO = " + o.getEmployeeNo()
                    + "where ONO =" + o.getOno();

        } else if (origOrder.getCustomerNo() != o.getCustomerNo()
                && origOrder.getEmployeeNo() == o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) == 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) == 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) == 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) == 0) {

            SQLString = "UPDATE ORDERS SET "
                    + "CNO = " + o.getCustomerNo()
                    + "where ONO = " + o.getOno();

        } else if (origOrder.getCustomerNo() == o.getCustomerNo()
                && origOrder.getEmployeeNo() == o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) == 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) != 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) != 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) == 0) {

            SQLString = "UPDATE ORDERS SET "
                    + "DELIV_DATE = '" + o.getStartDato()
                    + "', PKUP_DATE = '" + o.getSlutDato() + "'"
                    + "WHERE ONO = " + o.getOno();

        } else if (origOrder.getCustomerNo() == o.getCustomerNo()
                && origOrder.getEmployeeNo() != o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) == 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) == 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) == 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) == 0) {
            
            SQLString = "UPDATE ORDERS SET "
                    + "ENO = " + o.getEmployeeNo()
                    + "where ONO = " + o.getOno();
            
        }else if (origOrder.getCustomerNo() == o.getCustomerNo()
                && origOrder.getEmployeeNo() == o.getEmployeeNo()
                && origOrder.getReceived().compareTo(o.getReceived()) != 0
                && origOrder.getStartDato().compareTo(o.getStartDato()) == 0
                && origOrder.getSlutDato().compareTo(o.getSlutDato()) == 0
                && origOrder.getProjectLocation().compareTo(o.getProjectLocation()) == 0) {
            
            SQLString = "UPDATE ORDERS SET "
                    + "RECEIVED = '" + o.getReceived() + "'"
                    + "where ONO = " + o.getOno();
        }
        
        PreparedStatement statement = null;

        try {
            //== insert value----- Unit of work start
            con.setAutoCommit(false);
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - updateOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                con.commit();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - updateOrder");
                System.out.println(e.getMessage());
            }
        }

        return rowUpdated == 1;
    }
    
    public boolean updateOrder(Order o, Connection con) {
        int rowUpdated = 0;
        String SQLString = "";
        Order origOrder = getOrder(o.getOno(), con);
        
        if (origOrder.getOno() == o.getOno()
                && origOrder.getCustomerNo() == o.getCustomerNo()
                && origOrder.getEmployeeNo() == o.getEmployeeNo()) {
            SQLString = "UPDATE ORDERS SET "
                    + "RECEIVED = '" + o.getReceived() + "', "
                    + "DELIV_DATE = '" + o.getStartDato() + "', "
                    + "PKUP_DATE = '" + o.getSlutDato() + "', "
                    + "PROJECT_LOCATION = '" + o.getProjectLocation() + "'"
                    + " where ONO = " + o.getOno();
        }
        PreparedStatement statement = null;

        try {
            //== insert value----- Unit of work start
            con.setAutoCommit(false);
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - updateOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                con.commit();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - updateOrder");
                System.out.println(e.getMessage());
            }
        }

        return rowUpdated == 1;
    }
    
    //-----------------------Delete Order-with unit-of-work-------------------//

    public boolean deleteOrder(int ono, Connection con) {

        int orderDeleted = 0;
        String SQLString = "delete from orders where ono = " + ono;
        String SQLString2 = "DELETE FROM PAKKELISTE WHERE ono = " + ono;
        PreparedStatement statement = null;

        try {
            //== insert value TRANSACTION START
            con.setAutoCommit(false);
            statement = con.prepareStatement(SQLString2);
            orderDeleted = statement.executeUpdate(); // delete order details
            statement = con.prepareStatement(SQLString);
            orderDeleted = statement.executeUpdate(); // deletes order
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - deleteOrder");
            System.out.println(e.getMessage());
        } finally // must close statement - TRANSACTION END
        {
            try {
                con.commit();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - deleteOrder");
                System.out.println(e.getMessage());
            }
        }
        return orderDeleted == 1;
    }

    //------------------Updated Order Details--------------------------------//
    public boolean updateOrderDetails(int ono, int pno, int qty, Connection con) {
        int detailsUpdated = 0;

        String SQLString = // get order detail
                "update pakkeliste "
                + "set qty = " + qty
                + " where ono = " + ono
                + " and pno = " + pno;

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(SQLString);
            detailsUpdated = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - updateOrderDetails");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - updateOrderDetails");
                System.out.println(e.getMessage());
            }
        }
        return detailsUpdated == 1;
    }

    //-------------removes a part order from an order-------------------------//
    public boolean deletePartfromOrder(int ono, int pno, Connection con) {
        int partsRemovedFromOrder = 0;
        String SQLString = "DELETE FROM PAKKELISTE WHERE ono = " + ono + "and pno = " + pno;
        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(SQLString);
            partsRemovedFromOrder = statement.executeUpdate(); // delete order details line

        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - deletePartFromOrder");
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - deletePartFromOrder");
                System.out.println(e.getMessage());
            }
        }

        return partsRemovedFromOrder == 1;
    }

}
