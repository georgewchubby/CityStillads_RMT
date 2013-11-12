package dataSource;

import domain.*;
import java.sql.Connection;
import java.util.ArrayList;

// Encapsulates the Data Source Layer
// Encapsulates connection handling 
// Implemented as a Singleton to provide global access from
// Domain classes and to ensure the use of max one connection
// hau
public class DBFacadeOrderMapper {

    private OrderMapper om;
    private Connection con;
    //== Singleton start
    private static DBFacadeOrderMapper instance;

    private DBFacadeOrderMapper() {
        om = new OrderMapper();
        con = new DBConnector().getConnection();  // the connection will be released upon program 
        // termination by the garbage collector		  
    }

    public static DBFacadeOrderMapper getInstance() {
        if (instance == null) {
            instance = new DBFacadeOrderMapper();
        }
        return instance;
    }
    //== Singleton end

    public Order getOrder(int ono) {
        return om.getOrder(ono, con);
    }

    public boolean saveNewOrder(Order o) {
        return om.saveNewOrder(o, con);
    }

    public boolean updateOrder(Order o) {
        return om.updateOrder(o, con);
    }

    public boolean deleteOrder(int ono) {
        return om.deleteOrder(ono, con);
    }

    public boolean saveNewOrderDetail(ArrayList<Pakke> PakkeListe) {
        return om.saveNewOrderDetail(PakkeListe, con);
    }

    public boolean updateOdetails(int ono, int pno, int qty) {
        return om.updateOrderDetails(ono, pno, qty, con);
    }

    public boolean removePartFromOrder(int ono, int pno) {
        return om.deletePartfromOrder(ono, pno, con);
    }

}
