interface Loggable {
    abstract public void print();
}

interface Countable {
    int getNumber();
}

interface Judgeable {
    boolean judge(int n);
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
    float maxy = 50.0f;
    float miny = 5.0f;
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

            if (y > maxy) y = maxy;
            if (y < miny) y = miny;

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

        Countable c1 = new Countable() {
            public int getNumber() {
                return 100;
            }
        };
        // c1과 c2는 같음
        Countable c2 = () -> 100;
        Judgeable j = (n) -> ((n % 2) == 0);
        Countable c3 = () -> (int)(Math.random() * 100);

        System.out.println(c1.getNumber());
        System.out.println(c2.getNumber());
        System.out.println(c3.getNumber());
        System.out.println(j.judge(51));
        //AnonymousTest a = new AnonymousTest();
        //a.print();
        Header h = new Header();
        Footer f = new Footer();
        print(h, "Sejong Univ.", f);

        /*print(new Loggable()) {
            public void print() {
                System.out.println("Test!!");
            }
        }*/

        // Loggable a = () -> {
        //     System.out.println("End!!!");
            
        // };
    }
}
