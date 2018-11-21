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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author USER
 */
public class MainMenu extends JFrame {

    public MainMenu() {
        initComponent();
        lblClicked();
        playSound(true);
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

    private void lblClicked() {
        lblStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playSound(false);
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
    
    public static void playSound(boolean status) {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File("music/MetalSlug/mslug_menus.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            if (status == true) {
               clip.start(); 
            }else if(status == false){
                if (clip.isRunning()) {
                    clip.stop();
                }
            }
//            clip.loop(4);
        } catch (Exception ex) {
            System.out.println("Playing sound error" + ex.getMessage());
            ex.printStackTrace();
        }

    }

//    public static void music(boolean status) {
//        AudioPlayer MGP = AudioPlayer.player;
//        AudioStream BGM;
//        AudioData MD;
//        ContinuousAudioDataStream loop = null;
//
//        try {
//            InputStream test = new FileInputStream("music/MetalSlug/mslug_menus.wav");
//            BGM = new AudioStream(test);
//            if (status == true) {
//                AudioPlayer.player.start(BGM);
////                MD = BGM.getData();
////                loop = new ContinuousAudioDataStream(MD);
//            } else if (status == false) {
//                AudioPlayer.player.stop(BGM);
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.print(e.toString());
//        } catch (IOException error) {
//            System.out.print(error.toString());
//        }
//        MGP.start(loop);
//
//    }

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