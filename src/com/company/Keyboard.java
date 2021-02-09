package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.printf("The sum is " + e);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Main.scene.setDx(2);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Main.scene.setDx(-2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.setDx(0);
    }
}
