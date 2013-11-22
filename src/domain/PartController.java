package domain;

import dataSource.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joachim
 */
public class PartController {

    private Part currentPart;
    private PDBFacade pf;

    public PartController() {
        currentPart = null;
        pf = PDBFacade.getInstance();
    }
    
    public DefaultTableModel getAllParts() throws SQLException {
        return pf.getAllParts();
    }

    public Part getPart(int pno) throws SQLException {
        currentPart = pf.getPart(pno);
        return currentPart;
    }

    public boolean saveNewPartWitnum(Part p) throws SQLException {
        currentPart = p;

        boolean saved = pf.saveNewPartWitnum(currentPart);

        return saved;
    }

    public boolean saveNewPart(Part p) throws SQLException {
        currentPart = p;

        boolean saved = pf.saveNewPart(currentPart);

        return saved;
    }

    public boolean updatePartQty(int pnum, int qty) throws SQLException {
        boolean updated = pf.updatePartQty(pnum, qty);

        return updated;
    }

    public boolean updatePart(Part p) throws SQLException {
        currentPart = p;

        boolean updated = pf.updatePart(currentPart);

        return updated;
    }

    public boolean deletePart(int pnum) throws SQLException {
        boolean deleted = pf.deletePart(pnum);

        return deleted;
    }

}
