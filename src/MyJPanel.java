
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MyJPanel extends JPanel implements ActionListener, ItemListener {

    ButtonPanel buttonsPane;
    MainPanel mainPane;
    Options optPane;
    Instructions instPane;
    Credits credPane;
    private String sound;
    public int speedOption;

    public MyJPanel() throws IOException {
        super();
        setBackground(Color.red);
        setLayout(new BorderLayout());

        mainPane = new MainPanel();
        add(mainPane, BorderLayout.CENTER);

        buttonsPane = new ButtonPanel();
        add(buttonsPane, BorderLayout.SOUTH);

        optPane = new Options();
        instPane = new Instructions();
        credPane = new Credits();

        buttonsPane.options.addActionListener(this);
        buttonsPane.instructions.addActionListener(this);
        buttonsPane.credits.addActionListener(this);
        buttonsPane.start.addActionListener(this);

        optPane.retButton.addActionListener(this);
        optPane.addToggleListener(this);

        instPane.retInstButton.addActionListener(this);
        credPane.retCredButton.addActionListener(this);

    }

    public void clearTopPanel() {
        remove(mainPane);
        remove(optPane);
        remove(instPane);
        remove(credPane);

        revalidate();
        repaint();
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            optPane.setToggleLabel(true);
        } else if (e.getStateChange() != ItemEvent.SELECTED) {
            optPane.setToggleLabel(false);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == buttonsPane.options) {
            clearTopPanel();
            add(optPane, BorderLayout.CENTER);

        } else if (obj == buttonsPane.instructions) {
            clearTopPanel();
            add(instPane, BorderLayout.CENTER);
        } else if (obj == buttonsPane.credits) {
            clearTopPanel();
            add(credPane, BorderLayout.CENTER);
        } else if (obj == buttonsPane.start) {
            if (optPane.getSound() == true) {
                try {
                    RunSound bgm = new RunSound();
                } catch (IOException ex) {
                    Logger.getLogger(MyJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    GameFrame ex = new GameFrame(optPane.getSpeed());
                    ex.setVisible(true);
                }
            });

        } else if (obj == optPane.retButton) {
            clearTopPanel();
            optPane.setName(optPane.getName());
            mainPane.optionsLabel.setText("Username: " + optPane.getName() + "   Difficulty: " + optPane.getSpeed() + " " + optPane.getSoundText());

            add(mainPane, BorderLayout.CENTER);
        } else if (obj == instPane.retInstButton) {
            clearTopPanel();
            add(mainPane, BorderLayout.CENTER);
        } else if (obj == credPane.retCredButton) {
            clearTopPanel();
            add(mainPane, BorderLayout.CENTER);
        }

    }

}
