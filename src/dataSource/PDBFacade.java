package dataSource;

import domain.*;
import java.sql.Connection;

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

    public Part getPart(int pno) {
        return pm.getPart(pno, con);
    }

    public boolean saveNewPartWitnum(Part p) {
        return pm.saveNewPartWitnum(p, con);
    }

    public boolean saveNewPart(Part p) {
        return pm.saveNewPart(p, con);
    }

    public boolean updatePartQty(int pnum, int qty) {
        return pm.updatePartQty(pnum, qty, con);
    }

    public boolean updatePart(Part p) {
        return pm.updatePart(p, con);
    }

    public boolean deletePart(int pnum) {
        return pm.deletePart(pnum, con);
    }
}
