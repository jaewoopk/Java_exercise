import java.util.Scanner;

public class Hw1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1, x2, y1, y2, r1, r2;
        double result;
        System.out.print("첫번째 원의 중심과 반지름 입력>>");
        x1 = sc.nextDouble();
        y1 = sc.nextDouble();
        r1 = sc.nextDouble();
        System.out.print("두번째 원의 중심과 반지름 입력>>");
        x2 = sc.nextDouble();
        y2 = sc.nextDouble();
        r2 = sc.nextDouble();

        result = Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
        
        if (result <= (double)(r1 + r2)) {
            System.out.println("두 원은 서로 겹친다.");
        }
        else {
            System.out.println("두 원은 서로 겹치지 않는다.");
        }
        sc.close();
    }
}
