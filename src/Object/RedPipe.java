package Object;

import javax.swing.*;
import java.awt.*;

public class RedPipe extends Object{
    private final Image imgRedPipe;

    public RedPipe(int x, int y) {
        super(x, y, 43, 65);
        ImageIcon icoRedPipe = new ImageIcon(getClass().getResource("/Images/tuyauRouge.png"));
        this.imgRedPipe = icoRedPipe.getImage();
    }

    public Image getImgRedPipe() { return imgRedPipe; }
}
