/*
 * Måske kan det være nyttig at lave et par klasser mere fEks. boolean isReserveret
 * 
 */
package domain;

/**
 *
 * @author CP
 */
public class Vogn {
    private int vognID;
    private String vType;
    private String status; // montering/afmontering
    private String reserveretFra; //dato
    private String reserveretTil; //dato
    private int ono;
    
    public Vogn(){
        
    }
    
    public Vogn(int vognID, String vType, String status, String reserveretFra, String reserveretTil, int ono) {
        this.vognID = vognID;
        this.vType = vType;
        this.status = status;
        this.reserveretFra = reserveretFra;
        this.reserveretTil = reserveretTil;
        this.ono = ono;
    }

    public int getVognID() {
        return vognID;
    }

    public void setVognID(int vognID) {
        this.vognID = vognID;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReserveretFra() {
        return reserveretFra;
    }

    public void setReserveretFra(String reserveretFra) {
        this.reserveretFra = reserveretFra;
    }

    public String getReserveretTil() {
        return reserveretTil;
    }

    public void setReserveretTil(String reserveretTil) {
        this.reserveretTil = reserveretTil;
    }

    public int getOno() {
        return ono;
    }

    public void setOno(int ono) {
        this.ono = ono;
    }
    
    @Override
    public String toString(){
        return ""+ vognID +"  "+ vType +"  "+ status +"  "+ reserveretFra+"  "+ 
                   reserveretTil +"  "+ ono;    
    }
    
}
