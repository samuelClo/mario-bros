package Personnage;

import javax.swing.*;
import java.awt.*;

public class Mario extends Personnage {
    private Image imgMario;
    private ImageIcon icoMario;

    public Mario(int x, int y) {
        super(x, y, 28, 50);
        this.icoMario = new ImageIcon(getClass().getResource("/Images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();
    }

    public Image getImgMario() { return imgMario; }
}
