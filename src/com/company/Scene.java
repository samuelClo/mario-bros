package com.company;

import Personnage.Mario;
import Object.*;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {
    private final Image backgroundImage1;
    private final Image backgroundImage2;

    private final Image imgCastle1;
    private final Image imgStart;

    private int xBackground1; // coord of left top background
    private int xBackground2;

    private int dx; // use to translate the background with Keyboard.java
    private int xPos;
    private int roofHeight;
    private int yFloor;

    public Mario mario;
    public RedPipe redPipe1;
    public Bloc bloc1;

    public Scene() {
        super();
        this.xBackground1 = -50; // overflow the screen
        this.xBackground2 = 750;
        this.dx = 0;
        this.xPos = -1;
        this.roofHeight = 0;
        this.yFloor = 295;

        ImageIcon icoBackground = new ImageIcon(getClass().getResource("/Images/fondEcran.png"));
        this.backgroundImage1 = icoBackground.getImage();
        this.backgroundImage2 = icoBackground.getImage();

        ImageIcon icoCastle1 = new ImageIcon(getClass().getResource("/Images/chateau1.png"));
        this.imgCastle1 = icoCastle1.getImage();
        ImageIcon icoStart = new ImageIcon(getClass().getResource("/Images/depart.png"));
        this.imgStart = icoStart.getImage();

        // instantiate elements
        mario = new Mario(300, 245);
        redPipe1 = new RedPipe(600, 230);
        bloc1 = new Bloc(400, 180);

        // Add keyListener
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());

        // Launch refresh
        Thread chronoScreen = new Thread(new Chrono());
        chronoScreen.start();
    }

    public int getDx() { return dx; }
    public void setDx(int dx) { this.dx = dx; }

    public int getxPos() { return xPos; }
    public void setxPos(int xPos) { this.xPos = xPos; }

    public int getxBackground1() { return xBackground1; }
    public void setxBackground1(int xBackground1) { this.xBackground1 = xBackground1; }

    public int getxBackground2() { return xBackground2; }
    public void setxBackground2(int xBackground2) { this.xBackground2 = xBackground2; }

    public int getRoofHeight() {
        return roofHeight;
    }

    public int getyFloor() {
        return yFloor;
    }

    public void translateBackground() {
        if (this.xPos >= 0) { // go to the right
           this.xPos = this.xPos + this.dx; // set xPos for know how long we move
           this.xBackground1 = this.xBackground1 - this.dx;
           this.xBackground2 = this.xBackground2 - this.dx;
        }

        // make scrollViewY infinite
        if (this.xBackground1 == -800) { this.xBackground1 = 800; }
        else if (this.xBackground2 == -800) { this.xBackground2 = 800; }
        else if (this.xBackground1 == 800) { this.xBackground1 = -800; }
        else if (this.xBackground2 == 800) { this.xBackground2 = -800; }
    }

    public void paintComponent(Graphics g) { // call on each repaint by Main.scene.repaint();
        super.paintComponent(g);

        // Detect contact
        if (this.mario.contactBefore(redPipe1)) {
            this.dx = 0;
        }
        if (this.mario.contactBefore(bloc1)) {
            this.dx = 0;
        }

        this.translateBackground(); // if this.dx change, the background translate
        // this.redPipe1.move();


        g.drawImage(this.backgroundImage1, this.xBackground1, 0, null); // background image draw
        g.drawImage(this.backgroundImage2, this.xBackground2, 0, null);
        g.drawImage(imgCastle1, 10 - this.xPos, 95, null); //10 - this.xPos to place element on the same place
        g.drawImage(imgStart, 220 - this.xPos, 234, null);

        //g.drawImage(this.mario.walk("mario", 50), 300, 245, null);
        g.drawImage(this.redPipe1.getImgRedPipe(), this.redPipe1.getX() - this.xPos, this.redPipe1.getY(), null);
        g.drawImage(this.bloc1.getImgBloc(), this.bloc1.getX() - this.xPos, this.bloc1.getY(), null);
        if(this.mario.isJumping()){ g.drawImage(this.mario.jump(), this.mario.getX(), this.mario.getY(), null);}
        else{ g.drawImage(this.mario.walk("mario", 25), this.mario.getX(), this.mario.getY(), null);}
    }
}
