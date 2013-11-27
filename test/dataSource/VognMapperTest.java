 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Vogn;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Saleh
 */
public class VognMapperTest {

    public VognMapperTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws SQLException {
    }

    @After
    public void tearDown() throws SQLException {
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        instance.deleteVogn(12000000, con);

    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Test of saveNewVogn method, of class VognMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testSaveNewVogn() throws SQLException {
        System.out.println("saveNewVogn");
        String s = "Stor";
        String h = "Hjemme";
        String f = "20-04-2012";
        String sl = "20-12-2012";
        Vogn v = new Vogn(12000000, s, h, 1, f, sl);
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        boolean result = instance.saveNewVogn(v, con);
        assertTrue(result);
    }

    /**
     * Test of saveNewVogn method, of class PartMapper. This test is for the
     * exception.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testSaveNewVognException() throws SQLException {
        System.out.println("saveNewVogn exception");
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        exception.expect(SQLException.class);
        String s = "Stor";
        String h = "Hjemme";
        String f = "20-04-2012";
        String sl = "20-12-2012";
        Vogn v = new Vogn(10000000, s, h, 1, f, sl);
        instance.saveNewVogn(v, con);
    }

    /**
     * Test of getVogn method, of class VognMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetVogn() throws SQLException {
        System.out.println("getVogn");
        String s = "Stor";
        String h = "Hjemme";
        String f = "20-04-2012";
        String sl = "20-12-2012";
        int vognID = 12000000;
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        Vogn expResult = new Vogn(12000000, s, h, 1, f, sl);
        instance.saveNewVogn(expResult, con);
        Vogn result = instance.getVogn(vognID, con);
        assertEquals(expResult.getVognID(), result.getVognID());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of updateVognStatus method, of class VognMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testUpdateVognStatus() throws SQLException {
        System.out.println("updateVognStatus");
        String type = "Stor";
        String stat = "Hjemme";
        String fra = "20-04-2012";
        String til = "20-12-2012";
        String statU = "Ude";
        Vogn v = new Vogn(12000000, type, stat, 1, fra, til);

        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        instance.saveNewVogn(v, con);
        boolean expResult = true;
        boolean result = instance.updateVognStatus(12000000, statU, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of updateVognDatoFra method, of class VognMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testUpdateVognDatoFra() throws SQLException {
        System.out.println("updateVognDatoFra");

        String type = "Stor";
        String stat = "Hjemme";
        String fra = "20-04-2012";
        String til = "20-12-2012";
        String FraU = "22-05-2011";
        Vogn v = new Vogn(12000000, type, stat, 1, fra, til);
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        instance.saveNewVogn(v, con);
        boolean expResult = true;
        boolean result = instance.updateVognDatoFra(12000000, FraU, con);
        assertEquals(expResult, result);

    }

    /**
     * Test of updateVognDatoTil method, of class VognMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testUpdateVognDatoTil() throws SQLException {
        System.out.println("updateVognDatoTil");

        String type = "Stor";
        String stat = "Hjemme";
        String fra = "20-04-2012";
        String til = "20-12-2012";
        String TIL = "23-06-2012";
        Vogn v = new Vogn(12000000, type, stat, 1, fra, til);
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        instance.saveNewVogn(v, con);
        boolean expResult = true;
        boolean result = instance.updateVognDatoTil(12000000, TIL, con);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateVognOno method, of class VognMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testUpdateVognOno() throws SQLException {
        System.out.println("updateVognOno");
        String type = "Stor";
        String stat = "Hjemme";
        int Ono = 5;
        String fra = "20-04-2012";
        String til = "20-12-2012";

        Vogn v = new Vogn(12000000, type, stat, 1, fra, til);
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        instance.saveNewVogn(v, con);
        boolean expResult = true;
        boolean result = instance.updateVognOno(12000000, Ono, con);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteVogn method, of class VognMapper.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testDeleteVogn() throws SQLException {
        System.out.println("deleteVogn");
        String type = "Stor";
        String stat = "Hjemme";
        String fra = "20-04-2012";
        String til = "20-12-2012";

        Vogn v = new Vogn(12000000, type, stat, 1, fra, til);

        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        instance.saveNewVogn(v, con);
        boolean expResult = true;
        boolean result = instance.deleteVogn(12000000, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllVogn method, of class VognMapper.
     * 
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetAllVogn() throws SQLException {
        System.out.println("getAllVogn");
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        int expResult = 6;
        int result = instance.getAllVogn(con).getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
