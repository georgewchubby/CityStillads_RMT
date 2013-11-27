/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Part;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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
    public void tearDown() throws SQLException {
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.deletePart(30, con);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Test of getPart method, of class PartMapper. The method saveNewPartWitnum
     * is also tested here.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetPart() throws SQLException {
        System.out.println("getPart");
        Part p = new Part(30, "GetPart", "Get this part", 10);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.saveNewPartWitnum(p, con);
        Part result = instance.getPart(p.getPnum(), con);
        assertEquals(result.getPnum(), p.getPnum());
        // TODO review the generated test code and remove the default call to fail.
        // fail("testGetPart failed");
    }

    /**
     * Test of saveNewPart method, of class PartMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testSaveNewPart() throws SQLException {
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
     * Test of saveNewPartWitnum method, of class PartMapper. This test is for
     * the exception.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testSaveNewPartWitnumException() throws SQLException {
        System.out.println("saveNewPartWitnum exception");
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        exception.expect(SQLException.class);
        Part p = new Part(65099, "No work", "This shouldn't work", 1);
        instance.saveNewPartWitnum(p, con);
    }

    /**
     * Test of updatePartQty method, of class PartMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testUpdatePartQty() throws SQLException {
        System.out.println("updatePartQty");
        int pnum = 30;
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
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testUpdatePart() throws SQLException {
        System.out.println("updatePart");
        Part p1 = new Part(30, "Update", "Update this", 10);
        Part p2 = new Part(30, "Updated", "Updated this", 10);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.saveNewPartWitnum(p1, con);
        instance.updatePart(p2, con);
        assertEquals("Updated", instance.getPart(30, con).getPnavn());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deletePart method, of class PartMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testDeletePart() throws SQLException {
        System.out.println("deletePart");
        int pnum = 30;
        Part p = new Part(pnum, "Delete", "Del del del", 100);
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        instance.saveNewPartWitnum(p, con);
        instance.deletePart(pnum, con);
        assertNull(instance.getPart(pnum, con));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllParts method, of class PartMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetAllParts() throws SQLException {
        System.out.println("getAllParts");
        Connection con = new DBConnector().getConnection();
        PartMapper instance = new PartMapper();
        int expResult = 4;
        int result = instance.getAllParts(con).getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
}
