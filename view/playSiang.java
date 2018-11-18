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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import model.Bullet;
import model.Zombie;

/**
 *
 * @author USER
 */
public class PlaySiang extends JFrame {

    private PilihHero ph;
    public static List<Zombie> listZombie = new ArrayList<>();
    public static List<Thread> listTZ = new ArrayList<>();
    public static List<Bullet> listBullet = new ArrayList<>();
    public static List<Thread> listTB = new ArrayList<>();

    public PlaySiang(PilihHero _choosenHero) {
        ph = _choosenHero;
        initComponent();
        playerMove();
    }

    private void initComponent() {
//        PilihHero ph = new PilihHero();
        this.setSize(1700, 950);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Game");
        this.setLayout(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.green);

        //PilihHero pl = new PilihHero();
        pnlAlas = new JPanel();
        pnlAlas.setSize(1700, 950);
        pnlAlas.setBounds(0, 0, 1700, 950);
        add(pnlAlas);

        lblAlas = new JLabel();
        lblAlas.setIcon(new ImageIcon(resizeImage("img/map/siangf.jpg", 1700, 950)));
        pnlAlas.add(lblAlas);

        pnlMain = new JPanel();
        pnlMain.setSize(1600, 720);
        pnlMain.setBackground(new Color(0, 0, 0, 0));
        pnlMain.setBounds(100, 150, 1600, 720);
        pnlMain.setLayout(null);
        lblAlas.add(pnlMain);

        lblHero = new JLabel();
        int plih = ph.getPilih();
        System.out.println(plih);
        if (plih == 1) {
            lblHero.setIcon(new ImageIcon(resizeImage("img/hero/play/sniper.png", 105, 144)));
        } else if (plih == 2) {
            lblHero.setIcon(new ImageIcon(resizeImage("img/hero/play/wind.png", 105, 144)));
        } else {
            lblHero.setIcon(new ImageIcon(resizeImage("img/hero/play/mirana.png", 105, 144)));
        }

        lblHero.setBounds(200, 0, 105, 144);
        pnlMain.add(lblHero);

        // NGIDUPIN NYALAIN CEK MATI APA TIDAK
        InnerThread it = new InnerThread();
        it.start();
        // NGIDUPIN THREAD NGECEK ADA YANG KE HIT APA TIDAK
        BulletHit bh = new BulletHit(lblAlas);
        bh.start();
//        NGIHUDUPIN ZOMBIE
        Zombie z1 = new Zombie(lblAlas, 1800);
        z1.setIcon(new ImageIcon(resizeImage("img/hero/zombie.png", 105, 144)));
        z1.setBounds(10, 10, 105, 144);
        lblAlas.add(z1);
        Thread t = new Thread(z1);
        t.start();
        listZombie.add(z1);
        listTZ.add(t);

        Zombie z2 = new Zombie(lblAlas, 2000);
        z2.setIcon(new ImageIcon(resizeImage("img/hero/zombie.png", 105, 144)));
        z2.setBounds(10, 10, 105, 144);
        lblAlas.add(z2);
        Thread t2 = new Thread(z2);
        t2.start();
        listZombie.add(z2);
        listTZ.add(t2);

        //LABEL EXlT
        lblExit = new JLabel();
        lblExit.setBounds(1640, 0, 60, 60);
        lblExit.setIcon(new ImageIcon(resizeImage("img/exit.png", 60, 60)));
        lblExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MainMenu().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        lblAlas.add(lblExit);

        for (int i = 0; i < 10; i++) {
            Bullet bll = new Bullet(lblAlas);
            listBullet.add(bll);
        }

    }

    private void playerMove() {
        this.addKeyListener(new KeyAdapter() { // UNTUK COBA GERAK KIRI KANAN ATAS BAWAH
            @Override
            public void keyPressed(KeyEvent e) {
                int y = 0;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: {
                        if (counter > 1) {
                            y = -144;
                            counter = counter - 1;
                            break;
                        } else {
                            break;
                        }
                    }
                    case KeyEvent.VK_DOWN: {
                        if (counter < 5) {
                            y = 144;
                            counter = counter + 1;
                            break;
                        } else {
                            break;
                        }
                    }
                    case KeyEvent.VK_RIGHT: {
                        listBullet.get(cp).setTempat(lblHero.getY() + y);
                        listBullet.get(cp).setIcon(new ImageIcon(resizeImage("img/hero/bullet/arow.png", 50, 50)));
                        listBullet.get(cp).setBounds(400, 0, 50, 50);
                        pnlMain.add(listBullet.get(cp));
                        Thread tb = new Thread(listBullet.get(cp));
                        tb.start();
                        listTB.add(tb);
                        cp++;
                    }
                    default:
                        break;
                }

                lblHero.setLocation(lblHero.getX(), lblHero.getY() + y);
                repaint();
            }
        });

    }

    //INTERSECT
    public boolean coba(JLabel lbla, JLabel lblb) {
        int zx = lbla.getX();
        int bx = lblb.getX();

        if (bx > zx) {
            return true;
        } else {
            return false;
        }
    }

    //INTERSECT
    public boolean intersects(JLabel lbla, JLabel lblb) {
        Area areaA = new Area(lbla.getBounds());
        Area areaB = new Area(lblb.getBounds());
        if (areaB == areaA) {
            return true;
        } else {
            return false;
        }
//
//        return areaA.intersects(areaB.getBounds2D());
    }

    //RESIZE IMAGE
    private Image resizeImage(String url, int x, int y) {
        Image dimg = null;
        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return dimg;
    }

    //THREAD UNTUK NGECEK APAKAH PLAYER MATI APA TIDAK
    private class InnerThread extends Thread {

        @Override
        public void run() {
            boolean stopAll = false;
            //NGECEK KALAU ADA ZOMBIE YANG LEWAT APA TIDAK
            while (true) {
                for (Zombie zombiee : listZombie) {
                    if (!zombiee.isStatus()) {
                        stopAll = true;
                        break;
                    }
                }
                if (stopAll) {
                    break;
                }
            }
            //STOP THREAD ZOMBIE
            for (int i = 0; i < listTZ.size(); i++) {
                listTZ.get(i).stop();
            }
            //STOP THREAD PELOR 
            for (int i = 0; i < listTB.size(); i++) {
                listTB.get(i).stop();
            }
            JOptionPane.showMessageDialog(null, "Game Over!");
        }
    }

    private class BulletHit extends Thread {

        JLabel lblAlas;
        List<Integer> listZom = new ArrayList<>();
        List<Integer> listBul = new ArrayList<>();

        BulletHit(JLabel lblAlas) {
            this.lblAlas = lblAlas;
        }
        
        @Override
        public void run() {
            boolean status = true;
            while (true) {
                for (int i = 0; i < listZombie.size(); i++) {
                    for (int j = 0; j < listBullet.size(); j++) {
                        if (status) {
                       
                        }
                        if (coba(listZombie.get(i), listBullet.get(j)) == true) {
                            listZombie.get(i).setVisible(false);
                            listTZ.get(i).stop();
                            listBullet.get(j).setVisible(false);
                            listTB.get(j).stop();
                            status = false;
                            break;
                        }
                    }
                    lblAlas.repaint();
                }
            }
        }
    }

    Thread tb;
    JLabel lblExit;
    JPanel pnlAlas;
    JLabel lblAlas;
    JPanel pnlMain;
    JPanel pnlRumah;
    JLabel lblHero;
    int counter = 1;
    int cp = 0;

}
