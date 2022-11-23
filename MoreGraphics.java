import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Float;

class MyStroke{
	ArrayList<Point> pts = new ArrayList<>();
	Color color = Color.black;
	MyStroke(int x, int y, Color c){
		pts.add(new Point(x,y));
		color = c;
	}
	void addPoint(int x, int y) {
		pts.add(new Point(x,y));	
	}
	void draw(Graphics g) {
		g.setColor(color);
		for(int i = 0; i<pts.size()-1; i++) {
			Point p1 = pts.get(i);
			Point p2 = pts.get(i+1);
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
		}		
	}
}


class MyColorButton extends JButton {
    Color color = Color.BLACK;
    MyColorButton(String str, Color c) {
        super(str);
        color = c;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));
    
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        GradientPaint gp = new GradientPaint(0,0, Color.WHITE, 500, 500, Color.BLUE);
    
        g2.setPaint(gp);
        Rectangle2D sh = new Rectangle2D.Float(100,100,300,300);
        g2.draw(sh);
        g.setColor(color);
        g.fillRect(4, 4,getWidth() - 8, getHeight() - 8);
    }
}

class MoreGraphicsPanel extends JPanel{
	
	LinkedList<MyStroke> strokes = new LinkedList<>();
	Color curColor = Color.black;
	MoreGraphicsPanel(){
		
		MyColorButton but1 = new MyColorButton("R", Color.RED);
		but1.addActionListener((e)->curColor=but1.color);
		MyColorButton but2 = new MyColorButton("G", Color.GREEN);
		but2.addActionListener((e)->curColor=but2.color);
		MyColorButton but3 = new MyColorButton("B", Color.BLUE);
		but3.addActionListener((e)->curColor=but3.color);
		
		add(but1);
		add(but2);
		add(but3);
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				strokes.add(new MyStroke(e.getX(), e.getY(), curColor));
			}
		});
		
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				strokes.get(strokes.size()-1).addPoint(e.getX(), e.getY());
				repaint();
			}
		});
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		g.drawString("Num of strokes: "+ strokes.size(), 0,30);
		
		for(var s : strokes)
			s.draw(g);
			
	}
}

public class MoreGraphics extends JFrame{
	MoreGraphics(){
		setTitle("More Graphics!");
		setSize(500,500);
		add(new MoreGraphicsPanel());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new MoreGraphics();
	}
	
	
}