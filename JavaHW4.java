import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Hw4ViewerPanel extends JPanel {
    ArrayList<Shape> rect = new ArrayList<>();
    Hw4ViewerPanel() {
        setLayout(null);

        rect.add(new Rectangle2D.Float(0,0,340,150));
    }

    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		Graphics2D g1;
        g1 = (Graphics2D) g;
		g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g1.setComposite(AlphaComposite.getInstance
				       (AlphaComposite.SRC_OVER, 0.7f));
		GradientPaint gp1 = new GradientPaint
				            (0,0, Color.DARK_GRAY, 0,200, Color.GRAY);
        
        g1.setPaint(gp1);
        g1.fill(rect.get(0));
	}
}

class Hw4TextPanel extends JPanel {
    ArrayList<Shape> rect = new ArrayList<>();
    JTextField text = new JTextField();
    Color col = new Color(80,140,80);
    Hw4TextPanel() {
        setLayout(null);

        rect.add(new Rectangle2D.Float(0,0,300,110));
    }

    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		Graphics2D g1;
        g1 = (Graphics2D) g;
		g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g1.setComposite(AlphaComposite.getInstance
				       (AlphaComposite.SRC_OVER, 0.7f));
		GradientPaint gp1 = new GradientPaint
				            (0,0, col, 0,200, Color.DARK_GRAY);
        
        g1.setPaint(gp1);
        g1.fill(rect.get(0));
	}
}

public class JavaHW4 extends JFrame{
    final static String[][] str = {{"7", "8", "9", "c"},
                                 {"4", "5", "6", "+"},
                                 {"3", "2", "1", "-"},
                                 {"0", " ", " ", "="}};
    JButton[][] but = new JButton[4][4];
    JPanel viewer = new Hw4ViewerPanel();
    JPanel texter = new Hw4TextPanel();
    JPanel outPanel = new JPanel();
    Font font = new Font("맑은 고딕", Font.BOLD, 30);
    JavaHW4() {
        setTitle("Homework2");
        setSize(500, 500);
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        outPanel.setBounds(80, 150, 340, 350);
        outPanel.setBackground(Color.white);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                but[i][j] = new JButton(str[i][j]);
                but[i][j].setBounds(80 + (85 * (j)), 150 + (80 * (i)), 85 , 80);
                but[i][j].setBackground(Color.ORANGE);
                but[i][j].setFont(font);
                c.add(but[i][j]);
            }
        }
        viewer.setBounds(80, 0, 340, 150);
        texter.setBounds(100, 20, 300, 110);
        c.add(outPanel);
        c.add(texter);
        c.add(viewer);
        setVisible(true);
        setResizable(true);
        setPreferredSize(new Dimension(500, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new JavaHW4();
    }
    
}