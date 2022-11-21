import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

abstract class Shape2D {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;

    protected Color color;
    Shape2D() {
        int r1 = (int)(Math.random() * 255);
        int g1 = (int)(Math.random() * 255);
        int b1 = (int)(Math.random() * 255);
        color = new Color(r1,g1,b1);
    }
    Shape2D(int x, int y) {
        this();
        setPosition1(x, y);
    }
    public void setPosition1(int x, int y) {
        x1 = x;
        y1 = y;
    }
    public void setPosition2(int x, int y) {
        x2 = x;
        y2 = y;
    }
    abstract public void draw(Graphics g);
}

class Line2D extends Shape2D{

    Line2D(int x, int y) {
        super();
        setPosition1(x, y);
    }
    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
    
}

class Rect2D extends Shape2D {

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        g.setColor(color);
        g.fillRect(x1, y1, x2-x1, y2-y1);
    }
    
}

class DrawingPracticePanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener{

    int tx = 0;
    int ty = 30;

    LinkedList<Line2D> lines;
    DrawingPracticePanel() {
        lines = new LinkedList<Line2D>();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        requestFocus();
    }
    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g); // Override 할 때는 super.을 넣어야한다

        g.setColor(Color.RED);
        g.drawLine(100, 200, 300, 400);
        for (int i = 0; i < 10; i++)
            g.drawRect(100 + 10 * i, 100 + 10 * i, 50 + 10 * i, 50 + 10 * i);
        g.setColor(Color.BLUE);
        g.drawOval(100, 100, 100, 200);
        g.fillRoundRect(50, 50, 10, 50, 50, 50);

        g.setColor(Color.RED);
        g.drawOval(100, 100, 300, 300);

        int x[] = {300,400,400};
        int y[] = {100,140,240};

        g.fillPolygon(x,y,3);

        int r1 = (int)(Math.random() * 255);
        int g1 = (int)(Math.random() * 255);
        int b1 = (int)(Math.random() * 255);
        Color c = new Color(r1, g1, b1);
        g.setColor(c);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 30);
        g.setFont(font);
        g.drawString("Sejong university", tx, ty);

        //g.drawLine(x1, y1, x2, y2);
        for (Line2D line : lines) {
            line.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyCode()) {
        case KeyEvent.VK_LEFT : tx -= 10;    break;
        case KeyEvent.VK_RIGHT : tx += 10;   break;
        case KeyEvent.VK_UP : ty -= 10;      break;
        case KeyEvent.VK_DOWN : ty += 10;    break;
        default :                            break;
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {    }
    @Override
    public void mousePressed(MouseEvent e) {   
        lines.add(new Line2D(e.getX(), e.getY()));
    }
    @Override
    public void mouseReleased(MouseEvent e) {  
        lines.get(lines.size()-1).setPosition2(e.getX(), e.getY());
        repaint();
    }
    @Override
    public void mouseEntered(MouseEvent e) {    }
    @Override
    public void mouseExited(MouseEvent e) {     }
    @Override
    public void mouseDragged(MouseEvent e) {
        lines.get(lines.size()-1).setPosition2(e.getX(), e.getY());
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {  }
}

public class DrawingPractice extends JFrame{
    DrawingPractice(){
        setSize(500,500);
        setTitle("Drawing Practice");

        add(new DrawingPracticePanel());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new DrawingPractice();
    }
}
