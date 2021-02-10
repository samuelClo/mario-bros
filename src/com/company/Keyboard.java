package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (Main.scene.getxPos() == -1) { // if we are on left of the game
                Main.scene.setxPos(0);
//                Main.scene.setxBackground1(-50);
//                Main.scene.setxBackground2(750);
            }
            Main.scene.mario.setWalking(true);
            Main.scene.mario.setTurnRight(true);
            Main.scene.setDx(1); // move right
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Main.scene.mario.setWalking(true);
            Main.scene.mario.setTurnRight(false);
            Main.scene.setDx(-1); // move left
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.mario.setWalking(false); // stop walk graphic
        Main.scene.setDx(0); // stop walk
    }
}
