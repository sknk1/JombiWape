/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import view.PlaySiang;

/**
 *
 * @author USER
 */
public class ThreadKeluar implements Runnable {

    PlaySiang myFrame;

    public ThreadKeluar(PlaySiang myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void run() {
        while (true) {
//            
//            Zombie z = new Zombie(myFrame.lblAlas);
//            z.setIcon(new ImageIcon(resizeImage("img/hero/play/sniperFix.jpg", 105, 144)));
//            lblAlas.add(z);
//            Thread t = new Thread(z);
//            t.start();

        }

    }

    private Image resizeImage(String url, int x, int y) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
}