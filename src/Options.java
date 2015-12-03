import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Options extends JPanel {

    JButton retButton;
    JLabel enterName;
    JTextField playerName;
    JLabel enterDiff;

    JSlider difficulty;
    private int speed;
    private String name;
    private boolean soundstatus;

    private JLabel sound;
    private JToggleButton soundtoggle;

    Options() {

        enterName = new JLabel("Enter Player Name");
        playerName = new JTextField("Player");

        enterDiff = new JLabel("Enter Difficulty");
        difficulty = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
        difficulty.setMajorTickSpacing(1);
        difficulty.setPaintLabels(true);
        difficulty.setPaintTicks(true);

        sound = new JLabel("Sound");
        soundtoggle = new JToggleButton("Sound: off");

        retButton = new JButton("Save and Return");

        add(enterName);
        add(playerName);

        add(enterDiff);
        add(difficulty);

        add(sound);
        add(soundtoggle);

        add(retButton);

    }

    public int getSpeed() {

        return difficulty.getValue();
    }

    public String getName() {

        return playerName.getText();
    }

    public void setToggleLabel(boolean bool) {

        if (bool == true) {
            soundtoggle.setText("Sound: on");
            soundstatus = true;
        } else {
            soundtoggle.setText("Sound: off");
            soundstatus = false;

        }
    }

    public void addToggleListener(ItemListener il) {
        soundtoggle.addItemListener(il);
    }

    public boolean getSound() {
        return soundstatus;
    }

    public String getSoundText() {
        return soundtoggle.getText();
    }
}
