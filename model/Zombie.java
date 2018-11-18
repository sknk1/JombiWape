/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Zombie extends JLabel implements Runnable {

    JLabel lblAlas;
    int pnj;
    int xx;
    private boolean status = true;

    public void setXx(int xx) {
        this.xx = xx;
    }

    public Zombie(JLabel lblAlas, int pnj) {
        this.setVisible(true);
        this.lblAlas = lblAlas;
        this.pnj = pnj;
    }

    @Override
    public void run() {
        Random rand = new Random();

//        int sleepRandom = rand.nextInt(5)*1000;
//        try {
//            Thread.sleep(sleepRandom);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Zombie.class.getName()).log(Level.SEVERE, null, ex);
//        }
        int a = 0;
        int x = pnj;
        int y = 0;
        a = rand.nextInt(5);
        if (a == 3) {
            y = 576;
        } else if (a == 0) {
            y = 144;
        } else if (a == 1) {
            y = 288;
        } else if (a == 2) {
            y = 432;
        } else {
            y = 720;
        }
        this.setLocation(x, y);

        while (true) {
            if (x > 300) {
                try {
                    setXx(x);
                    x = this.getLocation().x - 20;
                    System.out.println("ZOB"+getXx());
                    this.setLocation(x, y);
                    repaint();
                    this.lblAlas.repaint();
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            } else {
                setXx(300);
                status = false;
                break;
            }
        }
        setStatus(status);
        JOptionPane.showMessageDialog(null, "GAME OVER");
    }

    public int getXx() {
        return xx;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
