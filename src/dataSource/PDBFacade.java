package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joachim
 */
public class PDBFacade {

    private final PartMapper pm;
    private final Connection con;

    private static PDBFacade instance;

    private PDBFacade() {
        pm = new PartMapper();
        con = new DBConnector().getConnection();
    }

    public static PDBFacade getInstance() {
        if (instance == null) {
            instance = new PDBFacade();
        }
        return instance;
    }
    
    public DefaultTableModel getAllParts() throws SQLException {
        return pm.getAllParts(con);
    }

    public Part getPart(int pno) throws SQLException {
        return pm.getPart(pno, con);
    }

    public boolean saveNewPartWitnum(Part p) throws SQLException {
        return pm.saveNewPartWitnum(p, con);
    }

    public boolean saveNewPart(Part p) throws SQLException {
        return pm.saveNewPart(p, con);
    }

    public boolean updatePartQty(int pnum, int qty) throws SQLException {
        return pm.updatePartQty(pnum, qty, con);
    }

    public boolean updatePart(Part p) throws SQLException {
        return pm.updatePart(p, con);
    }

    public boolean deletePart(int pnum) throws SQLException {
        return pm.deletePart(pnum, con);
    }
}
