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
        OrderMapper instance = new OrderMapper();
        Connection con = new DBConnector().getConnection();
        instance.deleteOrder(11, con);
        
    }
    
    @Before
    public void setUp() {
        OrderMapper instance = new OrderMapper();
        Connection con = new DBConnector().getConnection();
        instance.deleteOrder(11, con);
    }

    /**
     * Test of saveOrder method, of class OrderMapper.
     */
//    @Test
//    public void testSaveOrder() {
//        System.out.println("saveOrder");
//        Date r = new Date(20,03,2012);
//        Date st = new Date(20,04,2012);
//        Date sl = new Date(25,06,2012);
//        Order o = new Order(00011,00001,0005,r,st,sl,"Brisgaard");
//        Connection con = new DBConnector().getConnection();
//        OrderMapper instance = new OrderMapper();
//        boolean result = instance.saveOrder(o, con);
//        boolean expResult = true;
//        assertEquals(result,expResult);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of saveNewOrder method, of class OrderMapper.
     */
    @Test
    public void testSaveNewOrder() {
        System.out.println("saveNewOrder");
        String r = "23,03,2012";
        String st = "23,04,2012";
        String sl = "28,05,2012";
        Order o = new Order(11,0005,r,st,sl,"Brisgaard");
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
        Order expResult = new Order(11,00001,0005,r,null,null,"Brisgaard");
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
        ArrayList <Pakke> pl = new ArrayList<>();
        p = new Pakke(00002,00003,45);
        pl.add(p);
        p = new Pakke(00002,00004,38);
        pl.add(p);
        p = new Pakke(00002,00006,23);
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
    public void testUpdateOrder()  {
        System.out.println("updateOrder");
        String r = "20,03,2012";
        String st = "23,04,2012";
        String sl = "20,05,2012";
        Order o = new Order(11,00001,0005,r,"NA","NA","Brisgaard");
        Order oUpdate = new Order(11,00001,0005,r,st,sl,"Brisgaard");
        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        instance.saveOrder(o, con);
        System.out.println("saved " + instance.getOrder(o.getOno(), con));
        boolean expResult = true;
        boolean result = instance.updateOrder(oUpdate, con);
        System.out.println("updated " + instance.getOrder(o.getOno(), con));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteOrder method, of class OrderMapper.
     */
    @Test
    public void testDeleteOrder() {
        System.out.println("deleteOrder");
        String r = "22,05,2013";
        String st = "29,05,2013";
        String sl = "22,06,2013";
        Order testO = new Order(11,00001,0005,r,st,sl,"Brisgaard");
        
        Connection con = new DBConnector().getConnection();
        OrderMapper instance = new OrderMapper();
        instance.saveOrder(testO, con);
        //boolean expResult = true;
        boolean result = instance.deleteOrder((int)testO.getOno(), con);
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
