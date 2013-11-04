/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author CP
 */
public class Part {
    private int pnum;
    private String pnavn;
    private String pbeskrivelse;
    public Part(){}

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getPnavn() {
        return pnavn;
    }

    public void setPnavn(String pnavn) {
        this.pnavn = pnavn;
    }

    public String getPbeskrivelse() {
        return pbeskrivelse;
    }

    public void setPbeskrivelse(String pbeskrivelse) {
        this.pbeskrivelse = pbeskrivelse;
    }
    
    @Override
    public String toString(){
        return "" +pnum +"   "+ pnavn +"   "+ pbeskrivelse;
    }
    
    
}
