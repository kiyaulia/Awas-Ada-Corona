package Corona;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.Timer;


public abstract class Rintangan extends JComponent {
    
    protected final BufferedImage rintanganImage;
    protected int yPosition;
    protected final Timer timer;
    
    public Rintangan(int roadNumber, int velocityInMs, BufferedImage image) {
        setSize(100, 100);
        setStartingPositionFromRoadNumber(roadNumber);
        rintanganImage = image;
        timer = new Timer(velocityInMs, (e) -> {
            yPosition += 10;
            setLocation(getLocation().x, yPosition);
            repaint();
        });
    }
    
    public abstract void setStartingPositionFromRoadNumber(int roadNumber);
    
    public void start() {
        timer.start();
    }
    
    public void stop() {
        timer.stop();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(rintanganImage, 0, 0, this);
    }
    
}
