package dataSource;

import domain.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//=== Maps between objects and tables
//=== Encapsulates SQL-statements
// hau
public class PartMapper {
    //== load an order and the associated order details
 
    public Part getPart(long pno, Connection con) {
        Part part = null;
        String SQLString1 = // get order
                "select * "
                + "from parts "
                + "where pno = ?";

        PreparedStatement statement = null;

        try {
            //=== get Part
            statement = con.prepareStatement(SQLString1);
            statement.setLong(1, pno);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                part = new Part(pno,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }

        } catch (Exception e) {
            System.out.println("Fail in PartMapper - getPart");
            System.out.println(e.getMessage());
        } finally // must close statement
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
    public boolean saveNewPart(Part p, Connection con) {
        int rowsInserted = 0;
        String SQLString1 =
                "select partseq.nextval  "
                + "from dual";
        String SQLString2 =
                "insert into parts "
                + "values (?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique 
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                p.setPnum(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setLong(1, p.getPnum());
            statement.setString(2, p.getPnavn());
            statement.setString(3, p.getPbeskrivelse());
            statement.setInt(4, p.getQty());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in PartMapper - saveNewPart");
            System.out.println(e.getMessage());
        } finally // must close statement
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

    //== Update Part qty
    public boolean updatePartQty(int pnum,int qty, Connection con) {
        int partUpdated = 0;
        String SQLString =
                "Update Parts "
                + "set qty = ? where pno = ?";
        PreparedStatement statement = null;

        try {
            //== insert tuple
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, qty);
            statement.setInt(2, pnum);
            partUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in PartMapper - updatePartQty");
            System.out.println(e.getMessage());
        } finally // must close statement
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
    
    /*
     *---------------------Update Part-----------------------------------------  
     */
    
    public boolean updatePart(Part p, Connection con)
    {
            int rowUpdated = 0;
            String SQLString = "";
            Part origPart = getPart(p.getPnum(), con);
             if (p.getPnavn().compareTo(origPart.getPnavn()) !=0 && 
                 p.getPbeskrivelse().compareTo(origPart.getPbeskrivelse()) == 0)
             {
                 SQLString = "UPDATE Parts "+
                    "SET pname ="+ p.getPnavn() +"where ono = "+ p.getPnum() +";";
             }
             if (p.getPnavn().compareTo(origPart.getPnavn()) == 0 && 
                 p.getPbeskrivelse().compareTo(origPart.getPbeskrivelse()) != 0)
             {
                 SQLString = "UPDATE Parts "+
                    "SET description ="+ p.getPbeskrivelse()+"where ono = "+ p.getPnum() +";";
             }else if (p.getPnavn().compareTo(origPart.getPnavn()) != 0 && 
                 p.getPbeskrivelse().compareTo(origPart.getPbeskrivelse()) != 0)
             {
                 SQLString = "UPDATE Order "+
                    "SET pname ="+ p.getPnavn() +","+ "description = "+ 
                     p.getPbeskrivelse() +"where pno = "+ p.getPnum() +";";
             }
        
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in PartMapper - updatePart");
            System.out.println(e.getMessage());
        } finally // must close statement
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
    
    //-----------------------Delete Part--------------------------------------//
    
    public boolean deletePart(int pnum,int qty, Connection con)
    {
        int partDeleted = 0;
        String SQLString = "DELETE  FROM Parts "+
        "WHERE pno = "+ pnum +";";
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            partDeleted = statement.executeUpdate(); // delete order
        } catch (Exception e) {
            System.out.println("Fail in PartMapper - deletePart");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in PartMapper - deletePart");
                System.out.println(e.getMessage());
            }
        }
         return partDeleted == 1 ;
    }
    
    
    
    //------------------Updated  Details--------------------------------//
    
    
    public boolean updateOrderDetails(int pnum,int qty, Connection con)
    {
        
        int partsUpdated = 0;
        
       
        String SQLString = // get order detail
                "update Parts "
                +"set qty = "+ qty
                +"where pno = "+ pnum ;
         
        PreparedStatement statement = null;

        try {
            
            statement = con.prepareStatement(SQLString);
            partsUpdated = statement.executeUpdate();
        
        } catch (Exception e) {
            System.out.println("Fail in PartMapper - updatePartsQTy");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in PartMapper - updatePartsQTy");
                System.out.println(e.getMessage());
            }
        }
        return partsUpdated == 1;
    }
    
    
    
    }

   
    

