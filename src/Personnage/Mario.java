package Personnage;

import com.company.Main;

import javax.swing.*;
import java.awt.*;

public class Mario extends Personnage {
    private final Image imgMario;
    private boolean jump;
    private int timeJump;

    public Mario(int x, int y) {
        super(x, y, 28,     50);
        ImageIcon icoMario = new ImageIcon(getClass().getResource("/Images/marioMarcheDroite.png"));
        this.imgMario = icoMario.getImage();

        this.jump = false;
        this.timeJump = 0;
    }

    //**** GETTERS ****//
    public Image getImgMario() { return imgMario; }
    public boolean isJumping() { return jump; }

    //**** SETTERS ****//
    public void setJump(boolean jump) { this.jump = jump; }

    //**** METHODS ****//
    public Image jump() {
        ImageIcon ico;
        Image img;
        String str;

        this.timeJump++;

        // Montée du saut
        if (this.timeJump <= 35) {
            if (this.getY() > Main.scene.getRoofHeight()) { // mario dont touch the roof
                this.setY(this.getY() - 4); // marion monte
            }
            else {
                this.timeJump = 36; // mario must fall
            }
            if (this.isTurnRight()) { str = "/Images/marioSautDroite.png"; }
            else { str = "/Images/marioSautGauche.png"; }
        }

        //Retombée du saut
        else if (this.getY() + this.getHeight() < Main.scene.getyFloor()) { // mario must be au dessus du sol
            this.setY(this.getY() + 1);
            if (this.isTurnRight()) { str = "/Images/marioSautDroite.png"; }
            else { str = "/Images/marioArretGauche.png"; }
        }
        // jump finish
        else {
            if (this.isTurnRight()) { str = "/Images/marioArretDroite.png"; }
            else { str = "Images/marioArretGauche.png"; }
            this.jump = false;
            this.timeJump = 0;
        }

        // Affichage de l'image de mario
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }
}
