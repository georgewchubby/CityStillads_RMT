package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joachim
 */
public class VDBFacade {

    private final VognMapper vm;
    private final Connection con;

    private static VDBFacade instance;

    private VDBFacade() {
        vm = new VognMapper();
        con = new DBConnector().getConnection();
    }

    public static VDBFacade getInstance() {
        if (instance == null) {
            instance = new VDBFacade();
        }
        return instance;
    }
    
    public DefaultTableModel getAllVogn() throws SQLException {
        return vm.getAllVogn(con);
    }

    public Vogn getVogn(int vognID) throws SQLException {
        return vm.getVogn(vognID, con);
    }

    public boolean saveNewVogn(Vogn v) throws SQLException {
        return vm.saveNewVogn(v, con);
    }

    public boolean updateVognStatus(int vognID, String stat) throws SQLException {
        return vm.updateVognStatus(vognID, stat, con);
    }

    public boolean updateVognOno(int vognID, int ono) throws SQLException {
        return vm.updateVognOno(vognID, ono, con);
    }

    public boolean updateVognDatoFra(int vognID, String from) throws SQLException {
        return vm.updateVognDatoFra(vognID, from, con);
    }

    public boolean updateVognDatoTil(int vognID, String to) throws SQLException {
        return vm.updateVognDatoTil(vognID, to, con);
    }

    public boolean deleteVogn(int vognID) throws SQLException {
        return vm.deleteVogn(vognID, con);
    }
}
