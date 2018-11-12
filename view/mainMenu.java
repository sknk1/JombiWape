/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author USER
 */
public class MainMenu extends JFrame {

    public MainMenu() {
        initComponent();
        lblClicked();
    }

    private void initComponent() {
        this.setSize(1400, 950);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("MainMenu");
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.yellow);

        pnlAlas = new JPanel();
        pnlAlas.setSize(1400, 950);
        pnlAlas.setBounds(0, 0, 1400, 950);
        add(pnlAlas);

        lblAlas = new JLabel();
        lblAlas.setIcon(new ImageIcon(resizeImage("img/Judul_fix.jpg", 1400, 950)));
        pnlAlas.add(lblAlas);

        lblStart = new JLabel();
        lblStart.setBounds(170, 600, 300, 150);
        lblStart.setIcon(new ImageIcon(resizeImage("img/play.png", 300, 150)));
        lblAlas.add(lblStart);

        lblScore = new JLabel();
        lblScore.setBounds(1200, 0, 60, 60);
        lblScore.setIcon(new ImageIcon(resizeImage("img/led.png", 60, 60)));
        lblAlas.add(lblScore);

        lblExit = new JLabel();
        lblExit.setBounds(1300, 0, 60, 60);
        lblExit.setIcon(new ImageIcon(resizeImage("img/exit.png", 60, 60)));
        lblAlas.add(lblExit);
    }
//    private void btnStartClicked(){
//        JOptionPane.showInputDialog(null,"Mouse Clicked");
//        new PilihHero().setVisible(true);
//        this.setVisible(false);
//
//    }

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
    
    private void lblClicked(){
        lblStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PilihHero().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        
        lblScore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ScoreBoard().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        
        lblExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                dispose();
            }
        });
    }
    
    JLabel lblScore;
    JLabel lblExit;
    JPanel pnlAlas;
    JLabel lblAlas;
    JButton btnStart;
    JPanel pnlStart;
    JLabel lblStart;
    JButton btnScore;
    JPanel pnlScore;
    JButton btnExit;
    JPanel pnlExit;
    JPanel pnlJudul;
    JLabel lblJudul;
}
