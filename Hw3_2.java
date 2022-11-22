import java.awt.*;
import javax.swing.*;

class Hw3_2_FirstPanel extends JPanel {
    Hw3_2_FirstPanel() {
        setBackground(Color.GRAY);
        add(new JLabel("수식입력"));
        add(new JTextField(16));
        setLayout(new FlowLayout());
    }
}

class Hw3_2_SecondPanel extends JPanel {
    final static String[] str = {"+", "-", "x", "/"};
    Hw3_2_SecondPanel() {
        JButton[][] but = new JButton[4][4];
        setLayout(new GridLayout(4,4,2,2));
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
            but[3][i].setBackground(Color.CYAN);
            add(but[3][i]);
        }
    }
}


class Hw3_2_ThirdPanel extends JPanel {
    Hw3_2_ThirdPanel() {
        setBackground(Color.YELLOW);
        add(new JLabel("계산결과"));
        add(new JTextField(16));
        setLayout(new FlowLayout());
    }
}
public class Hw3_2 extends JFrame{
    Hw3_2() {
        setTitle("계산기 프레임");
        add(new Hw3_2_FirstPanel(), BorderLayout.NORTH);
        add(new Hw3_2_SecondPanel(), BorderLayout.CENTER);
        add(new Hw3_2_ThirdPanel(), BorderLayout.SOUTH);
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Hw3_2();
    }
}
