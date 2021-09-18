/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.main;

import javax.swing.JOptionPane;

/**
 *
 * @author bell
 */
public class Utils {

    public static void displayMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static int askChoice(String msg) {
        int c = JOptionPane.showConfirmDialog(null, msg);
        
        return c;
    }

}
