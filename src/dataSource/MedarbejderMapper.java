/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Medarbejder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Saleh
 */
public class MedarbejderMapper {
    
      public boolean saveNewMedarbejder(Medarbejder m, Connection con) {
        int rowsInserted = 0;
        String SQLString1 =
                "select orderseq.nextval  "
                + "from dual";
        String SQLString2 =
                "insert into Employees "
                + "values (?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                m.setmID(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, m.getmID());
            statement.setString(2, m.getStilling());
            statement.setString(3, m.getmNavn());
            statement.setString(4, m.getmAddr());
            statement.setString(5, m.getmTlf());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in MedarbejderMapper - saveNewMedarbejder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in MedarbejderMapper - saveNewMedarbejder");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
    
    public Medarbejder getMedarbejder(int mID, Connection con) {
        Medarbejder m = null;
        String SQLString1 = // get order
                "select * "
                + "from Employees "
                + "where mID = ?";
     
        // foreign key match 
        PreparedStatement statement = null;

        try {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, mID);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                m = new Medarbejder(mID,                     
                        rs.getString(2),
                        rs.getString(3),
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
        return m;
    }

    //== Insert new order (tuple)


    //== Insert new order detail (tuple)
    
    /*
     *---------------------Update Order-----------------------------------------  
     */
    
    
    public boolean updatemNavn(Medarbejder m, Connection con)
    {
            int rowUpdated = 0;
            String SQLString = "";
            Medarbejder origMedarbejder = getMedarbejder(m.getmID(), con);
             if (m.getmNavn() != origMedarbejder.getmNavn())
             {
                 SQLString = "UPDATE Medarbejder ID "+
                    "SET ID ="+ m.getmNavn() +"where mID = "+ m.getmID() +";";
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in MedarbejderMapper - updateMedarbejderNavn");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in MedarbejderMapper - updateMedarbejderNavn");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    
    public boolean updateMedarbejderStilling(Medarbejder m, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
            Medarbejder origMedarbejder = getMedarbejder(m.getmID(), con);
             if (m.getStilling() != origMedarbejder.getStilling())
             {
                 SQLString = "UPDATE Medarbejder Stilling "+
                    "SET Medarbejder stilling ="+ m.getStilling() +"where mID = "+ m.getmID() +";";
             } 
             else if (m.getStilling() == origMedarbejder.getStilling()){
             
           
          throw new SQLException("MedarbejderMapper - Update Stilling");
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
    public boolean updateMedarbejdermAdr(Medarbejder m, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
            Medarbejder origMedarbejder = getMedarbejder(m.getmID(), con);
             if (m.getmAddr() != origMedarbejder.getmAddr())
             {
                 SQLString = "UPDATE Medarbejder Adresse "+
                    "SET mAddr ="+ m.getmAddr() +"where mID = "+ m.getmID() +";";
             }
             else if (m.getmAddr() == origMedarbejder.getmAddr()){
             
           
          throw new SQLException("MedarbejderMapper - Update Medarbejder addresse");
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
    
      public boolean updateMedarbejdermTlf(Medarbejder m, Connection con) throws SQLException
    {
            int rowUpdated = 0;
            String SQLString = "";
            Medarbejder origMedarbejder = getMedarbejder(m.getmID(), con);
             if (m.getmTlf() != origMedarbejder.getmTlf())
             {
                 SQLString = "UPDATE Vogn DatoTil "+
                    "SET datoTil ="+ m.getmTlf() +"where vognno = "+ m.getmID() +";";
             }
             else if (m.getmTlf() == origMedarbejder.getmTlf()){
             
           
          throw new SQLException("MedarbejderMapper - Update Vogn Ono");
             }
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in MedarbejderMapper - Update Medarbejder Telefon");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in MedarbejderMapper - Update Medarbejder Telefon");
                System.out.println(e.getMessage());
            }
        }
        return rowUpdated == 1;
    }
    
    
    
    //DELETE Medarbejder
    
    
    
    public boolean deleteMedarbejder(Medarbejder m, Connection con)
    {
        int MedarbejderDeleted = 0;
        String SQLString = "DELETE FROM Employees "+
        "WHERE mID = "+ m.getmID()+ ";";
    
        PreparedStatement statement = null;

        try {
            //== insert value
            statement = con.prepareStatement(SQLString);
            MedarbejderDeleted = statement.executeUpdate(); // delete vogn
        } catch (Exception e) {
            System.out.println("Fail in MedarbejderMapper - deleteMedarbejder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in MedarbejderMapper - deleteMedarbejder");
                System.out.println(e.getMessage());
            }
        }
         return MedarbejderDeleted == 1 ;
    }
}
