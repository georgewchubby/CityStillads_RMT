package dataSource;

import domain.*;
import java.sql.Connection;

// Encapsulates the Data Source Layer
// Encapsulates connection handling 
// Implemented as a Singleton to provide global access from
// Domain classes and to ensure the use of max one connection
// hau
public class DBFacade {

    private OrderMapper om;
    private Connection con;
    //== Singleton start
    private static DBFacade instance;

    private DBFacade() {
        om = new OrderMapper();
        con = new DBConnector().getConnection();  // the connection will be released upon program 
        // termination by the garbage collector		  
    }

    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
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
    
    public boolean updateOrder(Order o){
        return om.updateOrder(o, con);
    }
    
    public boolean deleteOrder(int ono){
        return om.deleteOrder(ono, con);
    }

    public boolean saveNewOrderDetail(PakkeListe od) {
        return om.saveNewOrderDetail(od, con);
    }
    
    public boolean updateOdetails(int ono,int pno,int qty){
        return om.updateOrderDetails(ono, pno, qty, con);
    }
    
    public boolean removePartFromOrder(int ono,int pno){
        return om.deletePartfromOrder(ono, pno, con);
    }



}
