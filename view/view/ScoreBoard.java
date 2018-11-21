/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.mysql.jdbc.MysqlIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ScoreBoard extends JFrame {

    public ScoreBoard() {
        initComponent();
    }

    private void initComponent() {
        
        
        listTop = new ArrayList<String>();
        this.setSize(1400, 950);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Score Board");
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.black);
        //LABEL BACK
        lblCancle = new JLabel();
        lblCancle.setBounds(225, 650, 300, 150);
        lblCancle.setIcon(new ImageIcon(resizeImage("img/play2.png", 300, 150)));
        lblCancle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MainMenu().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        lblTop = new JLabel();
        lblTop.setBounds(100, 50, 300, 300);
        lblTop.setIcon(new ImageIcon(resizeImage("img/topscore.jpg", 300, 300)));
        this.add(lblTop);
        
        lblEye = new JLabel();
        lblEye.setBounds(1000, 50, 300, 300);
        lblEye.setIcon(new ImageIcon(resizeImage("img/bulleye.jpg", 300, 300)));
        this.add(lblEye);
        String sql;
        //buat db nya
        String url = "jdbc:mysql://localhost:3306/jombiewape";
        String user = "root";
        String password = "";
        Connection dbCon = null;
        try {
            dbCon = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke DB berhasil");
        } catch (SQLException ex) {
            System.out.println("Gagal koneksi ke DB" + ex.getMessage());
        }

        try {
            sql = "SELECT nama,score from pemain group by score desc";
            Statement stmt = dbCon.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String[] coloums = {"Peringkat","Name", "Score"};

            int rowFound = 0;
            if (rs.last()) {
                rowFound = rs.getRow();
            }
            Object score[][] = new Object[rowFound][3];
            System.out.println(rowFound + " recors(s) found.");
            rs.beforeFirst();
            int i = 0;
            while (rs.next() && i <= rowFound) {
                score[i][0] = i+1;
                score[i][1] = rs.getString(1);
                score[i][2] = rs.getInt(2);
                System.out.println(rs.getString(1));
                i++;
            }

            tabel = new JTable(score, coloums);
            spTblTest = new JScrollPane(tabel);
            spTblTest.setBounds(500, 150, 400, 450);
            tabel.setFillsViewportHeight(true);
        } catch (SQLException ex) {
            System.out.println("Gagal eksekusi SQL" + ex.getMessage());
        }

        if (dbCon != null) {
            try {
                dbCon.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        this.add(spTblTest);
        this.add(lblCancle);
    }

    //buat masukin ke dalam DB hasil dari setiap kali main
    public void toScore(String a, int b) {
        String sql;
        sql = "insert into pemain(nama,score) value"
                + "(?,?);";
        //buat db nya
        String url = "jdbc:mysql://localhost:3306/jombiewape";
        String user = "root";
        String password = "";
        Connection dbCon = null;
        try {
            dbCon = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke DB berhasil");
        } catch (SQLException ex) {
            System.out.println("Gagal koneksi ke DB" + ex.getMessage());
        }

        try {
            PreparedStatement stmt = dbCon.prepareStatement(sql);
            stmt.setString(1, a);
            stmt.setInt(2, b);
            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Gagal eksekusi SQL" + ex.getMessage());
        }

        if (dbCon != null) {
            try {
                dbCon.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
    JLabel lblCancle;
    JLabel topScore;
    JLabel lblEye;
    JTable tabel;
    ArrayList<String> listTop;
    ArrayList<String> list1;
    ArrayList<Integer> list2;
    int dummy;
    int counter = 0;
    JButton btnCancle;
    JLabel lblTop;
    JScrollPane spTblTest;
}
