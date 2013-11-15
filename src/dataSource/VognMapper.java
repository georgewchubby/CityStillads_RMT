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

    public Vogn getVogn(int vognID, Connection con) {
        Vogn v = null;
        String SQLString1 = // get order
                "select * "
                + "from vogn "
                + "where vognno = ?";
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
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
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
    /*
     *---------------------Update Vogn-----------------------------------------  
     */

    public boolean updateVognStatus(int vognID, String stat, Connection con) {
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
        try {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, vognID);
//            statement.setString(2,stat );
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                origStat = rs.getString(1);
                System.out.println("origstat   " + origStat);
                if (origStat.compareTo(stat) != 0) {
                    statement = con.prepareStatement(SQLString2);
                    statement.setString(1, stat);
                    statement.setInt(2, vognID);
                    rowUpdated = statement.executeUpdate();
                }
            }
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

//    Unødvendig metode
//    
//    public boolean updateVognNO(int vognID, int NewvognNO, Connection con) {
//        int rowUpdated = 0;
//        int origno;
//
//        String SQLString1 = // querry status
//                "select vognno "
//                + "from vogn "
//                + "where vognno = ?";
//
//        String SQLString2 = "UPDATE vogn "
//                + "SET vognno = ? "
//                + "WHERE vognno = ? "; // updates status if not match
//
//        PreparedStatement statement = null;
//        try {
//            //=== get order
//            statement = con.prepareStatement(SQLString1);
//            statement.setInt(1, vognID);
////            statement.setString(2,stat );
//            ResultSet rs = statement.executeQuery();
//
//            if (rs.next()) {
//                origno = rs.getInt(1);
//                System.out.println("origNO  " + origno);
//                if (NewvognNO != vognID) {
//                    statement = con.prepareStatement(SQLString2);
//                    statement.setInt(1, NewvognNO);
//                    statement.setInt(2, vognID);
//                    rowUpdated = statement.executeUpdate();
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Fail in vognMapper - updateVogn");
//            System.out.println(e.getMessage());
//        } finally // must close statement
//        {
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                System.out.println("Fail in vognMapper - updateVogn");
//                System.out.println(e.getMessage());
//            }
//        }
//
//        return rowUpdated == 1;
//    }
    public boolean updateVognOno(int vognID, int Ono, Connection con) {
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
        try {
            //=== get order
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

    //-----------------------Delete Vogn--------------------------------------//
    public boolean deleteVogn(int vognID, Connection con) {
        int vognDeleted = 0;
        String SQLString = "DELETE FROM Vogn "
                + "WHERE vognno = " + vognID;

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
        return vognDeleted == 1;
    }
}
