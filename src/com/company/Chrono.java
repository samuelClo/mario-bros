package com.company;

public class Chrono implements Runnable {
    private final int PAUSE = 3; // delay before repaint

    @Override
    public void run() {
        while (true) {
            Main.scene.repaint();

            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
