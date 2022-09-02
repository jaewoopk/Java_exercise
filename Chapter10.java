import static java.lang.Math.*;

class Accumulator {
    static int sum = 0;

    static void add(int i) {
        sum += i;
    }
    
    static void showResult() {
        System.out.println("sum = " + sum);
    }
}

public class Chapter10 {
    public static void main(String[] args) {
        System.out.println(abs(1));
        System.out.println(min(10, -5));
        System.out.println(PI);
        for (int i = 0 ; i < 10; i++) {
            Accumulator.add(i);
        }
        Accumulator.showResult();
    }
}
