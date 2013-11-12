/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Saleh
 */
public class Kunde {
   private int Cno; 
   private String cName; 
   private String Street; 
   private int Zip;
   private int cTlf;
   
   
   public Kunde(){
}
   public Kunde(int Cno, String cName,String Street,int zip,int phone){
   this.Cno= Cno;
   this.cName = cName;
   this.Street = Street;
   this.Zip = Zip;
   this.cTlf = cTlf;
   
   }

    public int getCno() {
        return Cno;
    }

    public void setCno(int Cno) {
        this.Cno = Cno;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public int getZip() {
        return Zip;
    }

    public void setZip(int Zip) {
        this.Zip = Zip;
    }

    public int getcTlf() {
        return cTlf;
    }

    public void setcTlf(int cTlf) {
        this.cTlf = cTlf;
    }

    @Override
    public String toString() {
        return "Kunde{" + "Cno=" + Cno + ", cName=" + cName + ", Street=" + Street + ", Zip=" + Zip + ", cTlf=" + cTlf + '}';
    }

  

   
}

