package com.company;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {
    private ImageIcon icoBackground;
    private Image backgroundImage1;

    private ImageIcon icoMario;
    private Image imgMario;

    private int xBackground1; // coord of left top background

    private int dx;

    public Scene() {
        super();
        this.xBackground1 = -50; // overflow the screen
        this.dx = 0;

        icoBackground = new ImageIcon(getClass().getResource("/Images/fondEcran.png"));
        this.backgroundImage1 = this.icoBackground.getImage();
        icoMario = new ImageIcon(getClass().getResource("/Images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());

        // Launch refresh
        Thread chronoScreen = new Thread(new Chrono());
        chronoScreen.start();
    }

    public int getDx() { return dx; }
    public void setDx(int dx) { this.dx = dx; }

    public void translateBackground() {
        System.out.println("dx"+dx );
        this.xBackground1 = this.xBackground1 - this.dx;
    }

    public void paintComponent(Graphics g) { // call on each repaint by Main.scene.repaint();
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        this.translateBackground(); // if this.dx change, the background translate

        g2.drawImage(this.backgroundImage1, this.xBackground1, 0, null); // background image draw
        g2.drawImage(imgMario, 300, 245, null);
    }
}
