/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.L_Stat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dataSource.DBConnector;

/**
 *
 * @author CP
 */
public class LagerStatusMapper {
    
    public ArrayList updateLager() {
        int lagerUpdated = 0;
        int available = 0;
        Connection con = new DBConnector().getConnection();
        L_Stat lstat;
        ArrayList<L_Stat> lagerStat = null;
        String SQLString = // gets reserved
                "SELECT P.PNO AS PART_NUMBER,P.QTY AS TOTAL,P.Qty-Pkl.Qty AS AVAILABLE"
                +"FROM Pakkeliste PKL,Parts P WHERE Pkl.Pno = P.Pno;";

         String SQLString_res =      
                 "select PNO,SUM(qty) from PAKKELISTE PKL" 
                +"group by(Pno);";

        PreparedStatement statement = null;

        try {
            //=== get pnum total and availabe
            statement = con.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               lstat = new L_Stat(rs.getInt(1),
                        rs.getInt(2));
               lagerStat.add(lstat);
            }

            //=== get order details
            statement = con.prepareStatement(SQLString_res);
            rs = statement.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < lagerStat.size(); i++) 
                {
                    if(lagerStat.get(i).getPnum() == rs.getInt(1))
                    {
                        lagerStat.get(i).setReserved(rs.getInt(2));
                         
                    }
                }
                
            }
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - crap");
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
        for (int i = 0; i < lagerStat.size(); i++) 
        {
         available = lagerStat.get(i).getTotal()-lagerStat.get(i).getReserved();
         lagerStat.get(i).setAvailable(available);
        }
        
       // return rowsInserted == 1;
       // saveUpdate(lagerStat, con);
        return lagerStat;
    }
}
////public boolean updateReserved(){
////    int lagerUpdated = 0;
////        int available = 0;
////        Connection con = new DBConnector().getConnection();
////    
////    
////    String SQLString_res =      
////                 "select PNO,SUM(qty) from PAKKELISTE PKL" 
////                +"group by(Pno);";
////
////        PreparedStatement statement = null;
////
////        try {
////            //=== get pnum total and availabe
////            statement = con.prepareStatement(SQLString_res);
////            ResultSet rs = statement.executeQuery();
////            while (rs.next()) {
////               lstat = new L_Stat(rs.getInt(1),
////                        rs.getInt(2));
////               lagerStat.add(lstat);
////            }
////
////            //=== get order details
////            statement = con.prepareStatement(SQLString_res);
////            rs = statement.executeQuery();
////            while (rs.next()) {
////                for (int i = 0; i < lagerStat.size(); i++) 
////                {
////                    if(lagerStat.get(i).getPnum() == rs.getInt(1))
////                    {
////                        lagerStat.get(i).setReserved(rs.getInt(2));
////                         
////                    }
////                }
////                
////            }
////        } catch (Exception e) {
////            System.out.println("Fail in OrderMapper - crap");
////            System.out.println(e.getMessage());
////        } finally // must close statement
////        {
////            try {
////                statement.close();
////            } catch (SQLException e) {
////                System.out.println("Fail in OrderMapper - getOrder");
////                System.out.println(e.getMessage());
////            }
////        }
////        for (int i = 0; i < lagerStat.size(); i++) 
////        {
////         available = lagerStat.get(i).getTotal()-lagerStat.get(i).getReserved();
////         lagerStat.get(i).setAvailable(available);
////        }
////        
////       // return rowsInserted == 1;
////       // saveUpdate(lagerStat, con);
////        return lagerStat;
//    }
    
    
    
}
    public boolean saveUpdate(ArrayList<L_Stat> ls, Connection con) {
        int rowsInserted = 0;
        
        String SQLString =
                "insert into stock_status "
                + "values (?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get 
            
for (int i = 0; i < ls.size(); i++) {            
            //== insert tuple
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, ls.get(i).getPnum());
            statement.setInt(2, ls.get(i).getTotal());
            statement.setInt(3, ls.get(i).getAvailable());
            statement.setInt(4, ls.get(i).getReserved());
            rowsInserted = statement.executeUpdate();
}
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

    
    
}
