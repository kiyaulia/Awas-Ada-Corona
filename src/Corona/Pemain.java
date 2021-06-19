package Corona;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;


public class Pemain extends JComponent {

    private final BufferedImage pemainImage;
    private int pemainXPosition = 175;
    
    public Pemain(BufferedImage image) {
        setSize(100, 100);
        setLocation(pemainXPosition, 430);
        pemainImage = image;
    }
    
    public void moveLeft() {
        if (pemainXPosition != 75) {
            pemainXPosition -= 100;
            setLocation(pemainXPosition, 430);
            repaint();
        }
    }
    
    public void moveRight() {
        if (pemainXPosition != 275) {
            pemainXPosition += 100;
            setLocation(pemainXPosition, 430);
            repaint();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pemainImage, 0, 0, this);
    }
            
}
