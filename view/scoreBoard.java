/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
        
    }
 
}