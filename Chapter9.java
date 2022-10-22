public class Chapter9 {
    public static void main(String[] args) {
        LCircle c = new LCircle(1.5);
        System.out.println("반지름 : " + c.getRad());
        System.out.println("넓 이 : " + c.getArea());

        c.setRad(3.4);
        System.out.println("반지름 : " + c.getRad());
        System.out.println("넓 이 : " + c.getArea());
        // c.rad = 6.5; -> private 이기 때문에 안됨

        ColdPatient suf = new ColdPatient();

        //suf.takeSinivelCap(new SiniveCap());
        //suf.takeSneezeCap(new SneezeCap());
        //suf.takeSnuffleCap(new SnuffleCap());
        suf.takeSinus(new SinusCap()); //-> 이게 좋은 캡슐화
    }
}

class LCircle {
    private double rad = 0;
    final double PI = 3.14;

    public LCircle(double r) {
        setRad(r);
    }

    public void setRad(double r) {
        if (r < 0) {
            rad = 0;
            return ;
        }
        rad = r;
    }

    public double getRad() {
        return rad;
    }
    public double getArea() {
        return (rad * rad) * PI;
    }
}

// 밑의 내용들은 절대 좋은 캡슐화가 아님.
// 첫 째로, 쓸데 없는 클래스를 너무 많이 생성했으며,
// 둘 째로, 제약 상황에 대해 유연한 처리를 하지 못한다.

/*
class SiniveCap { 
    void take() {
        System.out.println("콧물이 싹~ 납니다");
    }
}

class SneezeCap {
    void take() {
        System.out.println("재채기가 멎습니다.");
    }
}

class SnuffleCap {
    void take() {
        System.out.println("코가 뻥 뚫립니다!");
    }
}

class ColdPatient {
    void takeSinivelCap(SiniveCap cap) {
        cap.take();
    }
    void takeSneezeCap(SneezeCap cap) {
        cap.take();
    }
    void takeSnuffleCap(SnuffleCap cap) {
        cap.take();
    }
}
*/

// 따라서 다음과 같이 작성해야한다.

class SinusCap {
    void sniTake() {
        System.out.println("콧물이 싹 납니다~");
    }
    void sneTake() {
        System.out.println("재채기가 멎습니다 ~");
    }
    void snuTake() {
        System.out.println("코가 뻥 뚫립니다 ~");
    }
    void take() {
        sniTake();
        sneTake();
        snuTake();
    }
}

class ColdPatient {
    void takeSinus(SinusCap cap) {
        cap.take();
    }
}