/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author USER
 */
public class pilihHero extends JFrame{
    public pilihHero(){
        initComponent();
    }
    
     private void initComponent(){
        this.setSize(1400, 950);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Pilih Hero");
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.yellow);
        
        pnlAlas = new JPanel();
        pnlAlas.setSize(1400, 950);
        pnlAlas.setBounds(0, -10, 1400, 950);
        add(pnlAlas);
        
        lblAlas = new JLabel();
        lblAlas.setIcon(new ImageIcon(resizeImage("img/map/dirt.jpg",1400,950)));
        pnlAlas.add(lblAlas);  
        
        pnlBg = new JPanel();
        pnlBg.setLayout(null);
        pnlBg.setSize(1200, 890);
        pnlBg.setBounds(100, 70, 1200, 890);
        pnlBg.setBackground(new Color(0,0,0,100));
        lblAlas.add(pnlBg);
        
        pnlHeroS = new JPanel();
        pnlHeroS.setSize(380, 430);
        pnlHeroS.setBounds(10, -10, 380, 430);
        pnlBg.add(pnlHeroS);
        lblHeroS = new JLabel();
        lblHeroS.setIcon(new ImageIcon(resizeImage("img/hero/sniper.png", 380, 430)));
        pnlHeroS.add(lblHeroS);
        
        pnlHeroA = new JPanel();
        pnlHeroA.setSize(380, 430);
        pnlHeroA.setBounds(410, -10, 380, 430);
        pnlBg.add(pnlHeroA);
        lblHeroA = new JLabel();
        lblHeroA.setIcon(new ImageIcon(resizeImage("img/hero/sniper.png", 380, 430)));
        pnlHeroA.add(lblHeroA);
        
        pnlHeroG = new JPanel();
        pnlHeroG.setSize(380, 430);
        pnlHeroG.setBounds(810, -10, 380, 430);
        pnlBg.add(pnlHeroG);
        lblHeroG = new JLabel();
        lblHeroG.setIcon(new ImageIcon(resizeImage("img/hero/sniper.png", 380, 430)));
        pnlHeroG.add(lblHeroG);
        
        pnlHS = new JPanel();
        pnlHS.setSize(100, 50);
        pnlHS.setBounds(150, 460, 100, 50);
        pnlHS.setBackground(new Color(0,0,0,0));
        pnlBg.add(pnlHS);
        rbtnHS = new JRadioButton("SNIPER",true);
        rbtnHS.setActionCommand("1");
//        rbtnHS.setBackground(new Color(0,0,0,0));
//        rbtnHS.setForeground(Color.white);
        pnlHS.add(rbtnHS);
        
        pnlHA = new JPanel();
        pnlHA.setSize(100, 50);
        pnlHA.setBounds(565, 460, 100, 50);
        pnlHA.setBackground(new Color(0,0,0,0));
        pnlBg.add(pnlHA);
        rbtnHA = new JRadioButton("ARCHER");
        rbtnHA.setActionCommand("2");
//        rbtnHA.setBackground(new Color(0,0,0,0));
//        rbtnHA.setForeground(Color.white);
        pnlHA.add(rbtnHA);
        
        pnlHG = new JPanel();
        pnlHG.setSize(100, 50);
        pnlHG.setBounds(960, 460, 100, 50);
        pnlHG.setBackground(new Color(0,0,0,0));
        pnlBg.add(pnlHG);
        rbtnHG = new JRadioButton("GOBLIN");
        rbtnHG.setActionCommand("3");
//        rbtnHG.setBackground(new Color(0,0,0,0));
//        rbtnHG.setForeground(Color.white);
        pnlHG.add(rbtnHG);
        
        rbtnGroup = new ButtonGroup();
        rbtnGroup.add(rbtnHS);
        rbtnGroup.add(rbtnHA);
        rbtnGroup.add(rbtnHG);
        
        pnlName = new JPanel();
        pnlName.setSize(380,430);
        pnlName.setBounds(510, 600, 380, 30);
        pnlName.setLayout(null);
        pnlName.setBackground(Color.white);
        lblAlas.add(pnlName);
        lblName = new JLabel("USER NAME : ");
        lblName.setBounds(0, 0, 190, 30);
        pnlName.add(lblName);
        txtName = new JTextField(15);
        txtName.setBounds(190, 0,190 , 30);
        pnlName.add(txtName);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(700, 750, 300, 50);
        btnSubmit.setPreferredSize(new Dimension (300,50));
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSubmitOnClick(e);
            }
        });
        pnlBg.add(btnSubmit);
        
        btnCancle = new JButton("Cancle");
        btnCancle.setBounds(200, 750, 300, 50);
        btnCancle.setPreferredSize(new Dimension(300,50));
        btnCancle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new mainMenu().setVisible(true);
                setVisible(false);
                dispose();
            }
});
        pnlBg.add(btnCancle);
    }
     
     private void btnSubmitOnClick(ActionEvent evt){
         nama_usr = txtName.getText();
         plh = rbtnGroup.getSelection().getActionCommand();
            if(nama_usr.length() == 0){
                JOptionPane.showMessageDialog(this,"Please enter your NAME","Validation Failed",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                new playSiang().setVisible(true);
                setVisible(false);
                dispose();
            }
     }
     
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

    public String getNama_usr() {
        return nama_usr;
    }
     
    JLabel lblHeroS;
    JLabel lblHeroA;
    JLabel lblHeroG;
     JButton btnCancle;
     JButton btnSubmit;
     JPanel pnlName;
     JLabel lblName;
     JTextField txtName;
     JPanel pnlAlas;
     JLabel lblAlas;
     JPanel pnlBg;
     JPanel pnlHeroS;
     JPanel pnlHS;
     JRadioButton rbtnHS;
     JPanel pnlHeroA;
     JPanel pnlHA;
     JRadioButton rbtnHA;
     JPanel pnlHeroG;
     JPanel pnlHG;
     JRadioButton rbtnHG;
     ButtonGroup rbtnGroup;
     String plh,nama_usr;
}
