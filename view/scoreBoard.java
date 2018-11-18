/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class ScoreBoard extends JFrame {

    public ScoreBoard() {
        initComponent();
    }

    private void initComponent() {
        this.setSize(1400, 950);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Score Board");
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.red);
        
        lblAlas = new JLabel();
        lblAlas.setSize(1400, 950);
        lblAlas.setBorder(null);
        lblAlas.setIcon(new ImageIcon(resizeImage("img/map/scoerWpp.png", 1400, 950)));
        this.add(lblAlas);

        btnCancle = new JButton("Cancle");
        btnCancle.setBounds(600, 500, 300, 50);
        btnCancle.setPreferredSize(new Dimension(300, 50));
        btnCancle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MainMenu().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        lblAlas.add(btnCancle);

    }
    JButton btnCancle;
    JLabel lblAlas;
    
     private Image resizeImage(String url, int a, int b) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(a, b, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
}
