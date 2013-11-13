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
    private int qty;

    public Part() {
    }

    public Part(int pnum, String pnavn, String pBeskrivelse, int qty) {
        this.pnum = pnum;
        this.pnavn = pnavn;
        this.pbeskrivelse = pBeskrivelse;
        this.qty = qty;
    }

    public Part(String pnavn, String pbeskrivelse, int qty) {
        this.pnavn = pnavn;
        this.pbeskrivelse = pbeskrivelse;
        this.qty = qty;
    }

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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "" + pnum + "   " + pnavn + "   " + pbeskrivelse;
    }
}
