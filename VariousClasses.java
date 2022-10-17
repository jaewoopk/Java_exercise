interface Loggable {
    abstract public void print();
}

class Header implements Loggable {
    public void print() {
        System.out.println("Start!!---");
    }
}

class Footer implements Loggable {
    public void print() {
        System.out.println("End!!---");
    }
}

class MyTriangle {
    Point[] p;
    MyTriangle() {
        p = new Point[3];
        p[0] = new Point();
        p[1] = new Point(1, 3);
        p[2] = new Point(10, 20);
    }
    Point t1 = new Point(1.0f, 2.0f);
    Point t2 = new Point();

    float maxx = 100.0f;
    float minx = 0.0f;
    private class Point {
        float x, y;
    
        Point() {
            x = minx;
            y = 0;
        }
        Point(float _x, float _y) {
            x = _x;
            if (x > maxx) x = maxx;
            if (x < minx) x = minx;
            y = _y;
        }
    }
    
}

abstract class AnonymousTest {

}

public class VariousClasses {
    static void print(Loggable h, String str, Loggable f) {
        h.print();
        System.out.println(str);
        f.print();
    }
    public static void main(String[] args) {
        //AnonymousTest a = new AnonymousTest();
        //a.print();
        Header h = new Header();
        Footer f = new Footer();
        print(h, "Sejong Univ.", f);
    }
}
