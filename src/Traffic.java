import java.util.Random;

public class Traffic extends Sprite {

    private final int initTraffic_y = -100;
    private int speedOption = 1;
        
    public Traffic(int x, int y, int speedOption) {
        super(x, y);
        this.speedOption = speedOption;
        initTraffic();
    }

    private void initTraffic() {

        loadImage("src/images/Traffic.png");
        getImageDimensions();
    }

    public void move() {

        if (y > 2900) {
            y = initTraffic_y;
        }

        y += speedOption;
    }

}