package Corona;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.Timer;


public class Virus extends Rintangan {
    
    public Virus(int roadNumber, int velocityInMs, BufferedImage image) {
       super(roadNumber, velocityInMs, image);
    }
    
    @Override
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
        yPosition = -100;
        setLocation(roadNumber, yPosition);
    }
    
//    @Override
//    public void start() {
//        timer.start();
//    }
//    
//    @Override
//    public void stop() {
//        timer.stop();
//    }
    
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(policeCarImage, 0, 0, this);
//    }
    
}
