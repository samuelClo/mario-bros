package Object;

import javax.swing.*;
import java.awt.*;

public class RedPipe extends Object{
    private Image imgRedPipe;
    private ImageIcon icoRedPipe;

    public RedPipe(int x, int y) {
        super(x, y, 43, 65);
        this.icoRedPipe = new ImageIcon(getClass().getResource("/Images/tuyauRouge.png"));
        this.imgRedPipe = this.icoRedPipe.getImage();
    }

    public Image getImgRedPipe() { return imgRedPipe; }
}
