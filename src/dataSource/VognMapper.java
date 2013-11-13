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
  
      public boolean saveNewVogn(Vogn v, Connection con) {
        int rowsInserted = 0;
            String SQLString2 =
                "insert into Vogn "
                + "values (?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, v.getVognID());
            statement.setString(2, v.getvType());
            statement.setString(3, v.getStatus());
            statement.setInt(4, v.getOno());
            statement.setString(5, v.getReserveretFra());
            statement.setString(6, v.getReserveretTil());
        
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in VognMapper - saveNewVogn");
            System.out.println(e.getMessage());
        } finally // must close statement
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
    
    public Vogn getVogn(int vognID, Connection con) {
        Vogn v = null;
        String SQLString1 = // get order
                "select * "
                + "from vogn "
                + "where vognno = ?";
     
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
                        rs.getInt(6),
                        rs.getString(4),
                        rs.getString(5));
                       
      
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


    //== Insert new order detail (tuple)
    
    /*
     *---------------------Update Order-----------------------------------------  
     */
    
    public boolean updateVognStatus(Vogn v, Connection con)
    {
            int rowUpdated = 0;
            String SQLString = "";
            Vogn origVogn = getVogn(v.getVognID(), con);
             if (v.getStatus() != origVogn.getStatus())
             {
                 SQLString = "UPDATE Vogn status "+
                    "SET status ="+ v.getStatus() +"where vognno = "+ v.getVognID() +";";
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in vognMapper - updateVogn");
            System.out.println(e.getMessage());
        } finally // must close statement
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
    
    public boolean updateVognDatoFra(Vogn v, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
            Vogn origVogn = getVogn(v.getVognID(), con);
             if (v.getReserveretFra() != origVogn.getReserveretFra())
             {
                 SQLString = "UPDATE Vogn DatoFra "+
                    "SET datofra ="+ v.getReserveretFra() +"where vognNo = "+ v.getVognID() +";";
             }
             else if (v.getReserveretFra() == origVogn.getReserveretFra()){
             
           
          throw new SQLException("VognMapper - Update Vogn Dato Fra");
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in VognMapper - updateVogndatofra");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in VognMapper - updateVogndatofra");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    public boolean updateVognDatoTil(Vogn v, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
            Vogn origVogn = getVogn(v.getVognID(), con);
             if (v.getReserveretTil() != origVogn.getReserveretTil())
             {
                 SQLString = "UPDATE Vogn DatoTil "+
                    "SET datoTil ="+ v.getReserveretTil() +"where vognno = "+ v.getVognID() +";";
             }
             else if (v.getReserveretTil() == origVogn.getReserveretTil()){
             
           
          throw new SQLException("VognMapper - Update Vogn Dato Til");
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in VognMapper - update Vogn Dato Til");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in VognMapper - update Vogn dato til");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    
      public boolean updateVognOno(Vogn v, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
            Vogn origVogn = getVogn(v.getOno(), con);
             if (v.getVognID() != origVogn.getVognID())
             {
                 SQLString = "UPDATE Vogn vognID "+
                    "SET vognID ="+ v.getVognID() +"where Ono = "+ v.getOno() +";";
             }
             else if (v.getVognID() == origVogn.getVognID()){
             
           
          throw new SQLException("VognMapper - Update Vogn Ono");
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in VognMapper - Update Vogn Ono");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in VognMapper - Update Vogn Ono");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    
    
    //-----------------------Delet Order--------------------------------------//
    
    public boolean deleteVogn(Vogn v, Connection con)
    {
        int vognDeleted = 0;
        String SQLString = "DELETE FROM Vogn "+
        "WHERE vognID = "+ v.getVognID()+ ";";
    
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            vognDeleted = statement.executeUpdate(); // delete vogn
        } catch (Exception e) {
            System.out.println("Fail in VognMapper - deleteOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in VognMapper - deleteOrder");
                System.out.println(e.getMessage());
            }
        }
         return vognDeleted == 1 ;
    }
}
    
    
    
    //------------------Updated Order Details--------------------------------//
    