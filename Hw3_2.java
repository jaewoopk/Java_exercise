import java.awt.*;
import javax.swing.*;

class Hw3_2_FirstPanel extends JPanel {
    Hw3_2_FirstPanel() {
        setBackground(Color.GRAY);
        add(new JLabel("수식입력"));
    }
}
public class Hw3_2 extends JFrame{
    final static String[] str = {"+", "-", "x", "/"};
    Hw3_2() {
        setTitle("계산기 프레임");
        JButton[][] but = new JButton[4][4];
        setLayout(new GridLayout(4,4));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != 2 || j < 2) {
                    but[i][j] = new JButton(Integer.toString(i * 4 + j));
                }
                else {
                    if (j == 2) but[i][j] = new JButton("CE");
                    else but[i][j] = new JButton("계산");
                }
                add(but[i][j]);
            }
        }
        for (int i = 0; i < 4; i++) {
            but[3][i] = new JButton(str[i]);
            but[3][i].setBackground(Color.BLUE);
            but[3][i].setOpaque(true);
            but[3][i].setBorderPainted(false);
            add(but[3][i]);
        }
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Hw3_2();
    }
}
