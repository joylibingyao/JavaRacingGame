import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Credits extends JPanel{
    JLabel credits;
    JButton retCredButton;
    
    Credits(){
        credits = new JLabel("IST 242 Team 6");
        retCredButton = new JButton("Return to main menu");
        
        add(credits);
        add(retCredButton);
    }
}
