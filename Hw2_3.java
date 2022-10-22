import java.util.ArrayList;
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

    Line() {
        super();
    }
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Line");
    }

}

class Rect extends Shape{
    
    Rect() {
        super();
    }
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Rect");
    }

}

class Circle extends Shape{

    Circle() {
        super();
    }
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Circle");
    }

}

class GraphicEditor{
    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Line(1), Rect(2), Circle(3)>>");

        int chooseNum = sc.nextInt();
        switch(chooseNum) {
        case 1 :
            
            break ;
        case 2 :
            
            break ;
        case 3 :
            
            break ;
        }
    }

    public void delete() {

    }

    public void showAll() {
      
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
