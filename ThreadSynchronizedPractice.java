
class BankClient extends Thread {
	BankAcount act;
	BankClient(String name, BankAcount b){
		super(name);
		act = b;
	}
	@Override
	public void run() {
		for(int i = 0; i<100; i++)
			act.deposit(10, this);
	}
}


class BankAcount {
	long money = 0;
	
	// critical section
	// Vector / ArrayList 
	
//	synchronized void deposit(int inc, BankClient c) {
	void deposit(int inc, BankClient c) {
		synchronized(this) {
			long cur = money;
			cur = cur + inc;
	//		Thread.yield();
	
			try {
				Thread.sleep((int)(Math.random()*10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			money = cur;
		}
		System.out.println("Current Money: "+ money 
				           + " by "+c.getName());
	}
}


public class ThreadSynchronizedPractice {
	public static void main(String[] args) {
		BankAcount ba = new BankAcount();
		
		BankClient c1 = new BankClient("c1", ba);
		BankClient c2 = new BankClient("c2", ba);
		BankClient c3 = new BankClient("c3", ba);
		
		c1.start();
		c2.start();
		c3.start();
		
	}
}