import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
    JButton splashButton;
    JLabel optionsLabel;
    
    MainPanel()
    {
            splashButton = new JButton(new ImageIcon("src/images/Capture.PNG"));            
            add(splashButton);
            
            optionsLabel = new JLabel("No options selected yet.");
            add(optionsLabel);
            
    }
}
