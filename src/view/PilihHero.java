/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
public class PilihHero extends JFrame {

    int pilih, a;

    public int getPilih() {
        return pilih;
    }

    public void setPilih(int pilih) {
        this.pilih = pilih;
    }

    public PilihHero() {
        initComponent();
        lblHeroSelected();
        lblClicked();
    }

    private void initComponent() {
        this.setSize(1400, 950);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Pilih Hero");
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.yellow);

        pnlAlas = new JPanel();
        pnlAlas.setBounds(0, -10, 1400, 950);
        add(pnlAlas);

        lblAlas = new JLabel();
        lblAlas.setIcon(new ImageIcon(resizeImage("img/map/dirt.jpg", 1400, 950)));
        pnlAlas.add(lblAlas);

        pnlBg = new JPanel();
        pnlBg.setLayout(null);
        pnlBg.setBounds(100, 70, 1200, 890);
        pnlBg.setBackground(new Color(0, 0, 0, 100));
        lblAlas.add(pnlBg);

        //UNTUK ICON HERO
        pnlHeroS = new JPanel();
        pnlHeroS.setBounds(10, -10, 380, 430);
        pnlBg.add(pnlHeroS);
        lblHeroS = new JLabel();
        lblHeroS.setIcon(new ImageIcon(resizeImage("img/hero/icon/sniper.jpg", 380, 430)));
        pnlHeroS.add(lblHeroS);

        pnlHeroW = new JPanel();
        pnlHeroW.setBounds(410, -10, 380, 430);
        pnlBg.add(pnlHeroW);
        lblHeroA = new JLabel();
        lblWindS = new JLabel();
        lblHeroA.setIcon(new ImageIcon(resizeImage("img/hero/icon/windranger.jpg", 380, 430)));
        pnlHeroW.add(lblHeroA);

        pnlHeroM = new JPanel();
        pnlHeroM.setBounds(810, -10, 380, 430);
        pnlBg.add(pnlHeroM);
        lblHeroG = new JLabel();
        lblMiraS = new JLabel();
        lblHeroG.setIcon(new ImageIcon(resizeImage("img/hero/icon/mirana.jpg", 380, 430)));
        pnlHeroM.add(lblHeroG);

        //UNTUK USERNAME
        lblName = new JLabel();
        lblName.setIcon(new ImageIcon(resizeImage("img/hero/icon/nickname.png", 190, 190)));
        lblName.setBounds(300, 450, 190, 190);
        pnlBg.add(lblName);
        Font font = new Font("Verdana", Font.BOLD, 30);
        txtName = new JTextField(15);
        txtName.setFont(font);
        txtName.setBounds(520, 505, 190, 50);
        pnlBg.add(txtName);

        //LABEL BACK
        lblCancle = new JLabel();
        lblCancle.setBounds(225, 650, 300, 150);
        lblCancle.setIcon(new ImageIcon(resizeImage("img/play2.png", 300, 150)));
        pnlBg.add(lblCancle);

        //LABEL SUBMIT
        lblSubmit = new JLabel();
        lblSubmit.setBounds(600, 650, 300, 150);
        lblSubmit.setIcon(new ImageIcon(resizeImage("img/play3.png", 300, 150)));
        pnlBg.add(lblSubmit);

    }

    private void lblHeroSelected() {
        pnlCS = new JPanel();
        pnlCS.setBounds(10, -10, 380, 430);
        pnlBg.add(pnlCS);
        lblSniperS = new JLabel();
        lblSniperS.setIcon(new ImageIcon(resizeImage("img/hero/icon/sniperSelected.jpg", 380, 430)));
        pnlCS.add(lblSniperS);

        pnlCW = new JPanel();
        pnlCW.setBounds(410, -10, 380, 430);
        pnlBg.add(pnlCW);
        lblWindS = new JLabel();
        lblWindS.setIcon(new ImageIcon(resizeImage("img/hero/icon/windrangerSelected.jpg", 380, 430)));
        pnlCW.add(lblWindS);

        pnlCM = new JPanel();
        pnlCM.setBounds(810, -10, 380, 430);
        pnlBg.add(pnlCM);
        lblMiraS = new JLabel();
        lblMiraS.setIcon(new ImageIcon(resizeImage("img/hero/icon/miranaSelected.jpg", 380, 430)));
        pnlCM.add(lblMiraS);
    }

    private void lblClicked() {
        lblHeroS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a = 1;
                setPilih(a);
                pnlHeroS.setVisible(false);
                pnlCS.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblHeroS.setIcon(new ImageIcon(resizeImage("img/hero/icon/sniperSelected.jpg", 380, 430)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblHeroS.setIcon(new ImageIcon(resizeImage("img/hero/icon/sniper.jpg", 380, 430)));
            }
        });

        lblHeroA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a = 2;
                setPilih(a);
                pnlHeroW.setVisible(false);
                pnlCW.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblHeroA.setIcon(new ImageIcon(resizeImage("img/hero/icon/windrangerSelected.jpg", 380, 430)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblHeroA.setIcon(new ImageIcon(resizeImage("img/hero/icon/windranger.jpg", 380, 430)));
            }
        });

        lblHeroG.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a = 3;
                setPilih(a);
                pnlHeroM.setVisible(false);
                pnlCM.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblHeroG.setIcon(new ImageIcon(resizeImage("img/hero/icon/miranaSelected.jpg", 380, 430)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblHeroG.setIcon(new ImageIcon(resizeImage("img/hero/icon/mirana.jpg", 380, 430)));
            }
        });

        lblSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblSummitMouseClicked();
            }
        });

        lblCancle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MainMenu().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
    }

    private void lblSummitMouseClicked() {
        nama_usr = txtName.getText();
        setNama_usr(nama_usr);
        if (nama_usr.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter your NAME", "Validation Failed", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            new PlaySiang(this).setVisible(true);
            setVisible(false);
            dispose();
        }
    }

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
    JPanel pnlCS;
    JPanel pnlCW;
    JPanel pnlCM;
    JLabel lblSniperS;
    JLabel lblWindS;
    JLabel lblMiraS;
    JLabel lblCancle;
    JLabel lblSubmit;
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
    JPanel pnlHeroW;
    JPanel pnlHA;
    JRadioButton rbtnHA;
    JPanel pnlHeroM;
    JPanel pnlHG;
    JRadioButton rbtnHG;
    ButtonGroup rbtnGroup;
    String nama_usr;

    public String getNama_usr() {
        return nama_usr;
    }

    public void setNama_usr(String nama_usr) {
        this.nama_usr = nama_usr;
    }

}
