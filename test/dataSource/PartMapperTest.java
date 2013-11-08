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
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.deletePart(70000, con);
        instance.deletePart(80000, con);
        instance.deletePart(90000, con);
    }

    /**
     * Test of getPart method, of class PartMapper.
     */
    @Test
    public void testGetPart() {
        System.out.println("getPart");
        Part p = new Part(80000, "GetPart", "Get this part", 10);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.saveNewPartWitnum(p, con);
        assertEquals("GetPart", instance.getPart(80000, con).getPnavn());
        // TODO review the generated test code and remove the default call to fail.
        // fail("testGetPart failed");
    }

    /**
     * Test of saveNewPart method, of class PartMapper.
     */
    @Test
    public void testSaveNewPart() {
        System.out.println("saveNewPart");
        Part p = new Part("NewPart", "Save this part", 10);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        boolean expResult = true;
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
        int pnum = 70000;
        int qty = 150;
        Part p = new Part(pnum, "UpdateQty", "Update the qty", 10);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.saveNewPartWitnum(p, con);
        instance.updatePartQty(pnum, qty, con);
        assertEquals(150, instance.getPart(pnum, con).getQty());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updatePart method, of class PartMapper.
     */
    @Test
    public void testUpdatePart() {
        System.out.println("updatePart");
        Part p1 = new Part(90000, "Update", "Update this", 10);
        Part p2 = new Part(90000, "Updated", "Updated this", 11);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.saveNewPartWitnum(p1, con);
        instance.updatePart(p2, con);
        assertEquals("Updated", instance.getPart(90000, con).getPnavn());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deletePart method, of class PartMapper.
     */
    @Test
    public void testDeletePart() {
        System.out.println("deletePart");
        int pnum = 99999;
        Part p = new Part(pnum, "Delete", "Del del del", 100);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.saveNewPartWitnum(p, con);
        instance.deletePart(pnum, con);
        assertNull(instance.getPart(pnum, con));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
