import java.awt.*;
import javax.swing.*;

class Hw4FirstPanel extends JPanel {
    JTextField screen;
    Hw4FirstPanel() {
        screen = new JTextField();
        screen.setBounds(0,0,300,300);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setBackground(Color.GRAY);
        screen.setEditable(false);
        add(screen);
        setLayout(new FlowLayout());
    }
}

class Hw4SecondPanel extends JPanel {
    final static String[][] str = {{"7", "8", "9", "c"},
                                 {"4", "5", "6", "+"},
                                 {"3", "2", "1", "-"},
                                 {"0", " ", " ", "="}};
    Hw4SecondPanel() {
        JButton[][] but = new JButton[4][4];
        setLayout(new GridLayout(4,4));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                but[i][j] = new JButton(str[i][j]);
                add(but[i][j]);
            }
        }
    }
}


public class JavaHW4 extends JFrame{
    JavaHW4() {
        setTitle("Homework2");
        add(new Hw4FirstPanel(), BorderLayout.NORTH);
        add(new Hw4SecondPanel(), BorderLayout.CENTER);
        setSize(500, 500);
        setVisible(true);
        //setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JavaHW4();
    }
}