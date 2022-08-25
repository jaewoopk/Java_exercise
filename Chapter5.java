import java.util.*;

public class Chapter5 {
    public static void main(String[] args) {
        int n = 24;

        n += 10;

        switch(n / 10) {
        case 1 :
            System.out.println("0이상 10미만의 수");    break;
        case 2 :
            System.out.println("10이상 20미만의 수");   break;
        case 3 :
            System.out.println("20이상 30미만의 수");   break;
        default :
            System.out.println("음수 혹은 30이상의 수");
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i * 10 + j) + (j * 10 + i) == 99)
                    System.out.println("a = " + i +" b = " + j);
            }
        }
    }
}
