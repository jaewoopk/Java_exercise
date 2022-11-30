import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFlickeringLabel extends JLabel{
	int interval = 0;
	boolean bb = true;
	Color color;
	MyFlickeringLabel(String str, int itv, Color c){
		super(str);
		color = c;
		Thread t = new Thread(()->{
			try {
				while(true) {
					Thread.sleep(itv);
					bb = !bb;
					if(bb)
						this.setForeground(color);
					else
						this.setForeground(Color.gray);
				}
			}
			catch(InterruptedException e) {
				return;
			}
		});
		t.start();
	}
}


class MoreThreadPanel extends JPanel 
					  implements Runnable{
	JLabel label;
	int time = 0;
	boolean bRun = false;
	Thread t;
	
	MoreThreadPanel(){
		label = new JLabel("Time:"+time/10.0f);
		add(label);
		
		JButton but = new JButton("start");
		but.addActionListener((e)->{
			bRun = !bRun;
			if(bRun == true) {
				t = new Thread(this);
				t.start();
				but.setText("stop");
			}
			else {
				t.interrupt();
				but.setText("start");
			}
			
		});		
		add(but);
		
		
		MyFlickeringLabel a = new MyFlickeringLabel("Merry", 300, Color.red);
		add(a);
		MyFlickeringLabel b = new MyFlickeringLabel("Christmas", 100, Color.green);
		add(b);
	}

	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(100);
				time += 1;
				label.setText("Time:"+time/10.0f);
			}
		}
		catch (InterruptedException E) {
			return;
		}		
	}
}

class MyCalcThread extends Thread{
	int st;
	int ed;
	long sum = 0;
	MyCalcThread(String n, int s, int e){
		super(n);
		st = s;
		ed = e;
	}
	@Override
	public void run() {
		for(int i=st; i<ed; i++) 
			sum += i;
		System.out.println("T:"+getName()+" sum="+sum);
	}
}

public class MoreThread extends JFrame {
	MoreThread(){
		setTitle("More Thread");
		setSize(500,500);
		
		add(new MoreThreadPanel());
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MoreThread();
		
		MyCalcThread t1 = new MyCalcThread("t1", 0, 2500);
		MyCalcThread t2 = new MyCalcThread("t2", 2500, 5000);
		MyCalcThread t3 = new MyCalcThread("t3", 5000, 7500);
		MyCalcThread t4 = new MyCalcThread("t4", 7500, 10000);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		long sum = t1.sum+t2.sum+t3.sum+t4.sum;
		System.out.println("total sum="+sum);
	}
}
