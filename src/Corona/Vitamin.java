package Corona;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.Timer;


public class Vitamin extends Rintangan {
    
    public Vitamin(int roadNumber, int velocityInMs, BufferedImage image) {
        super(roadNumber, velocityInMs, image);
    }
    
    public void setStartingPositionFromRoadNumber(int roadNumber) {
        switch (roadNumber) {
            case 1:
                roadNumber = 75;
                break;
            case 2:
                roadNumber = 175;
                break;
            case 3:
                roadNumber = 275;
                break;
        }
        yPosition = 150;
        setLocation(roadNumber, yPosition);
    }
    
//    public void start() {
//        timer.start();
//    }
//    
//    public void stop() {
//        timer.stop();
//    }
    
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(policeCarImage, 0, 0, this);
//    }
    
}
