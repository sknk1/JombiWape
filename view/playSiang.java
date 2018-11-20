/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import model.Bullet;
import model.Score;
import model.Zombie;
import static view.MainMenu.playSound;

/**
 *
 * @author USER
 */
public class PlaySiang extends JFrame {

    private PilihHero ph;
    public static List<Zombie> listZombie = new ArrayList<>();
    public static List<Score> listScore = new ArrayList<>();
    public static List<Thread> listTZ = new ArrayList<>();
    public static List<Bullet> listBullet = new ArrayList<>();
    public static List<Thread> listTB = new ArrayList<>();
    //LISTSTART UNTUK THREAD YANG LAINYA AGAR BSA DI STOP SAAT MATI CO : THREAD SCORE 
    //LIST (0) = BULLETHIT
    //LIST (1) = SCOREBOARD
    //LIST (2) = INNERTHREAD
    //LIST (3) = ARROW PASS
    public static List<Thread> listStart = new ArrayList<>();

    public PlaySiang(PilihHero _choosenHero) {
        ph = _choosenHero;
        initComponent();
        playerMove();
        lblClicked();
        name_user = ph.getNama_usr();
        setName_user(name_user);
    }

    public void lblClicked() {
        lblEGB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < listTB.size(); i++) {
                    listTB.get(i).stop();
                }
                for (int i = 0; i < listTZ.size(); i++) {
                    listTZ.get(i).stop();
                }
                for (int i = 0; i < listStart.size(); i++) {
                    listStart.get(i).stop();
                }
                System.out.println("User Name : " + getName_user());
                System.out.println("Score : " + getScore());
                new MainMenu().setVisible(true);
                setVisible(false);
                dispose();
            }
        });

        lblExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MainMenu().setVisible(true);
                setVisible(false);
                dispose();
            }
        });
    }

    private void initComponent() {
        this.setSize(1700, 950);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Game");
        this.setLayout(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.green);

        pnlAlas = new JPanel();
        pnlAlas.setSize(1700, 950);
        pnlAlas.setBounds(0, 0, 1700, 950);
        add(pnlAlas);

        lblAlas = new JLabel();
        lblAlas.setIcon(new ImageIcon(resizeImage("img/map/siangf.jpg", 1700, 950)));
        pnlAlas.add(lblAlas);

        //PNL UNTUK END GAME
        pnlEndGame = new JPanel();
        pnlEndGame.setVisible(false);
        pnlEndGame.setBounds(600, 250, 500, 500);
        lblAlas.add(pnlEndGame);
        lblEndGame = new JLabel();
        lblEndGame.setBounds(0, -10, 500, 500);
        lblEndGame.setIcon(new ImageIcon(resizeImage("img/wood.jpg", 500, 500)));
        pnlEndGame.add(lblEndGame);
        lblEGT = new JLabel("You Lose!");
        lblEGT.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblEGT.setForeground(Color.RED);
        lblEGT.setBounds(0, 0, 500, 200);
        lblEndGame.add(lblEGT);
        lblEGB = new JLabel();
        lblEGB.setBounds(100, 300, 300, 150);
        lblEGB.setIcon(new ImageIcon(resizeImage("img/play2.png", 300, 150)));
        lblEndGame.add(lblEGB);

        //SCORE
        pnlScore = new JPanel();
        pnlScore.setBounds(0, 0, 200, 50);
        pnlScore.setLayout(null);
        pnlScore.setBackground(Color.black);
        lblAlas.add(pnlScore);
        //ARROW
        pnlArrow = new JPanel();
        pnlArrow.setBounds(0, 50, 200, 50);
        pnlArrow.setLayout(null);
        pnlArrow.setBackground(Color.black);
        lblAlas.add(pnlArrow);

        //UNTUK SCORE DIATAS
        Score sb = new Score(pnlScore);
        listScore.add(sb);
        Thread tsb = new Thread(sb);
        tsb.start();
        listStart.add(tsb);
        //UNTUK ARROW DIATAS
        setArrow(arrow);
        lblArrow = new JLabel("Arrow : " + getArrow());
        lblArrow.setBounds(0, 0, 200, 50);
        lblArrow.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblArrow.setForeground(Color.RED);
        pnlArrow.add(lblArrow);

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

        // NGIDUPIN THREAD NGECEK ADA YANG KE HIT APA TIDAK
        BulletHit bh = new BulletHit(lblAlas);
        bh.start();
        listStart.add(bh);

        // HIDUPIN CEK ADA YANG LEWAT APA ENGGA
        InnerThread tt = new InnerThread(pnlEndGame);
        tt.start();
        listStart.add(tt);

        // NGECEK ADA ARRO YANG LEWAT APA ENGGA
        ArrowPass ap = new ArrowPass();
        ap.start();
        listStart.add(ap);

//        NGIHUDUPIN ZOMBIE
        Random rand = new Random();
        int hr = 1800;
        for (int i = 0; i < 15; i++) {
            hr += rand.nextInt(500);
            Zombie z = new Zombie(lblAlas, hr);
            z.setIcon(new ImageIcon(resizeImage("img/hero/zombie.png", 105, 144)));
            z.setBounds(10, 10, 105, 144);
            lblAlas.add(z);
            Thread t = new Thread(z);
            t.start();
            listZombie.add(z);
            listTZ.add(t);
            hr += 65;
        }

        //LABEL EXlT
        lblExit = new JLabel();
        lblExit.setBounds(1640, 0, 60, 60);
        lblExit.setIcon(new ImageIcon(resizeImage("img/exit.png", 60, 60)));
        lblAlas.add(lblExit);

        //UNTUK BERAPA BANYAK PELURU YANG DI INISIALISASI
        for (int i = 0; i < 20; i++) {
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
                        //IF AGAR ARROW TIDAK BUG SAAT PELOR KE 1
                        if (arrow == 20) {
                            arrow--;
                        }
                        //UNTUK CounterPelor < 20 agar berhenti jika pelornya HABIS
                        if (cp < 20) {
                            listBullet.get(cp).setTempat(lblHero.getY() + y);
                            listBullet.get(cp).setIcon(new ImageIcon(resizeImage("img/hero/bullet/arow.png", 50, 50)));
                            listBullet.get(cp).setBounds(400, 0, 50, 50);
                            pnlMain.add(listBullet.get(cp));
                            Thread tb = new Thread(listBullet.get(cp));
                            tb.start();
                            listTB.add(tb);
                            cp++;
                            pnlArrow.remove(lblArrow);
                            lblArrow = new JLabel("Arrow : " + getArrow());
                            lblArrow.setBounds(0, 0, 200, 50);
                            lblArrow.setFont(new Font("Verdana", Font.PLAIN, 30));
                            lblArrow.setForeground(Color.RED);
                            pnlArrow.add(lblArrow);
                            setArrow(arrow -= 1);
                        }
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
    public boolean intersect(JLabel lbla, JLabel lblb) {
        int zx = lbla.getX();
        int bx = lblb.getX();
        int zy = lbla.getY();
        int by = lblb.getY() + 144;

        if (bx > zx && zy == by) {
            return true;
        } else {
            return false;
        }
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

    private class ArrowPass extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("");
                for (int i = 0; i < listBullet.size(); i++) {
                    if (listBullet.get(i).isStatus() == false) {
                        listTB.get(i).stop();
                        listBullet.get(i).setVisible(false);
                    }
                }
            }
        }

    }

    //THREAD UNTUK NGECEK APAKAH PLAYER MATI APA TIDAK
    private class InnerThread extends Thread {

        JPanel pnlEnd;

        InnerThread(JPanel pnlEndGame) {
            this.pnlEnd = pnlEndGame;
        }

        @Override
        public void run() {
            boolean stopAll = false;
            int point = 0;

            //NGECEK KALAU ADA ZOMBIE YANG LEWAT APA TIDAK
            while (true) {
                for (int i = 0; i < listZombie.size(); i++) {
                    if (listZombie.get(i).isStatus() == false) {
                        stopAll = true;
                        break;
                    }
                }
                if (stopAll) {
                    setScore(listScore.get(0).getPoint());
                    listStart.get(0).stop();
                    listStart.get(1).stop();
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println("");
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
            this.pnlEnd.setVisible(true);

        }
    }

    //UNTUK NGECEK PELURU ADA YANG KENA APA TIDAK
    private class BulletHit extends Thread {

        JLabel lblAlas;

        BulletHit(JLabel lblAlas) {
            this.lblAlas = lblAlas;
        }

        @Override
        public void run() {
            boolean status = false;
            while (true) {
                System.out.println("");
                for (int i = 0; i < listZombie.size(); i++) {
                    for (int j = i; j < listBullet.size(); j++) {
                        if (intersect(listZombie.get(i), listBullet.get(j)) == true) {
                            zombieDeath += 1;
                            listZombie.get(i).setVisible(false);
                            listTZ.get(i).stop();
                            listBullet.get(j).setVisible(false);
                            listTB.get(j).stop();
                            status = true;
                            break;
                        }
                        if (status == true) {
                            status = false;
                        }
                    }
                    lblAlas.repaint();
                }

            }

        }

    }

    JLabel lblEGT;
    JLabel lblEGB;
    JLabel lblEndGame;
    JPanel pnlEndGame;
    JPanel pnlArrow;
    JPanel pnlScore;
    Thread tb;
    JLabel lblExit;
    JPanel pnlAlas;
    JLabel lblAlas;
    JPanel pnlMain;
    JPanel pnlRumah;
    JLabel lblHero;
    JLabel lblArrow;
    String name_user;
    int score;
    int counter = 1;
    int cp = 0;
    int arrow = 20;
    int zombieDeath = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }
}
