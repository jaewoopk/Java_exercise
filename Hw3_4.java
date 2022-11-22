import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Hw3_4_MouseEvent extends JPanel implements MouseListener{
    JLabel label;
    Hw3_4_MouseEvent() {
        addMouseListener(this);
        
        label = new JLabel("C");
        label.setLocation(100, 100);
        label.setSize(15,15);
        label.setLayout(null);
        add(label);
        setFocusable(true);
        requestFocus();
    }
    public void mouseClicked(MouseEvent e) {   
        int nx = (int) (Math.random() * 400);
        int ny = (int) (Math.random() * 400);

        label.setLocation(nx, ny);
        repaint();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
}
public class Hw3_4 extends JFrame{
    Hw3_4() {
        setTitle("클릭 연습 용 응용프로그램");
        setSize(400, 400);
        
        add(new Hw3_4_MouseEvent());
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Hw3_4();
    }
}
