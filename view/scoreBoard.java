/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class scoreBoard extends JFrame{
    public scoreBoard(){
        initComponent();
    }
    
    private void initComponent(){
        this.setSize(1400, 950);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Score Board");
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.red);
        
        btnCancle = new JButton("Cancle");
        btnCancle.setBounds(600, 500, 300, 50);
        btnCancle.setPreferredSize(new Dimension (300,50));
        btnCancle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new mainMenu().setVisible(true);
                setVisible(false);
                dispose();
            }
});
        this.add(btnCancle);
        
    }
    JButton btnCancle;
    
 
}
