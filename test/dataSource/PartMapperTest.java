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
        Part expResult = new Part(00130, "Bla","pupi caca" ,10);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.saveNewPartWitnum(expResult, con);
        Part result = instance.getPart(expResult.getPnum(), con);
        assertEquals(expResult.getPnum(), result.getPnum());
        // TODO review the generated test code and remove the default call to fail.
        // fail("testGetPart failed");
    }

    /**
     * Test of saveNewPart method, of class PartMapper.
     */
    @Test
    public void testSaveNewPart() {
        System.out.println("saveNewPart");
        Part p = new Part("Bla","pipi caca" ,40);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        boolean expResult = false;
        boolean result = instance.saveNewPart(p, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updatePartQty method, of class PartMapper.
     */
    @Test
    public void testUpdatePartQty() {
        System.out.println("updatePartQty");
        int pnum = 00010;
        int qty = 150;
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.updatePartQty(pnum, qty, con);
        assertEquals(instance.getPart(pnum, con).getQty(), 150);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updatePart method, of class PartMapper.
     */
    @Test
    public void testUpdatePart() {
        System.out.println("updatePart");
        Part p = new Part(00130, "BlaBla", "pupi caca", 10);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        assertFalse(instance.updatePart(p, con));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deletePart method, of class PartMapper.
     */
    @Test
    public void testDeletePart() {
        System.out.println("deletePart");
        int pnum = 99;
        //Part p = new Part(pnum, "Delete", "Del del del", 100);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        //instance.saveNewPartWitnum(p, con);
        instance.deletePart(pnum, con);
        assertEquals(null, instance.getPart(pnum, con).getPnum());
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
