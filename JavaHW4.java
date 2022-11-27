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
import javax.swing.JPanel;


class Hw4Panel extends JPanel {
    final static String[][] str = {{"7", "8", "9", "c"},
                                 {"4", "5", "6", "+"},
                                 {"3", "2", "1", "-"},
                                 {"0", " ", " ", "="}};
    ArrayList<Shape> rect = new ArrayList<>();
    Hw4Panel() {
	
        rect.add(new Rectangle2D.Float(70,0,340,150));
        rect.add(new Rectangle2D.Float(90,18,300,115));
        JButton[][] but = new JButton[4][4];
        
        GridBagConstraints[][] gbc = new GridBagConstraints[4][4];
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                but[i][j] = new JButton(str[i][j]);
                gbc[i][j] = new GridBagConstraints();
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gbc[i][j].gridx = j;
                gbc[i][j].gridy = i;
                add(but[i][j],gbc[i][j]);
            }
        }
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
	    		            (0,0, Color.BLACK, 350,350, Color.BLUE);
		g2.setPaint(gp);
        g3.setPaint(gp2);
        g2.fill(rect.get(0));
        g3.fill(rect.get(1));
	}
}


public class JavaHW4 extends JFrame{
    JavaHW4() {
        setTitle("Homework2");
        add(new Hw4Panel());
        setSize(500, 500);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JavaHW4();
    }
}