/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author USER
 */
public class playSiang extends JFrame{
    public playSiang(){
        initComponent();
    }
    
    private void initComponent(){
        this.setSize(1700, 950);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Game");
        this.setLayout(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.green);
        
        pilihHero pl = new pilihHero();
        String a = pl.getNama_usr();
        System.out.println(a);
        pnlAlas = new JPanel();
        pnlAlas.setSize(1700, 950);
        pnlAlas.setBounds(0, 0, 1700, 950);
        add(pnlAlas);
        
        lblAlas = new JLabel();
        lblAlas.setIcon(new ImageIcon(resizeImage("img/map/siangf.jpg",1700,950)));
        pnlAlas.add(lblAlas);
        
        pnlMain = new JPanel();
        pnlMain.setSize(1600,720);
        pnlMain.setBackground(new Color(0,0,0,0));
        pnlMain.setBounds(100, 150, 1600, 720);
        pnlMain.setLayout(null);
        lblAlas.add(pnlMain);
        
        lblHero = new JLabel();
        lblHero.setIcon(new ImageIcon(resizeImage("img/main.png",105,144)));
        lblHero.setBounds(200, 0, 105, 144);  
        pnlMain.add(lblHero);
        
        this.addKeyListener(new KeyAdapter(){ // UNTUK COBA GERAK KIRI KANAN ATAS BAWAH
           @Override
           public void keyPressed(KeyEvent e) {
                int x =0;
                int y =0;
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:{
                    x = 0;
                    y = -144;
                    break;
                }case KeyEvent.VK_DOWN:{
                    x = 0;
                    y = 144;
                    break;
                }default :
                    break;  
           }
                lblHero.setLocation(lblHero.getX() + x, lblHero.getY() + y);
                repaint();
           }
       });
        
        
    }

    private Image resizeImage(String url,int x,int y){
        Image dimg = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(x,y,Image.SCALE_SMOOTH);
        } catch (IOException ex){
            ex.printStackTrace(System.err);
        }
        return dimg;
    }

    
    JPanel pnlAlas;
    JLabel lblAlas;
    JPanel pnlMain;
    JPanel pnlRumah;
    JLabel lblHero;
    
}
