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
    boolean status = true;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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
        int y = tempat;

        this.setLocation(x, y);

        while (true) {
            if (x < 1700) {
                try {
                    x = this.getLocation().x + 10;
                    this.setLocation(x, y);
                    repaint();
                    this.lblAlas.repaint();
                    Thread.sleep(50);
                } catch (Exception e) {

                }
            }else{
                status = false;
                setStatus(status);
                break;
            }
        }
    }
}