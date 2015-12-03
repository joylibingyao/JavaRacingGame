import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener  {

    private int speedOption = 1;
    
    private Car car;
    private ArrayList<Traffic> traffic;
     private ArrayList<Lanes> lanes;
    private Timer timer;
    private boolean ingame;
    private final int initCar_x = 120;
    private final int initCar_y = 550;
    private final int initTraffic_x = 0;
    private final int initTraffic_y = 100;
    private final int gridWidth = 290;
    private final int gridHeight = 650;
    private final int DELAY = 15;
    private JLabel lostLabel = new JLabel("You lost !");
    
    
     private final int[][] pos = {// 25 
    {125, -50}, {220, -250}, {125, -450}, {125, -550},
    {25, -650}, {220, -850}, {125, -950}, {220, -1050},
    {125, -1250}, {220, -1250}, {25, -1450}, {25,-1650},
    {220, -1650}, {25, -1850}, {125, -1950}, {125, -2050},
    {25,-2150}, {25, -2250}, {220, -2250}, {25, -2350},
    {125, -2450}, {25, -2550}, {220, -2750}, {125, -2850}};

     

    public Game(int speedOption) {
        this.speedOption = speedOption;
        initGame();
    }

    private void initGame() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(gridWidth, gridHeight));

        car = new Car(initCar_x, initCar_y);

        initTraffic();
        initLanes();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    
    public void initTraffic() {
        traffic = new ArrayList<>();

        for (int[] p : pos) {
            traffic.add(new Traffic(p[0], p[1], speedOption));
        }
    }
    public void initLanes() {
        lanes = new ArrayList<>();

        for (int i = 1; i<3;i++){//
            for (int j = 0; j<40;j++){//verical
                lanes.add(new Lanes(i*94,j*100,speedOption));
            }
        }
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {
        
        
        for (Traffic t : traffic) {
            if (t.isVisible()) {
                g.drawImage(t.getImage(), t.getX(), t.getY(), this);
            }
        }
        for (Lanes l : lanes) {
            if (l.isVisible()) {
                g.drawImage(l.getImage(), l.getX(), l.getY(), this);
            }
        }
        if (car.isVisible()) {
            g.drawImage(car.getImage(), car.getX(), car.getY(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateCar();
        updateTraffic();
        checkCollisions();

        repaint();        
        
    }

    private void inGame() {

        if (!ingame) {
            timer.stop();
            add(lostLabel);
            
            lostLabel.setFont(new Font("Serif", 1, 24));
            lostLabel.setForeground(Color.white);
            
        }
    }
    public void checkCollisions() {

    Rectangle r3 = car.getBounds();

    for (Traffic alien : traffic) {
        Rectangle r2 = alien.getBounds();

        if (r3.intersects(r2)) {

            ingame = false;
        }
    }

}
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            car.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            car.keyPressed(e);
        }
    }

    private void updateCar() {

        if (car.isVisible()) {
            car.move();
        }
    }
    
    private void updateTraffic() {

        if (traffic.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < traffic.size(); i++) {

            Traffic t = traffic.get(i);
            if (t.isVisible()) {
                t.move();
            } else {
                traffic.remove(i);
            }
        }
        
        for (int i = 0; i < lanes.size(); i++) {

            Lanes l = lanes.get(i);
            if (l.isVisible()) {
                l.move();
            } else {
                traffic.remove(i);
            }
        }
    }
}   
