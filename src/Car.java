import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Car extends Sprite {

    private double dx;
    private double dy;


    public Car(double x, double y) {
        super(x, y);

        initCar();
    }

    private void initCar() {
        
  
        loadImage("src/images/carPlayer.png");
        getImageDimensions();
    }

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }
        else if (x > 290 - getBounds().getWidth()) {
            x = 290 - (int)getBounds().getWidth();
        }

        if (y < 1) {
            y = 1;
        }
    }



    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -8;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 8;
        }


    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

    }
}