/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contoh;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class cobaEvent extends JFrame{
    public cobaEvent(){ 
        initComponent();
    }
        
   private void initComponent(){
       this.setBounds(0, 0, 500, 5000);
       this.setLocationRelativeTo(null);
       this.setLayout(null);
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
       
       btnName = new JButton("Kilik");
       btnName.setBounds(100,100,200,50);
       
       btnName.addMouseListener(new MouseAdapter(){
           
       
       });
       this.add(btnName);
       this.addKeyListener(new KeyAdapter(){
           @Override
           public void keyPressed(KeyEvent e) {
                
           }
          
       });
   }
   
    
    public static void main(String[] args) {
       cobaEvent coba = new cobaEvent();
       coba.setVisible(true);
    }
    
    JButton btnName;
    
}