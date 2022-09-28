
class Point {
    static float maxx = 100.0f; // 변수가 하나, 각 객체들이 공유함
    static float minx = 0.0f;
    private float x,y;
    //private float maxx = 100.0f; // 메모리 낭비, 변화할 수 도 있어야하지 않나.
    //private float minx = 0.0f;

    Point() {
        x = 0.0f;
        y = 0.0f;
    }
    Point(float _x, float _y) {
        x = _x;
        y = _y;
    }
    void setX(float in) {
        if (in > maxx || in < minx) {
            System.out.println("wrong input");
            return ;
        }
        this.x = in;
    }

    float getX() {
        return this.x;
    }

    void increase(Point in) {
        this.x += in.x;
        this.y += in.y;
    }

    float getDist2(Point a, Point b) {
        return (float)(Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)));
    }

    float getDist2(Point in) {
        return getDist2(this, in);
    }

    float getLength2() {
        return getDist2(this, new Point(0, 0));
    }

    void printArray(Point[] arr) {
        for (Point e : arr) {
            e.print();
        }
    }
    void print() {
        System.out.println("[Point] = (" +x +", "+ y + ")");
    }
}

public class HelloClassPart2 {
    static final int T = 10;
    public static void main(String[] args) {
        Point a = new Point();
        a.print();
        Point b = new Point(3.3f , 5.2f);
        b.print();
        
        Point.maxx = 1000.0f;

        a.increase(b);
        System.out.println("----");
        float newX = 111.12f;
        float newY = 15.54f;
        a.setX(newX);
        a.print();
        a.setX(newY);
        a.print();
        System.out.println(newX);

        Integer ax;
        ax = 7;
        System.out.println(ax);
        //a = null;
        // a.print();

        //int[] arr = new int[10];  // int 형 배열
        Point[] arr = new Point[10]; // Point 레퍼런스 형 배열
        for (int i = 0; i < 10; i++) {
            arr[i] = new Point(i * 0.84f, i * 20);
        }

        for (Point e : arr) e.print();

        Point[] arr2 = {new Point(), new Point(1.1f, 2.9f)};

        arr2[0].print();
        arr2[1].print();
    }
}
