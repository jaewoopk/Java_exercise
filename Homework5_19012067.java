import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

abstract class MObject{
	float x;
	float y;
	Color color;
	MObject(float _x, float _y, Color c){
		x = _x;
		y = _y;
		color = c;
	}
	abstract void draw(Graphics g);
	void update(float dt) {};
	abstract void collisionResolution(MObject o);
}

class MWall extends MObject{
	float width;
	float height;
	MWall(float _x, float _y, float _w, float _h, Color c){
		super(_x, _y, c);
		width = _w;
		height = _h;
	}
	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}
	void collisionResolution(MObject o) {
		
	}
}

class MPlayer extends MObject{
    float width;
	float height;
	MPlayer(float _x, float _y, float _w, float _h, Color c){
		super(_x, _y, c);
		width = _w;
		height = _h;
	}
    void lMoving() {
        this.x -= 10;
    }
    void rMoving() {
        this.x += 10;
    }
	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}
	void collisionResolution(MObject o) {
		
	}
}

class MBall extends MObject{
	float radius;
	float vx;
	float vy;
	
	float pre_x;
	float pre_y;
		
	
	MBall(float _x, float _y, float r, Color c){
		super(_x, _y, c);
		radius = r;
		
		pre_x = x;
		pre_y = y;
		
		float speed = 100.0f;
		float angle = (float)((Math.random() % 0.3 + 0.6)*2.0*3.141592);
		vx = speed * (float)(Math.cos(angle));
		vy = speed * (float)(Math.sin(angle));
	
	}
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius));
	}
	@Override
	void update(float dt) {
		
		pre_x = x;
		pre_y = y;
		
		x += vx*dt;
		y += vy*dt;
		
	}
	boolean isCollide(MObject o) {
		if(o instanceof MWall) {
			MWall w =(MWall) o;
			
			if(x>(w.x-radius) && x<(w.x+w.width+radius) &&
			   y>(w.y-radius) && y<(w.y+w.height+radius)) 				
				return true;
		}
		return false;
	}
    boolean isCollide2(MObject o) {
		if(o instanceof MPlayer) {
			MPlayer p =(MPlayer) o;
			
			if(x>(p.x-radius) && x<(p.x+p.width+radius) &&
			   y>(p.y-radius) && y<(p.y+p.height+radius)) 				
				return true;
		}
		return false;
	}
	
	void collisionResolution(MObject o) {
		if(o instanceof MWall) {
			MWall w =(MWall) o;
			
			if(pre_x < w.x - radius) {
				x = w.x-radius;
				vx = -vx;
			}
			
			if(pre_x > w.x+w.width+radius) {
				x = w.x+w.width + radius;
				vx = -vx;
			}
			
			if(pre_y < w.y - radius) {
				y = w.y - radius;
				vy = -vy;
			}
			if(pre_y > w.y + w.height + radius) {
				y = w.y + w.height + radius;
				vy = -vy;
			}
		}
	}

    void collisionResolution2(MObject o) {
		if(o instanceof MPlayer) {
			MPlayer w =(MPlayer) o;
			
			if(pre_x < w.x - radius) {
				x = w.x-radius;
				vx = -vx;
			}
			
			if(pre_x > w.x+w.width+radius) {
				x = w.x+w.width + radius;
				vx = -vx;
			}
			
			if(pre_y < w.y - radius) {
				y = w.y - radius;
				vy = -vy;
			}
			if(pre_y > w.y + w.height + radius) {
				y = w.y + w.height + radius;
				vy = -vy;
			}
		}
	}
}



class HomeworkPanel extends JPanel implements KeyListener, Runnable{
	
	LinkedList<MObject> objs;
    MPlayer player;
	boolean keyPressed = false;
    boolean lKey = false;
    boolean rKey = false;
	
	HomeworkPanel(){
		objs = new LinkedList<MObject>();
		objs.add(new MWall(0,0,800,20, Color.black));
		
		objs.add(new MWall(0,0,20,800, Color.black));
		objs.add(new MWall(765,0,20,800, Color.black));
		
        Random rand = new Random();
        float r, g, b;
        Color randomColor;
        for (int i = 0; i < 6; i++) {
            r = rand.nextFloat();
            g = rand.nextFloat();
            b = rand.nextFloat();
            randomColor = new Color(r, g, b);
            for (int j = 0; j < 6; j++) {
                objs.add(new MWall(30 + j * 122, 25 + i * 60 , 115, 50, randomColor));
            }
        }
        player = new MPlayer(365,720,70,20, Color.blue);
		objs.add(player);
		addKeyListener(this);
		
		setFocusable(true);
		requestFocus();
		
		Thread t = new Thread(this);
		t.start();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(var o : objs)
			o.draw(g);
	}
	public void keyTyped(KeyEvent e) {  	}
	public void keyReleased(KeyEvent e) { 	}
	public void keyPressed(KeyEvent e) { 	
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			keyPressed = true;
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            lKey = true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            rKey = true;
            
	}
	@Override
	public void run() {
		try {
			while(true) {			//GAME LOOP
				// key input
				if(keyPressed == true) {
					objs.add(new MBall(player.x + 40,player.y,5, Color.red));
					keyPressed = false;
				}
                if(lKey == true) {
                    player.lMoving();
					lKey = false;
				}
                if(rKey == true) {
                    player.rMoving();
					rKey = false;
				}

				// update
				for(var o : objs)
					o.update(0.04f);
				
				// collision resolution
				for(var o : objs) {
					if( (o instanceof MBall) != true) continue;
					
					for(var w : objs) {
						if( (w instanceof MWall) != true) continue;
						MWall wall = (MWall) w;
						MBall ball = (MBall) o;

						if(ball.isCollide(wall)){
							ball.collisionResolution(wall);
						}
					}
                    for (var w : objs) {
                        if ((w instanceof MPlayer) != true) continue;
                        MPlayer p = (MPlayer) w;
                        MBall ball2 = (MBall) o;

                        if(ball2.isCollide2(p)){
							ball2.collisionResolution2(p);
						}
                    }
				}
				// repaint
				repaint();			
				
				Thread.sleep(16);
			}
		}catch(Exception E) {
			return;
		}		
	}
	

}

public class Homework5_19012067 extends JFrame{

	Homework5_19012067(){
		
		setSize(800,800);
		setTitle("Homework Practice");
		
		add(new HomeworkPanel());
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Homework5_19012067();
	}

}