/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class Line extends JLabel implements Runnable{
 
    JLabel lblZombie;
    int tempat;
    public Line(JLabel lblAlas,int tempat) {
        this.setVisible(true);
        this.lblZombie = lblAlas;
        this.tempat = tempat;
    }
    
    @Override
    public void run() {
        while(){
            
        }
    }
    
}
