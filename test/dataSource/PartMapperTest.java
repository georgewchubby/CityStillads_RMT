/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import domain.Part;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joachim
 */
public class PartMapperTest {
    
    public PartMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPart method, of class PartMapper.
     */
    @Test
    public void testGetPart() {
        System.out.println("getPart");
        long pno = 0L;
        Connection con = null;
        PartMapper instance = new PartMapper();
        Part expResult = null;
        Part result = instance.getPart(pno, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewPart method, of class PartMapper.
     */
    @Test
    public void testSaveNewPart() {
        System.out.println("saveNewPart");
        Part p = null;
        Connection con = null;
        PartMapper instance = new PartMapper();
        boolean expResult = false;
        boolean result = instance.saveNewPart(p, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePartQty method, of class PartMapper.
     */
    @Test
    public void testUpdatePartQty() {
        System.out.println("updatePartQty");
        int pnum = 0;
        int qty = 0;
        Connection con = null;
        PartMapper instance = new PartMapper();
        boolean expResult = false;
        boolean result = instance.updatePartQty(pnum, qty, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePart method, of class PartMapper.
     */
    @Test
    public void testUpdatePart() {
        System.out.println("updatePart");
        Part p = null;
        Connection con = null;
        PartMapper instance = new PartMapper();
        boolean expResult = false;
        boolean result = instance.updatePart(p, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePart method, of class PartMapper.
     */
    @Test
    public void testDeletePart() {
        System.out.println("deletePart");
        int pnum = 0;
        int qty = 0;
        Connection con = null;
        PartMapper instance = new PartMapper();
        boolean expResult = false;
        boolean result = instance.deletePart(pnum, qty, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrderDetails method, of class PartMapper.
     */
    @Test
    public void testUpdateOrderDetails() {
        System.out.println("updateOrderDetails");
        int pnum = 0;
        int qty = 0;
        Connection con = null;
        PartMapper instance = new PartMapper();
        boolean expResult = false;
        boolean result = instance.updateOrderDetails(pnum, qty, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
