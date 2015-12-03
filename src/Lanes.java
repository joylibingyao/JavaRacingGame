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
    private int speedOption = 1;
        
    public Lanes(int x, int y, int speedOption) {
        super(x, y);
        this.speedOption = speedOption;
        initLanes();
    }

    private void initLanes() {

        loadImage("src/images/lane.png");
        getImageDimensions();
    }

    public void move() {

        if (y > 2900) {
            y = initLanes_y;
        }

        y += speedOption;
    }

}