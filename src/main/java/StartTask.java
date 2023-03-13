import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StartTask {
    public static class UI extends JPanel implements ActionListener {
        public int numberOfInputTypes = 0;
        public List<String> listOfFiles = new ArrayList<>();

        public JButton button1, button2, button3, button4;
        static JTextField textField;
        protected JTextArea textArea;
        public String output = "";

        public UI() {
            button1 = new JButton("Add new string");
            button2 = new JButton("Add pair for last string");
            button3 = new JButton("Show all pairs");
            button4 = new JButton("Sent");

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

            button3.setVerticalTextPosition(AbstractButton.CENTER);
            button3.setHorizontalTextPosition(AbstractButton.LEADING);
            button3.setMnemonic(KeyEvent.VK_0);
            button3.setActionCommand("Sent");

            button1.setToolTipText("Click to add question string");
            button2.setToolTipText("Click to add answer string");
            button3.setToolTipText("Click to create file with all pairs");
            button4.setToolTipText("Click to sent a message");

            button1.addActionListener(this);
            button2.addActionListener(this);
            button3.addActionListener(this);
            button4.addActionListener(this);

            textField = new JTextField(25);
            textField.addActionListener(this);

            textArea = new JTextArea(5, 25);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setText("Write your text on the left");

            GridBagConstraints c = new GridBagConstraints();
            c.gridwidth = GridBagConstraints.REMAINDER;
            c.fill = GridBagConstraints.BOTH;
            c.weightx = 1.0;
            c.weighty = 1.0;

            JPanel p1 = new JPanel();
            JPanel p2 = new JPanel();

            p1.add(button1);
            p1.add(button2);
            p1.add(button3);
            p2.add(textField, c);
            p2.add(button4);
            p2.add(scrollPane, c);

            JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, p1, p2);

            add(splitPane);
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
                LinkedList allData;
                allData = new getActiveData();
                try {
                    new ListOfArrays(allData);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            } else if ("Sent".equals(e.getActionCommand())){
                String text = String.valueOf(textField.getText());
                if (text.length() == 0){
                    textArea.repaint();
                    textArea.setText("No input found");
                }
                output = String.valueOf(new findCommon(text));
                textArea.setText(output);
            }
        }


        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(UI::createAndShowGUI);
        }
    }
}

