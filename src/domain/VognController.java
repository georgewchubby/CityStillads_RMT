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
    
    public Vogn getVogn(int vognID) {
        currentVogn = vf.getVogn(vognID);
        return currentVogn;
    }
    
    public boolean saveVogn(Vogn v) {
        currentVogn = v;
        
        boolean saved = vf.saveNewVogn(currentVogn);
        
        return saved;
    }
    
    public boolean updateVognStatus(int vognID, String stat) {
        boolean updated = vf.updateVognStatus(vognID, stat);
        
        return updated;
    }
    
    public boolean updateVognNo(int vognID, int newVognNo) {
        boolean updated = vf.updateVognNo(vognID, newVognNo);
        
        return updated;
    }
    
    public boolean updateVognOno(int vognID, int ono) {
        boolean updated = vf.updateVognOno(vognID, ono);
        
        return updated;
    }
    
    public boolean updateVognDatoFra(int vognID, String from) throws SQLException {
        boolean updated = vf.updateVognDatoFra(vognID, from);
        
        return updated;
    }
    
    public boolean updateVognDatoTil(int vognID, String to) throws SQLException {
        boolean updated = vf.updateVognDatoFra(vognID, to);
        
        return updated;
    }
    
    public boolean deleteVogn(int vognID) {
        boolean deleted = vf.deleteVogn(vognID);
        
        return deleted;
    }
}
