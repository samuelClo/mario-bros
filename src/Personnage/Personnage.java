package Personnage;

import com.company.Main;

import javax.swing.*;
import java.awt.*;

import Object.Object;

public class Personnage {
    private int width, height;
    private int x, y;
    private boolean walking;
    private boolean turnRight;
    public int stepCount;

    public Personnage(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.walking = false;
        this.turnRight = true;
        this.stepCount = 0;
    }

    public int getWidth() {return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() {return height; }
    public void setHeight(int height) {this.height = height; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public boolean isWalking() { return walking; }
    public void setWalking(boolean walking) { this.walking = walking; }

    public boolean isTurnRight() { return turnRight; }
    public void setTurnRight(boolean turnRight) { this.turnRight = turnRight; }

    public int getStepCount() { return stepCount; }
    public void setStepCount(int stepCount) { this.stepCount = stepCount; }

    public Image walk(String name, int frequency) { // name to get relative image. frenquency => refresh sprite
        String str;
        ImageIcon ico;
        Image img;

        if (!this.walking || Main.scene.getxPos() <= 0) { // perso stop or we are on the left of the game
            if (this.turnRight) {
                str = "/Images/" + name + "ArretDroite.png";
            } else {
                str = "/Images/" + name + "ArretGauche.png";
            }
        } else {
            this.stepCount++;
            if (this.stepCount / frequency == 0) { // number is integer, not float
                if (this.turnRight) {
                    str = "/Images/" + name + "ArretDroite.png";
                } else {
                    str = "/Images/" + name + "ArretGauche.png";
                }
            } else {
                if (this.turnRight) {
                    str = "/Images/" + name + "MarcheDroite.png";
                } else {
                    str = "/Images/" + name + "MarcheGauche.png";
                }
            }
            if (this.stepCount == 2 * frequency) { // reset
                this.stepCount = 0;
            }
        }

        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();

        return img;
    }

    public boolean contactBefore(Object object) {
        if (this.isTurnRight()) {
            return Main.scene.getxPos() + this.getWidth() == this.getX() && this.y + this.height > object.getY() && this.y < object.getY() + object.getHeight();
        }
        else if (!this.isTurnRight()) {
            return Main.scene.getxPos() - object.getWidth()  == this.getX() && this.y + this.height > object.getY() && this.y < object.getY() + object.getHeight();
        }
        else {
            return false;
        }
    }
}
