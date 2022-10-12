abstract class SoShape 
{
	int x,y;
	String color;
	
	SoShape next;
	
	SoShape(){
		x = 0;
		y = 0;
		color = "black";
		next = null;				// nullptr, NULL
	}
	SoShape(int _x, int _y, String c){
		x = _x;
		y = _y;
		color = c;
	}

	public String toString() {
		String str;
		str = "("+x+","+y+") c="+color;
		return str;
	}
	abstract public void draw();
}

class SoRect extends SoShape{
	int w, h;
	SoRect(){
		w = 0; 
		h = 0;
	}
	SoRect(int _x, int _y, int _w, int _h, String c){
		super(_x, _y, c);
		w = _w;
		h = _h;
	}
	@Override
	public String toString() {
		String str = super.toString();
		str += ", w="+w+", h="+h;
		return str;
	}
	@Override
	public void draw() {						// 재정의 : Overriding (!= overloading)
		System.out.println("[RECT] " + toString());
	}
}

abstract class SoLine extends SoShape {
}

class SoLine2 extends SoShape {
    @Override
    public void draw() {
        // TODO Auto-genertated method stub
    }
}

class SoCircle extends SoShape{
	float radius;
	SoCircle(){
		radius = 0.0f;
	}
	SoCircle(int _x, int _y, float _r, String c){
		super(_x, _y, c);
		radius = _r;
	}
	@Override
	public String toString() {
		String str = super.toString();
		str += ", r="+radius;
		return str;
	}
	@Override
	public void draw() {
		System.out.println("[CIRCLE] "+toString());
		
	}
}

public class Polymorphism {

	public static void main(String[] args) {
		SoShape [] arr = new SoShape[3];
		arr[0] = new SoRect(10,20,1,2,"red");
		arr[1] = new SoRect(20,30,3,4,"blue");
		arr[2] = new SoCircle(0,3,1.0f, "green");
		
		for( SoShape e : arr)
			e.draw();					// Dynamic Binding  (= polymorphism 다형성)

		
		Object[] oarr = arr;
		for( Object e : oarr)
		{
			if(e instanceof SoShape)
			{
				SoShape s = (SoShape) e;
				s.draw();
			}
		}
		
		
		
		SoShape a = new SoRect(10,20,10,20,"red");
		SoRect b = new SoRect(20,30,3,4,"blue");
		SoCircle c = new SoCircle(0,3,1.0f, "green");
		
		a.next = b;
		b.next = c;
		
		SoShape head = a;
		/*	
		head.draw();
		head.next.draw();
		head.next.next.draw();
		 */		

		while(head != null)
		{
			System.out.println(head);
			head = head.next;
		}
		
	
		
	}

}
