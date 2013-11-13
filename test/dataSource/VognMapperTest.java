/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Vogn;
import java.sql.Connection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saleh
 */
public class VognMapperTest {
    
    public VognMapperTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of saveNewVogn method, of class VognMapper.
     */
    @Test
    public void testSaveNewVogn() {
        System.out.println("saveNewVogn");
       String s = "Stor";
        String h = "Hjemme";
        String f = "20,04,2012";
        String sl = "20,12,2012";
        Vogn v = new Vogn(12000000,s,h,1,f,sl);
        Connection con = new DBConnector().getConnection();
        VognMapper instance = new VognMapper();
        boolean result = instance.saveNewVogn(v, con);
        assertTrue(result);
    }

    /**
     * Test of getVogn method, of class VognMapper.
     */
    @Test
    public void testGetVogn() {
        System.out.println("getVogn");
        int vognID = 0;
        Connection con = null;
        VognMapper instance = new VognMapper();
        Vogn expResult = null;
        Vogn result = instance.getVogn(vognID, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVognStatus method, of class VognMapper.
     */
    @Test
    public void testUpdateVognStatus() {
        System.out.println("updateVognStatus");
        Vogn v = null;
        Connection con = null;
        VognMapper instance = new VognMapper();
        boolean expResult = false;
        boolean result = instance.updateVognStatus(v, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVognDatoFra method, of class VognMapper.
     */
    @Test
    public void testUpdateVognDatoFra() throws Exception {
        System.out.println("updateVognDatoFra");
        Vogn v = null;
        Connection con = null;
        VognMapper instance = new VognMapper();
        boolean expResult = false;
        boolean result = instance.updateVognDatoFra(v, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVognDatoTil method, of class VognMapper.
     */
    @Test
    public void testUpdateVognDatoTil() throws Exception {
        System.out.println("updateVognDatoTil");
        Vogn v = null;
        Connection con = null;
        VognMapper instance = new VognMapper();
        boolean expResult = false;
        boolean result = instance.updateVognDatoTil(v, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVognOno method, of class VognMapper.
     */
    @Test
    public void testUpdateVognOno() throws Exception {
        System.out.println("updateVognOno");
        Vogn v = null;
        Connection con = null;
        VognMapper instance = new VognMapper();
        boolean expResult = false;
        boolean result = instance.updateVognOno(v, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteVogn method, of class VognMapper.
     */
    @Test
    public void testDeleteVogn() {
        System.out.println("deleteVogn");
        Vogn v = null;
        Connection con = null;
        VognMapper instance = new VognMapper();
        boolean expResult = false;
        boolean result = instance.deleteVogn(v, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
