/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author CP
 */
public class Team {
    private ArrayList <Medarbejder> montøre;
    private Medarbejder formand;

    public ArrayList<Medarbejder> getMontøre() {
        return montøre;
    }

    public void setMontøre(ArrayList<Medarbejder> montøre) {
        this.montøre = montøre;
    }

    public Medarbejder getFormand() {
        return formand;
    }

    public void setFormand(Medarbejder formand) {
        this.formand = formand;
    }
    
    public String montøreToString(){
        String montør = "";
        for (int i = 0; i < montøre.size(); i++) {
            montør = ""+ ((Medarbejder)montøre.get(i)).toString();
        }
        return montør;
    }
    
    @Override
    public String toString(){
        
        return "Formand: "+ formand.getmID()  +"  "+ formand.getmNavn()+"\n"+
                "Montøre: \n"+ montøreToString();
        
    }
    
}
