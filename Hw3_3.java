import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Hw3_3 extends JFrame{
    String str = new String("Love Java");
    JLabel label;
    Hw3_3() {
        setTitle("Left 키로 문자열 이동");
        setSize(300, 100);

        label = new JLabel(str);
        label.addKeyListener(new Hw3_3_KeyPressed());
        add(label);
        setVisible(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.requestFocus();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    class Hw3_3_KeyPressed implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                str = str.substring(1) + str.substring(0, 1);
                label.setText(str);
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {}   
    }
    public static void main(String[] args) {
        new Hw3_3();
    }
}
