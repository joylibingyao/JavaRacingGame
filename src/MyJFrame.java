import java.io.IOException;

import javax.swing.JFrame;

public class MyJFrame extends JFrame {

    MyJFrame() throws IOException {
        super("IST Java Final Project");
        MyJPanel mjp = new MyJPanel();
        getContentPane().add(mjp, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 480);
        setVisible(true);

    }
}
