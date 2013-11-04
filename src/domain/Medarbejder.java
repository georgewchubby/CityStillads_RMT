/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author CP
 */
public class Medarbejder {
    private int mID;
    private String Stilling;
    private String mNavn;
    private String mAddr;
    private String mTlf;
    
    public Medarbejder(){
        
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getStilling() {
        return Stilling;
    }

    public void setStilling(String Stilling) {
        this.Stilling = Stilling;
    }

    public String getmNavn() {
        return mNavn;
    }

    public void setmNavn(String mNavn) {
        this.mNavn = mNavn;
    }

    public String getmAddr() {
        return mAddr;
    }

    public void setmAddr(String mAddr) {
        this.mAddr = mAddr;
    }

    public String getmTlf() {
        return mTlf;
    }

    public void setmTlf(String mTlf) {
        this.mTlf = mTlf;
    }
    
    @Override
    public String toString(){
        return ""+ mID +"   "+ mNavn +"   "+ Stilling +"   "+ mAddr +"   "+ mTlf;
    }
    
    
    
    
    
}
