package Object;

import javax.swing.*;
import java.awt.*;

public class Bloc extends Object{
    private Image imgBloc;
    private ImageIcon icoBloc;

    public Bloc(int x, int y) {
        super(x, y, 43, 65);
        this.icoBloc = new ImageIcon(getClass().getResource("/Images/bloc.png"));
        this.imgBloc = this.icoBloc.getImage();
    }

    public Image getImgBloc() { return imgBloc; }
}
