package dataSource;

import domain.Order;
import domain.PakkeListe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//=== Maps between objects and tables
//=== Encapsulates SQL-statements
// hau
public class OrderMapper {
    //== load an order and the associated order details
 
    public Order getOrder(int ono, Connection con) {
        Order o = null;
        String SQLString1 = // get order
                "select * "
                + "from orders "
                + "where ono = ?";
        String SQLString2 = // get order details
                "select od.pno, od.qty "
                + "from odetails od "
                + "where od.ono = ? ";         // foreign key match 
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
                        rs.getString(6));
            }

            //=== get order details
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, ono);          // foreign key value
            rs = statement.executeQuery();
            while (rs.next()) {
                o.addDetail(new PakkeListe(
                        ono,
                        rs.getInt(1),
                        rs.getInt(2)));
            }
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

    //== Insert new order (tuple)
    public boolean saveNewOrder(Order o, Connection con) {
        int rowsInserted = 0;
        String SQLString1 =
                "select orderseq.nextval  "
                + "from dual";
        String SQLString2 =
                "insert into orders "
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

    //== Insert new order detail (tuple)
    public boolean saveNewOrderDetail(PakkeListe od, Connection con) {
        int rowsInserted = 0;
        String SQLString =
                "insert into odetails "
                + "values (?,?,?)";
        PreparedStatement statement = null;

        try {
            //== insert tuple
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, od.getOno());
            statement.setInt(2, od.getPno());
            statement.setInt(3, od.getQty());
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
        return rowsInserted == 1;
    }
    
    /*
     *---------------------Update Order-----------------------------------------  
     */
    
    public boolean updateOrder(Order o, Connection con)
    {
            int rowUpdated = 0;
            String SQLString = "";
            Order origOrder = getOrder(o.getOno(), con);
             if (o.getCustomerNo() != origOrder.getCustomerNo() && 
                 o.getEmployeeNo() == origOrder.getEmployeeNo())
             {
                 SQLString = "UPDATE Order "+
                    "SET cno ="+ o.getCustomerNo() +"where ono = "+ o.getOno() +";";
             }
             if (o.getCustomerNo() == origOrder.getCustomerNo() && 
                 o.getEmployeeNo() != origOrder.getEmployeeNo())
             {
                 SQLString = "UPDATE Order "+
                    "SET eno ="+ o.getEmployeeNo() +"where ono = "+ o.getOno() +";";
             }else if (o.getCustomerNo() != origOrder.getCustomerNo() && 
                 o.getEmployeeNo() != origOrder.getEmployeeNo())
             {
                 SQLString = "UPDATE Order "+
                    "SET cno ="+ o.getCustomerNo() +","+ "eno = "+ 
                     o.getEmployeeNo() +"where ono = "+ o.getOno() +";";
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
    
    public boolean deleteOrder(int ono, Connection con)
    {
        int orderDeleted = 0;
        String SQLString = "DELETE  FROM Order "+
        "WHERE ono = "+ ono +";";
        String SQLString2 = "DELETE FROM odetails WHERE ono = "+ ono;
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
         return orderDeleted == 1 ;
    }
    
    
    
    //------------------Updated Order Details--------------------------------//
    
    
    public boolean updateOrderDetails(int ono,int pno,int qty, Connection con)
    {
        
        int detailsUpdated = 0;
        
       
        String SQLString = // get order detail
                "update odetails "
                +"set qty = "+ qty
                +"where ono = "+ ono +"and pno = "+ pno;
         
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
    public boolean deletePartfromOrder(int ono, int pno, Connection con)
    {
     int partsRemovedFromOrder = 0;
     String SQLString = "DELETE FROM odetails WHERE ono = "+ ono +"and pno = "+ pno;
        PreparedStatement statement = null;

        try {
            
            statement = con.prepareStatement(SQLString);
            partsRemovedFromOrder = statement.executeUpdate(); // delete order details line
           
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - deletePartFromOrder");
            System.out.println(e.getMessage());
        } finally 
        {
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

   
    

