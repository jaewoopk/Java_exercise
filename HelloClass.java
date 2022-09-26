class People {
	
	int age;
	String name;
	boolean isMarried;
	int children;
	
	void peopleinfo() {
		
		System.out.println("나이 :"+age);
		System.out.println("이름 :"+name);
		System.out.println("결혼 여부 :"+isMarried);
		System.out.println("자녀 수 :"+children);
	}
}

class Circling {
    int x = 0, y = 0;
    float radius = 1.0f;

    Circling() {
        radius = 0.0f;
    }

    Circling(int x, int y, float r) {
        this.x = x;
        this.y = y;
        this.radius = r;
    }

    float getArea() {
        return radius * radius * 3.141592f;
    }

    void print() {
        System.out.println("[Circle] (" + x + "," + y + ") , r = " + radius);
    }
}

public class HelloClass{
    public static void main(String[] args) {
        People peopleJames = new People();
		
		peopleJames.age = 40;
		peopleJames.name = "James";
		peopleJames.isMarried = true;
		peopleJames.children = 3;
		
		peopleJames.peopleinfo();

        Circling a = new Circling(10, 10, 5); // 다른 파일에 class Circle이 있으니까 안되네 신기함
        // 그래서 Circling으로 만들었음
        a.print();
    }
}
