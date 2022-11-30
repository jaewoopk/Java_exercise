import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Hw4ViewPanel extends JPanel {
    ArrayList<Shape> rect = new ArrayList<>();
    Hw4ViewPanel() {
        add(new JLabel("hello"));
        add(new JTextField("16"));
        rect.add(new Rectangle2D.Float(70,0,340,150));
        rect.add(new Rectangle2D.Float(90,18,300,115));
        setLayout(new FlowLayout());
    }

    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setComposite(AlphaComposite.getInstance
				      (AlphaComposite.SRC_OVER, 0.9f));
		
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g3.setComposite(AlphaComposite.getInstance
				      (AlphaComposite.SRC_OVER, 0.7f));
		GradientPaint gp = new GradientPaint
				            (0,0, Color.GRAY, 350,350, Color.DARK_GRAY);
		
        GradientPaint gp2 = new GradientPaint
	    		            (0,0, Color.DARK_GRAY, 350,350, Color.BLUE);
		g2.setPaint(gp);
        g3.setPaint(gp2);
        g2.fill(rect.get(0));
        g3.fill(rect.get(1));
	}
}

class Hw4ButtonPanel extends JPanel {
    final static String[][] str = {{"7", "8", "9", "c"},
                                 {"4", "5", "6", "+"},
                                 {"3", "2", "1", "-"},
                                 {"0", " ", " ", "="}};
    Hw4ButtonPanel() {
        JButton[][] but = new JButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                but[i][j] = new JButton(str[i][j]);
                add(but[i][j]);
            }
        }
        setLayout(new GridLayout(4,4,2,2));
    }
}


public class JavaHW4 extends JFrame{
    JavaHW4() {
        setTitle("Homework2");
        add(new Hw4ButtonPanel());
        setSize(500, 500);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JavaHW4();
    }
}