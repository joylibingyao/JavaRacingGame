import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.io.*;
import javax.swing.JTextArea;


public class Instructions extends JPanel{
    JLabel instructions;
    JButton retInstButton;
    JTextArea text;
    BufferedReader textFile;
    
    Instructions() throws FileNotFoundException, IOException{
        instructions = new JLabel();
        retInstButton = new JButton("Return to main menu");
        text = new JTextArea();
        textFile = new BufferedReader(new FileReader("src/textfiles/instruction.txt"));
        
        text.setEditable(false);
        
        String line;
        while((line = textFile.readLine()) != null){
            text.append(line + "\n");
        }
        textFile.close();
        
        add(text);
        add(retInstButton);
    }
    
}
