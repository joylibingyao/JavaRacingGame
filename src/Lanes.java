/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bingyaoli
 */
import java.util.Random;

public class Lanes extends Sprite {

    private final int initLanes_y = -100;
    private double speedOption = 0.5;
        
    public Lanes(double x, double y, double speedOption) {
        super(x, y);
        this.speedOption = speedOption;
        
        initLanes();
    }

    private void initLanes() {

        loadImage("src/images/lane.png");
        getImageDimensions();
    }

    public void move() {

        if (y > 1240) {
            y = initLanes_y;
        }

        y += speedOption;
    }

}