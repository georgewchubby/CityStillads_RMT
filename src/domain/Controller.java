package domain;

import dataSource.*;
//=== hau

public class Controller {

    private Order currentOrder;       // Order in focus
    private DBFacade dbf;

    public Controller() {
        currentOrder = null;
        dbf = DBFacade.getInstance();
    }

    public Order getOrder(int ono) {
        currentOrder = dbf.getOrder(ono);
        return currentOrder;
    }

    public Order createNewOrder(int cno, int eno, String recDate, String delDate, String pkupDate, String plocation) {
        //== create order object with tmp ono=0
        currentOrder = new Order(0, cno, eno, recDate, delDate, pkupDate,plocation);

        //== save and get DB-generated unique ono
        boolean status = dbf.saveNewOrder(currentOrder);
        if (!status) {
            currentOrder = null;
        }

        return currentOrder;
    }
    
    public boolean isOrderUpdated(Order o)
    { 
        boolean updated = dbf.updateOrder(o);
        if(updated){
            currentOrder = o;
        }
        return updated;
    }
    
    public boolean isOrderDeleted(int ono){
        return dbf.deleteOrder(ono);
    }

    public boolean addOrderDetail(int partNo, int qty) {
        boolean status = false;
        if (currentOrder != null) {
            PakkeListe od = new PakkeListe(currentOrder.getOno(), partNo, qty);
            currentOrder.addDetail(od);
            status = dbf.saveNewOrderDetail(od);
        }
        return status;
    }

    public String getOrderDetailsToString() {
        if (currentOrder != null) {
            return currentOrder.detailsToString();
        } else {
            return null;
        }
    }
    
    public boolean updateODetails(int ono,int pno,int qty){
        return dbf.updateOdetails(ono, pno, qty);
    }

    public boolean removePartFromOrder(int ono,int pno){
        return dbf.removePartFromOrder(ono, pno);
    }


}
