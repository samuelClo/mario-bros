package com.company;

import javax.swing.JFrame;

public class Main {
    public static Scene scene;
    public static void main(String[] args) {
        // Create game window
        JFrame window = new JFrame("Mario game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 360);
        window.setLocationRelativeTo(null); // center window on screen
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        // Scene instantiate
        scene = new Scene();
        window.setContentPane(scene); // associate scene to game window
        window.setVisible(true);
    }
}
