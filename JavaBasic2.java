import java.util.Scanner;

public class JavaBasic2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 40;
        int c = 20;
        int d = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("d = " + d);

        int count = 0;
        while(count < 10) {
            System.out.println("while count = " + count);
            count++;
        }
        for (count = 0; count < 10; count++) {
            System.out.println("for count = " + count);
        }
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String str = sc.nextLine();
        str = sc.nextLine();
        
        System.out.println(t + " " + str);

        for (int i = 0, j = 10; i < 10; i++, j += 2) {
            System.out.println("i = " + i + "," + "j = " + j);
        }

        int[] arr = new int[10];
        int[] brr;
        brr = arr;
        // brr을 포인터처럼 쓸 수 있는지, brr은 힙에서 할당되는지 (o) brr은 힙에서 할당된 arr의 주소값을 똑같이 참조하는 것
        for (int i = 0; i < 10; i++) {
            arr[i] = i * 2;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("brr["+i+"]= "+ brr[i]);
        }
        
        for (int value : brr) { // for - each 문에서 배열의 크기가 달라지면 위험
            System.out.println("brr["+ value / 2 +"]= " + value);
        }
        sc.close();
    }
}
