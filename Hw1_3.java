import java.util.Random;
import java.util.Scanner;

public class Hw1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        Random r = new Random();
        System.out.print("정수 몇개?");
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(100) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break ;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.print(arr[i - 1] + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }

        sc.close();
    }
}
