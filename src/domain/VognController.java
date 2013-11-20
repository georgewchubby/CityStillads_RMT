package domain;

import dataSource.*;
import java.sql.SQLException;

/**
 *
 * @author joachim
 */
public class VognController {

    private Vogn currentVogn;
    private VDBFacade vf;

    public VognController() {
        currentVogn = null;
        vf = VDBFacade.getInstance();
    }

    public Vogn getVogn(int vognID) throws SQLException {
        currentVogn = vf.getVogn(vognID);
        return currentVogn;
    }

    public boolean saveVogn(Vogn v) throws SQLException {
        currentVogn = v;

        boolean saved = vf.saveNewVogn(currentVogn);

        return saved;
    }

    public boolean updateVognStatus(int vognID, String stat) throws SQLException {
        boolean updated = vf.updateVognStatus(vognID, stat);

        return updated;
    }

    public boolean updateVognOno(int vognID, int ono) throws SQLException {
        boolean updated = vf.updateVognOno(vognID, ono);

        return updated;
    }

    public boolean updateVognDatoFra(int vognID, String from) throws SQLException {
        boolean updated = vf.updateVognDatoFra(vognID, from);

        return updated;
    }

    public boolean updateVognDatoTil(int vognID, String to) throws SQLException {
        boolean updated = vf.updateVognDatoTil(vognID, to);

        return updated;
    }

    public boolean deleteVogn(int vognID) throws SQLException {
        boolean deleted = vf.deleteVogn(vognID);

        return deleted;
    }
}
