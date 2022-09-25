import java.util.Random;

public class Hw1_4 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        Random r = new Random();
        
        for (int i = 0; i < 10; i++) {
            int a, b;
            a = r.nextInt(4);
            b = r.nextInt(4);
            if (arr[a][b] != 0) {
                i--;
                continue;
            }
            arr[a][b] = r.nextInt(10) + 1;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
