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
public class mainMenu extends JFrame {
    public mainMenu(){
        initComponent();
    }
    
    private void initComponent(){
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
        lblAlas.setIcon(new ImageIcon(resizeImage("img/pvz.jpg",1400,950)));
        pnlAlas.add(lblAlas);         
        
        pnlJudul = new JPanel();
        pnlJudul.setSize(950, 755);
        pnlJudul.setBackground(Color.red);
        pnlJudul.setBounds(450, -20, 950, 755);
        lblAlas.add(pnlJudul);   
        lblJudul = new JLabel();
        lblJudul.setIcon(new ImageIcon(resizeImage("img/contohJudul.png",950,755)));
        pnlJudul.add(lblJudul);
    
        btnStart = new JButton("Start Game");
        btnStart.setBounds(70, 50, 300, 50);
        btnStart.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new pilihHero().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        btnStart.setPreferredSize(new Dimension (300,50));
        lblAlas.add(btnStart);
        
        lblStart = new JLabel();
        lblStart.setSize(300, 50);
        btnStart.add(lblStart);
        
        btnScore = new JButton("List Score");
        btnScore.setBounds(70, 150, 300, 50);
        btnScore.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new scoreBoard().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        btnScore.setPreferredSize(new Dimension (300,50));
        lblAlas.add(btnScore);

        btnExit = new JButton("Exit");
        btnExit.setBounds(70, 250, 300, 50);
        btnExit.setPreferredSize(new Dimension (300,50));
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               setVisible(false);
               dispose();
            }
        });
        lblAlas.add(btnExit);
    }
//    private void btnStartClicked(){
//        JOptionPane.showInputDialog(null,"Mouse Clicked");
//        new pilihHero().setVisible(true);
//        this.setVisible(false);
//
//    }
   
    private Image resizeImage(String url,int a,int b){
        Image dimg = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(a,b,Image.SCALE_SMOOTH);
        } catch (IOException ex){
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
 
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
