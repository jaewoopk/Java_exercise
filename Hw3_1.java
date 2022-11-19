import java.awt.*;
import javax.swing.*;

public class Hw3_1 extends JFrame{
    Hw3_1() {
        setTitle("Ten Color Buttons Frame");
        JButton[] but = new JButton[10];
        final String[] but_name = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Color[] but_color = {Color.RED, Color.ORANGE,
                               Color.YELLOW, Color.GREEN,
                               Color.CYAN, Color.BLUE,
                               Color.MAGENTA, Color.DARK_GRAY,
                               Color.PINK, Color.LIGHT_GRAY};
        setLayout(new GridLayout(1,10));
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(but_name[i]);
            but[i].setBackground(but_color[i]);
            but[i].setOpaque(true);
            but[i].setBorderPainted(false);
            add(but[i]);
        }
        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Hw3_1();
    }
}