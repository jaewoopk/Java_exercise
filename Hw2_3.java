import java.util.Scanner;

abstract class Shape {
    private Shape next;
    
    public Shape() {
        next = null;
    }
    public void setNext(Shape obj) {
        next = obj;
    }
    public Shape getNext() {
        return next;
    }
    public abstract void draw();
}

class Line extends Shape{

    // public Line() {
    // }
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Line");
    }

}

class Rect extends Shape{
    
    // public Rect() {
    // }
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Rect");
    }

}

class Circle extends Shape{

    // public Circle() {
    // }
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Circle");
    }

}

class GraphicEditor{
    Shape head, last;
    int size;

    GraphicEditor() {
        head = null;
        last = null;
        size = 0;
    }

    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Line(1), Rect(2), Circle(3)>>");

        int chooseNum = sc.nextInt();
        switch(chooseNum) {
        case 1 :
            if (head == null) {
                Shape node;
                node = (Shape)(new Line());
                head = node;
                last = node;
            }
            else {
                Shape node;
                node = (Shape)(new Line());
                last.setNext(node);
                last = node;
            }
            size++;
            break ;
        case 2 :
            if (head == null) {
                Shape node;
                node = (Shape)(new Rect());
                head = node;
                last = node;
            }
            else {
                Shape node;
                node = (Shape)(new Rect());
                last.setNext(node);
                last = node;
            }
            size++;
            break ;
        case 3 :
            if (head == null) {
                Shape node;
                node = (Shape)(new Circle());
                head = node;
                last = node;
            }
            else {
                Shape node;
                node = (Shape)(new Circle());
                last.setNext(node);
                last = node;
            }
            size++;
            break ;
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 도형의 위치>>");
        int select = sc.nextInt();

        if (select <= 0 || select > size || size <= 0) {
            System.out.println("삭제할 수 없습니다.");
            return ;
        }

        Shape node = head;
        if (select == 1) {
            head = node.getNext();
            size--;
            return ;
        }
        for (int i = 0; i < select - 2; i++) {
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
        size--;
    }

    public void showAll() {
        Shape node = head;
        for (int i = 0; i < size; i++) {
            node.draw();
            node = node.getNext();
        }
    }

    public boolean endBeauty() {
        return false;
    }

    public boolean chooseSelect() {
        boolean checking = true;
        Scanner sc = new Scanner(System.in);

        System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4)>>");
        int num = sc.nextInt();
        switch(num) {
        case 1 :
            insert();
            break ;
        case 2 :
            delete();
            break ;
        case 3 :
            showAll();
            break ;
        case 4 :
            checking = endBeauty();
            break ;
        }

        return checking;
    }

}
public class Hw2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean checker = true;

        System.out.println("그래픽 에디터 beauty을 실행합니다.");
        GraphicEditor gc = new GraphicEditor();

        while (checker) {
            checker = gc.chooseSelect();
        }
        System.out.println("beauty을 종료합니다.");
        sc.close();
    }
}
