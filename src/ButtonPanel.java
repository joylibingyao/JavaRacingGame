import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
    JButton options;
    JButton instructions;
    JButton credits;  
    JButton start;
    
    ButtonPanel()
          
    {
        super();       
        options = new JButton("Options");
        instructions = new JButton("Instructions");
        credits = new JButton("Credits");
        start = new JButton("Start");
        
        add(start, BorderLayout.SOUTH);
        add(options, BorderLayout.SOUTH);
        add(instructions, BorderLayout.SOUTH);
        add(credits, BorderLayout.SOUTH);        
                
    }
}
