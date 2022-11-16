import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyKeyListener implements KeyListener {
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

}

class MyMouseListener implements MouseListener {

    public void mouseClicked(MouseEvent e) {
        System.out.println("Click!");
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed!");
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Released!");
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered!");
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Exit!");
    }

}

class MyMouseMotionListener implements MouseMotionListener {
    public void mouseDragged(MouseEvent e) {
        
    }

    public void mouseMoved(MouseEvent e) {
        
    }

}

// class MyMouseAdapter extends MouseAdpater {
//     @Override
//     public void mousePressed(MouseEvent e) {

//     }
//}

class MouseEventPracticePanel extends JPanel implements MouseListener,
                                                        MouseMotionListener,
                                                        KeyListener{
    Color c = new Color((int)(Math.random() * 255),
                        (int)(Math.random() * 255),
                        (int)(Math.random() * 255));
    //JButton but;
    JLabel text;
    MouseEventPracticePanel() {
        setBackground(c);
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);

        //but = new JButton("Mouse event:");
        text = new JLabel();
        //add(but);
        add(text);
        text.setLocation(100, 100);
        text.setSize(200, 20);

        setFocusable(true);
        requestFocus();
    }
    public void mouseClicked(MouseEvent e) {   
        if (e.getClickCount() == 2) {
            System.out.println("Double Click!");
        } 
    }
    public void mousePressed(MouseEvent e) {   
        java.awt.Point p = e.getPoint();
        System.out.println(p);

        switch(e.getButton()) {
        case MouseEvent.BUTTON1 : System.out.println("Left!"); break ;
        case MouseEvent.BUTTON2 : System.out.println("Middle!"); break ;
        case MouseEvent.BUTTON3 : System.out.println("Right!"); break ;
        default : break ;
        }
        int x = e.getX();
        int y = e.getY();

        java.awt.Point tp = text.getLocation();
        Dimension d = text.getSize();
        if (x > tp.x && x < tp.x + d.width &&
            y > tp.y && y < tp.y + d.height) {
            System.out.println("Text Click!");
            Dimension pd = getSize();
            int nx = (int) (Math.random() * pd.width);
            int ny = (int) (Math.random() * pd.height);

            text.setLocation(nx, ny);
        }
        else {
            JLabel l = new JLabel("^_^");
            l.setLocation(x, y);
            l.setSize(30, 20);
            add(l);
            repaint();
        }
    }
    public void mouseReleased(MouseEvent e) {   }
    public void mouseEntered(MouseEvent e) { setBackground(Color.YELLOW);}
    public void mouseExited(MouseEvent e) { setBackground(c);}
    public void mouseDragged(MouseEvent e) { text.setText("Dragged:" + e.getPoint());}
    public void mouseMoved(MouseEvent e) { text.setText("Moved:" + e.getPoint());}
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed!" + e.getKeyChar());
        text.setText(text.getText() + e.getKeyChar());
    }
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed!" + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            java.awt.Point p = text.getLocation();
            p.x -= 10;
            text.setLocation(p);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            java.awt.Point p = text.getLocation();
            p.x += 10;
            text.setLocation(p);
        }
    }
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released!" + e.getKeyCode());
    }
}
public class MouseEventPractice extends JFrame{
    MouseEventPractice() {
        setTitle("Mouse Event Practice");
        setSize(500, 500);
        add(new MouseEventPracticePanel());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new MouseEventPractice();
    }
}
