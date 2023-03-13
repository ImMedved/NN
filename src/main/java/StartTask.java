import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StartTask {
    public static class UI extends JPanel implements ActionListener {
        public int numberOfInputTypes = 0;
        public List<String> listOfFiles = new ArrayList<>();

        public JButton button1, button2, button3;

        public UI() {
            button1 = new JButton("Add new string");
            button2 = new JButton("Add pair for last string");
            button3 = new JButton("Show all pairs");

            button1.setVerticalTextPosition(AbstractButton.CENTER);
            button1.setHorizontalTextPosition(AbstractButton.LEADING);
            button1.setMnemonic(KeyEvent.VK_D);
            button1.setActionCommand("AddQ");

            button2.setVerticalTextPosition(AbstractButton.CENTER);
            button2.setHorizontalTextPosition(AbstractButton.LEADING);
            button2.setMnemonic(KeyEvent.VK_C);
            button2.setActionCommand("AddA");

            button3.setVerticalTextPosition(AbstractButton.CENTER);
            button3.setHorizontalTextPosition(AbstractButton.LEADING);
            button3.setMnemonic(KeyEvent.VK_E);
            button3.setActionCommand("Show");

            button1.addActionListener(this);
            button2.addActionListener(this);
            button3.addActionListener(this);

            JPanel p1 = new JPanel();
            p1.add(button1);
            p1.add(button2);
            p1.add(button3);

            add(p1);
            }

        private static void createAndShowGUI() {

            //Create and set up the window.
            JFrame frame = new JFrame("Google Document AI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create and set up the content pane.
            UI newContentPane = new UI();
            newContentPane.setOpaque(true); //content panes must be opaque
            frame.setContentPane(newContentPane);

            frame.setSize(500, 400);
            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }

            @Override
        public void actionPerformed(ActionEvent e) {
            if ("AddQ".equals(e.getActionCommand())) {

            } else if ("AddA".equals(e.getActionCommand())) {

            } else if ("Show".equals(e.getActionCommand())) {

            }
        }


        public static void main(String[] args) {
            new getActiveData();
            javax.swing.SwingUtilities.invokeLater(UI::createAndShowGUI);
        }
    }
}

