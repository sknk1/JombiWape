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
public class Bullet extends JLabel implements Runnable {

    JLabel lblAlas;
    int tempat;

    public void setTempat(int tempat) {
        this.tempat = tempat;
    }

    public Bullet(JLabel lblAlas) {
        this.setVisible(true);
        this.lblAlas = lblAlas;
    }

    public Bullet(JLabel lblAlas, int tempat) {
        this.setVisible(true);
        this.lblAlas = lblAlas;
        this.tempat = tempat;
    }

    @Override
    public void run() {
        int x = 200;
        int y = tempat + 35;

        this.setLocation(x, y);

        while (true) {
            if (x < 1800) {
                try {
                    x = this.getLocation().x + 20;
                    this.setLocation(x, y);
                    repaint();
                    this.lblAlas.repaint();
                    Thread.sleep(100);
                } catch (Exception e) {

                }
            }
        }
    }
}
