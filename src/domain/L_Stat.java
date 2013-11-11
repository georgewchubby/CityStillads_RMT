/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author CP
 */
public class L_Stat {
    private int pnum;
    private int total;
    private int available;
    private int reserved;
    
    public L_Stat(int pnum,int total)
    {
        this.pnum = pnum;
        this.total = total;
        
        
    }
    
    

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }
    
    public String toString(){
        
        return "" + pnum + reserved + available + total;
    }
    
}
