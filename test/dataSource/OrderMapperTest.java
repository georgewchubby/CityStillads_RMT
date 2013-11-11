/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Order;
import domain.Pakke;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CP
 */
public class OrderMapperTest {

    public OrderMapperTest() {
    }

    @Before
    public void setUp() {
        OrderMapper instance = new OrderMapper();
        Connection con = new DBConnector().getConnection();
        instance.updateOrderDetails(2, 3, 25, con);
        instance.deleteOrder(11, con);
        instance.deleteOrder(12, con);
//        instance.deleteOrder(13, con);
//        instance.deleteOrder(14, con);
//        instance.deleteOrder(15, con);
//        instance.deleteOrder(16, con);
//        instance.deleteOrder(17, con);
//        instance.deleteOrder(18, con);
    }

    /**
     * Test of saveNewOrder method, of class OrderMapper.
     */
    @Test
    public void testSaveNewOrder() {
        System.out.println("saveNewOrder");
        String r = "23,03,2012";
        String st = "23,04,2012";
        String sl = "28,05,2012";
        Order o = new Order(11, 0005, r, st, sl, "Brisgaard");
//        Pakke p;
//        ArrayList <Pakke> pl = new ArrayList<>();
//        p = new Pakke(00002,00003,45);
//        pl.add(p);
//        p = new Pakke(00002,00004,38);
//        pl.add(p);
//        p = new Pakke(00002,00006,23);
//        pl.add(p);
//        o.addDetail(pl);
        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        //boolean expResult = true;
        boolean result = instance.saveNewOrder(o, con);
        //boolean expResult = true;
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOrder method, of class OrderMapper.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        int ono = 11;
        String r = "20,03,2012";
        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        Order expResult = new Order(11, 00001, 0005, r, null, null, "Brisgaard");
        instance.saveOrder(expResult, con);
        Order result = instance.getOrder(ono, con);
        assertEquals(expResult.getOno(), result.getOno());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewOrderDetail method, of class OrderMapper.
     */
    @Test
    public void testSaveNewOrderDetail() {
        System.out.println("saveNewOrderDetail");
        Pakke p;
        ArrayList<Pakke> pl = new ArrayList<>();
        p = new Pakke(00002, 00003, 45);
        pl.add(p);
        p = new Pakke(00002, 00004, 38);
        pl.add(p);
        p = new Pakke(00002, 00006, 23);
        pl.add(p);

        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        boolean expResult = true;
        boolean result = instance.saveNewOrderDetail(pl, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrder method, of class OrderMapper.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("updateOrder");
        String rec = "20,03,2012";
        String deliv = "23,04,2012";
        String pkup = "20,05,2012";
        Order o = new Order(12, 00001, 0005, rec, "NA", "NA", "Brisgaard");
        Order oUpdate = new Order(12, 00001, 0005, rec, deliv, pkup, "Brisgaard");
        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        instance.saveOrder(o, con);
        System.out.println("Saved " + instance.getOrder(o.getOno(), con));
        boolean expResult = true;
        boolean result = instance.updateOrder(oUpdate, con);
        System.out.println("Updated " + instance.getOrder(o.getOno(), con));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    @Test
//    public void testUpdateOrderAllNew() {
//        System.out.println("updateOrder");
//        String r = "20,03,2012";
//        String r2 = "21,03,2012";
//        String st = "24,04,2012";
//        String sl = "21,05,2012";
//        Order o = new Order(12, 00001, 0005, r, "NA", "NA", "Brisgaard");
//        Order oUpdate = new Order(12, 00002, 0003, r2, st, sl, "Brisgaard2");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        instance.saveOrder(o, con);
//        System.out.println("saved allnew " + instance.getOrder(o.getOno(), con));
//        boolean expResult = true;
//        boolean result = instance.updateOrder(oUpdate, con);
//        System.out.println("updated allnew " + instance.getOrder(o.getOno(), con));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdateOrderNoLocation() {
//        System.out.println("updateOrder");
//        String r = "20,03,2012";
//        String r2 = "21,03,2012";
//        String st = "24,04,2012";
//        String sl = "21,05,2012";
//        Order o = new Order(12, 00001, 0005, r, "NA", "NA", "Brisgaard");
//        Order oUpdate = new Order(12, 00002, 0003, r2, st, sl, "Brisgaard");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        instance.saveOrder(o, con);
//        System.out.println("saved nolocation " + instance.getOrder(o.getOno(), con));
//        boolean expResult = true;
//        boolean result = instance.updateOrder(oUpdate, con);
//        System.out.println("updated nolocation " + instance.getOrder(o.getOno(), con));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdateOrderCnoEnoRecDeliv() {
//        System.out.println("updateOrder");
//        String r = "20,03,2012";
//        String r2 = "21,03,2012";
//        String st = "24,04,2012";
//        String sl = "21,05,2012";
//        Order o = new Order(13, 00001, 0005, r, "NA", sl, "Brisgaard");
//        Order oUpdate = new Order(13, 00002, 0003, r2, st, sl, "Brisgaard");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        instance.saveOrder(o, con);
//        System.out.println("saved CnoEnoRecDeliv " + instance.getOrder(o.getOno(), con));
//        boolean expResult = true;
//        boolean result = instance.updateOrder(oUpdate, con);
//        System.out.println("updated CnoEnoRecDeliv " + instance.getOrder(o.getOno(), con));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdateOrderCnoEnoRec() {
//        System.out.println("updateOrder");
//        String r = "20,03,2012";
//        String r2 = "21,03,2012";
//        String st = "24,04,2012";
//        String sl = "21,05,2012";
//        Order o = new Order(14, 00001, 0005, r, st, sl, "Brisgaard");
//        Order oUpdate = new Order(14, 00002, 0003, r2, st, sl, "Brisgaard");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        instance.saveOrder(o, con);
//        System.out.println("saved cnoenorec " + instance.getOrder(o.getOno(), con));
//        boolean expResult = true;
//        boolean result = instance.updateOrder(oUpdate, con);
//        System.out.println("updated cnoenorec " + instance.getOrder(o.getOno(), con));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdateOrderCnoEno() {
//        System.out.println("updateOrder");
//        String r = "20,03,2012";
//        String r2 = "21,03,2012";
//        String st = "24,04,2012";
//        String sl = "21,05,2012";
//        Order o = new Order(15, 00001, 0005, r, st, sl, "Brisgaard");
//        Order oUpdate = new Order(15, 00002, 0003, r, st, sl, "Brisgaard");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        instance.saveOrder(o, con);
//        System.out.println("saved cnoeno " + instance.getOrder(o.getOno(), con));
//        boolean expResult = true;
//        boolean result = instance.updateOrder(oUpdate, con);
//        System.out.println("updated cnoeno " + instance.getOrder(o.getOno(), con));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//    
//     @Test
//    public void testUpdateOrderCno() {
//        System.out.println("updateOrder");
//        String r = "20,03,2012";
//        String r2 = "21,03,2012";
//        String st = "24,04,2012";
//        String sl = "21,05,2012";
//        Order o = new Order(16, 00001, 0005, r, st, sl, "Brisgaard");
//        Order oUpdate = new Order(16, 00002, 0005, r, st, sl, "Brisgaard");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        instance.saveOrder(o, con);
//        System.out.println("saved cno " + instance.getOrder(o.getOno(), con));
//        boolean expResult = true;
//        boolean result = instance.updateOrder(oUpdate, con);
//        System.out.println("updated cno " + instance.getOrder(o.getOno(), con));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//    
//    @Test
//    public void testUpdateOrderEno() {
//        System.out.println("updateOrder");
//        String r = "20,03,2012";
//        String r2 = "21,03,2012";
//        String st = "24,04,2012";
//        String sl = "21,05,2012";
//        Order o = new Order(17, 00001, 0005, r, st, sl, "Brisgaard");
//        Order oUpdate = new Order(17, 00001, 0006, r, st, sl, "Brisgaard");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        instance.saveOrder(o, con);
//        System.out.println("saved eno " + instance.getOrder(o.getOno(), con));
//        boolean expResult = true;
//        boolean result = instance.updateOrder(oUpdate, con);
//        System.out.println("updated eno " + instance.getOrder(o.getOno(), con));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//    
//    @Test
//    public void testUpdateOrderRec() {
//        System.out.println("updateOrder");
//        String r = "20,03,2012";
//        String r2 = "21,03,2012";
//        String st = "24,04,2012";
//        String sl = "21,05,2012";
//        Order o = new Order(18, 00001, 0005, r, st, sl, "Brisgaard");
//        Order oUpdate = new Order(18, 00001, 0005, r2, st, sl, "Brisgaard");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        instance.saveOrder(o, con);
//        System.out.println("saved rec " + instance.getOrder(o.getOno(), con));
//        boolean expResult = true;
//        boolean result = instance.updateOrder(oUpdate, con);
//        System.out.println("updated rec " + instance.getOrder(o.getOno(), con));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
    /**
     * Test of deleteOrder method, of class OrderMapper.
     */
    @Test
    public void testDeleteOrder() {
        System.out.println("deleteOrder");
        String r = "22,05,2013";
        String st = "29,05,2013";
        String sl = "22,06,2013";
        Order testO = new Order(11, 00001, 0005, r, st, sl, "Brisgaard");

        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        instance.saveOrder(testO, con);
        //boolean expResult = true;
        boolean result = instance.deleteOrder((int) testO.getOno(), con);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrderDetails method, of class OrderMapper.
     */
    @Test
    public void testUpdateOrderDetails() {
        System.out.println("updateOrderDetails");
        int ono = 2;
        int pno = 3;
        int qty = 20;
        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        boolean expResult = true;
        boolean result = instance.updateOrderDetails(ono, pno, qty, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deletePartfromOrder method, of class OrderMapper.
     */
    @Test
    public void testDeletePartfromOrder() {
        System.out.println("deletePartfromOrder");
        int ono = 0;
        int pno = 0;
        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        boolean expResult = false;
        boolean result = instance.deletePartfromOrder(ono, pno, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
