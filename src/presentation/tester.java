/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.sql.Connection;
import dataSource.LagerStatusMapper;
import domain.L_Stat;
import java.util.ArrayList;

/**
 *
 * @author CP
 */
public class tester {
    public static void main(String[] args) {
        LagerStatusMapper instance = new LagerStatusMapper();
        
        //System.out.println(instance.updateLager());
        ArrayList<L_Stat> ls = instance.updateLager();
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }
        
    }
    
}
