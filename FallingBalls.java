import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFallingBall {
	float px;
	float py;
	float vx;
	float vy;
	float ax;
	float ay;
	
	float radius;
	Color color;
	float age;
	static final float MAX_AGE = 10.0f;
	
	MyFallingBall(){
		px = 250.0f;
		py = 450.0f;
		
		vx = -100.0f + (float)(Math.random()*200.0);
		vy = -200.0f - (float)(Math.random()*100.0);;
		
		ax = 0.0f;
		ay = 98.0f;
		
		age = 0.0f;
		
		radius = 5.0f + (float)(Math.random()*5.0);;
		color = Color.red;		
	}
	void draw(Graphics g) {
		
		g.setColor(color);
		g.fillOval((int)(px-radius), (int)(py-radius),  
				   (int)(radius*2), (int)(radius*2));
	}
	void update(float dt) {
		ax = ax;
		ay = ay;
		
		vx += ax*dt;
		vy += ay*dt;
		
		px += vx*dt;
		py += vy*dt;
		
		age += dt;
		radius = 10 * ( 1- age/MAX_AGE);
	}
	MyFallingBall mirrorClone() {
		MyFallingBall b = new MyFallingBall();
		b.px = px;
		b.py = py;
		b.vx = -vx;
		b.vy = vy;
		b.ax = ax;
		b.ay = ay;
		b.age = age;
		b.color = color;
		b.radius = radius;	
		
		return b;
	}	
	
	MyFallingBall collisionResolution(Dimension d) {
		if(d.width<1) return null;
		
		if(px>d.width-radius) {
			px = d.width-radius;
			vx = -vx;
		}
		if(px<radius) {
			px = radius;
			vx = -vx;
		}
		if(py>d.height-radius) {
			py = d.height-radius;
			vy = -vy*0.8f;
			
			return mirrorClone();			
		}
		if(py<radius) {
			py = radius;
			vy= -vy;
		}
		return null;
	}
	boolean isDead() {
		if(age > MAX_AGE) return true;
		else return false;
	}
}

class FallingBallsPanel extends JPanel implements Runnable,
												 KeyListener{
	
	LinkedList<MyFallingBall> balls;
	
	FallingBallsPanel(){
		balls = new LinkedList<MyFallingBall>();
		
		Thread t = new Thread(this);
		t.start();
		
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString("Num of Balls:" + balls.size() , 0, 10);
		
		Iterator<MyFallingBall> it = balls.iterator();
		while(it.hasNext())
		{
			var b = it.next();
			b.draw(g);
		}
	}
	@Override
	public void run() {
		try {
			while(true) {			// Game loop
				Thread.sleep(16);
				// 1. update
				Iterator<MyFallingBall> it = balls.iterator();
				while(it.hasNext())
					it.next().update(0.016f);
				
				// 2. collision resolution
				ArrayList<MyFallingBall> temp
				 = new ArrayList<>();
				
				it = balls.iterator();
				while(it.hasNext()) {
					MyFallingBall b = 
					it.next().collisionResolution(getSize());
					if(b!= null)
						temp.add(b);
				}	
				
				// 3. add new born obj
				if(temp.size()>0)
					for(var b: temp)
						balls.add(b);
				temp.clear();				
				
				// 4. remove dead obj
				it = balls.iterator();
				while(it.hasNext())
					if(it.next().isDead())
						it.remove();					
				
				// r. redraw
				repaint();
			}
		} catch (InterruptedException e) {
			return;
		}
	}
	public void keyTyped(KeyEvent e) {	}
	public void keyReleased(KeyEvent e) {	}
	public void keyPressed(KeyEvent e) {	
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			balls.add(new MyFallingBall());
	}
}


public class FallingBalls extends JFrame{

	FallingBalls(){
		setTitle("falling balls");
		setSize(500,500);
		
		add(new FallingBallsPanel());
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FallingBalls();

	}

}