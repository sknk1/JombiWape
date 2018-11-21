/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class Score extends JLabel implements Runnable {

    JLabel lblss;
    JPanel pnlScore;
    int point = 0;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Score(JPanel pnlScore) {
        this.setVisible(true);
        this.pnlScore = pnlScore;
    }

    @Override
    public void run() {
        setPoint(point);
        while (true) {
            try {
                lblss = new JLabel("Score : " + getPoint());
                lblss.setBounds(0, 0, 200, 50);
                lblss.setFont(new Font("Verdana", Font.PLAIN, 30));
                lblss.setForeground(Color.RED);
                pnlScore.add(lblss);
                point += 10;
                setPoint(point);
                this.pnlScore.repaint();
                Thread.sleep(1000);
                pnlScore.remove(lblss);
                repaint();
            } catch (InterruptedException ex) {

            }
        }
    }

}