
import javax.swing.JFrame;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame {

    public int speedOption;
    Options optPane;

    public GameFrame(int speedOption) {
        this.speedOption = speedOption;
        initUI();
    }

    private void initUI() {

        add(new Game(speedOption));

        setResizable(false);
        pack();

        setTitle("Race Simulator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
