import java.util.Scanner;

public class Hw1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ch1, ch2, ch3;
        double a, b, result;
        System.out.print("연산>>");
        ch1 = sc.next();
        ch2 = sc.next();
        ch3 = sc.next();
        a = Double.parseDouble(ch1);
        b = Double.parseDouble(ch3);
        sc.close();
        if (ch2.equals("/") && b == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return ;
        }
        switch(ch2) {
        case "+" :
            result = a + b;
            break;
        case "-" :
            result = a - b;
            break;
        case "*" :
            result = a * b;
            break;
        default :
            result = a / b;
        }
        System.out.println(ch1 + ch2 + ch3 + "의 계산 결과는 " + result);
    }    
}
