/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Kunde;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Saleh
 * 
 * 
 *   private int Cno; 
   private String cName; 
   private String Street; 
   private int Zip;
   private int Phone;
 */
public class KundeMapper {
       public boolean saveNewKunde(Kunde c, Connection con) {
        int rowsInserted = 0;
        String SQLString1 =
                "select orderseq.nextval  "
                + "from dual";
        String SQLString2 =
                "insert into Customers "
                + "values (?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                c.setCno(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, c.getCno());
            statement.setString(2, c.getcName());
            statement.setString(3, c.getStreet());
            statement.setInt(4, c.getZip());
            statement.setInt(5, c.getcTlf());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in CustomersMapper - saveNewKunde");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in MedarbejderMapper - saveNewKunde");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
    
    public Kunde getKunde(int Cno, Connection con) {
        Kunde c = null;
        String SQLString1 = // get order
                "select * "
                + "from Customers "
                + "where mID = ?";
     
        // foreign key match 
        PreparedStatement statement = null;

        try {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, Cno);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                c = new Kunde(Cno,                     
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
      
            }


        } catch (Exception e) {
            System.out.println("Fail in KundeMapper - getKunde1");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in KundeMapper - getKunde2");
                System.out.println(e.getMessage());
            }
        }
        return c;
    }

    //== Insert new order (tuple)


    //== Insert new order detail (tuple)
    
    /*
     *---------------------Update Order-----------------------------------------  
     */
    
    
    public boolean updatemNavn(Kunde c, Connection con)
    {
            int rowUpdated = 0;
            String SQLString = "";
           Kunde origKunde = getKunde(c.getCno(), con);
             if (c.getcName() != origKunde.getcName())
             {
                 SQLString = "UPDATE Medarbejder ID "+
                    "SET ID ="+ c.getcName() +"where Cno = "+ c.getCno() +";";
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in KundeMapper - update Kunde Navn");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in KundeMapper - update Kunde Navn");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    
    public boolean updateKundeStreet(Kunde c, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
           Kunde origKunde = getKunde(c.getCno(), con);
             if (c.getStreet() != origKunde.getStreet())
             {
                 SQLString = "UPDATE Medarbejder Street "+
                    "SET Medarbejder Street ="+ c.getStreet() +"where Cno = "+ c.getCno() +";";
             } 
             else if (c.getStreet() == origKunde.getStreet()){
             
           
          throw new SQLException("KundeMapper - Update Street");
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in VognMapper - updateMedarbejderStilling");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in VognMapper - updateMedarbejderStilling");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    public boolean updateKundeZip(Kunde c, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
           Kunde origKunde = getKunde(c.getCno(), con);
             if (c.getZip() != origKunde.getZip())
             {
                 SQLString = "UPDATE Medarbejder Adresse "+
                    "SET Zip ="+ c.getZip() +"where Cno = "+c.getCno() +";";
             }
             else if (c.getZip() == origKunde.getZip()){
             
           
          throw new SQLException("KundeMapper - Update Medarbejder Zip");
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in MedarbejderMapper - update Medarbejder Addresse");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in MedarbejderMapper - update Medarbejder addresse");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    
      public boolean updateKundePhone(Kunde c, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
            Kunde origKunde = getKunde(c.getCno(), con);
             if (c.getcTlf() != origKunde.getcTlf())
             {
                 SQLString = "UPDATE Telefon nummer "+
                    "SET cTlf ="+ c.getcTlf() +"where Cno = "+ c.getCno() +";";
             }
             else if (c.getcTlf() == origKunde.getcTlf()){
             
           
          throw new SQLException("KundeMapper - Update Kunde Telefon");
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in KundeMapper - Update Kunde Telefon");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in KundeMapper - Update Kunde Telefon");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    
    
    
    //DELETE Medarbejder
    
    
    
    public boolean deleteKunde(Kunde c, Connection con)
    {
        int KundeDeleted = 0;
        String SQLString = "DELETE FROM Customers "+
        "WHERE Cno = "+ c.getCno()+ ";";
    
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            KundeDeleted = statement.executeUpdate(); // delete vogn
        } catch (Exception e) {
            System.out.println("Fail in KundeMapper - deleteMedarbejder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in KundeMapper - deleteMedarbejder");
                System.out.println(e.getMessage());
            }
        }
         return KundeDeleted == 1 ;
    }
}
