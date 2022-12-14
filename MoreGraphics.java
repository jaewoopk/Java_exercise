import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
//import java.util.LinkedList;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class MoreGraphicsPanel extends JPanel{
	
	//LinkedList<MyStroke> strokes = new LinkedList<>();
	Color curColor = Color.black;
	
	ArrayList<Shape> shapes  = new ArrayList<>();
	
	
	MoreGraphicsPanel(){

		shapes.add(new Rectangle2D.Float(100,100,300,300));
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setStroke(new BasicStroke(3));

		g2.setComposite(AlphaComposite.getInstance
				      (AlphaComposite.SRC_OVER, 0.5f));
		
		GradientPaint gp = new GradientPaint
				            (0,0, Color.white, 500,500, Color.blue);
		
//		g2.setColor(Color.orange);
		g2.setPaint(gp);
		for(var sh : shapes){
			g2.fill(sh);	
		}
	
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