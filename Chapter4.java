public class Chapter4 {
    public static void main(String[] args) {
        int num1 = 10, num2 = 20, num3 = 30;

        num1 = num2 = num3;
        System.out.println(num1 + "" + num2 + "" + num3);
        System.out.println(((25 * 5) + (36 - 4) - 72) / 5);
        
        int tmp = 3 + 6;
        System.out.println(tmp + " " + (tmp + 9) + " " + (tmp + 9 + 12));

        tmp = 15678;
        System.out.println((tmp >> 2) & 1);
        System.out.println((tmp >> 4) & 1);
        System.out.println((tmp >> 6) & 1);
        System.out.println((tmp >> 7) & 1);
        System.out.println((tmp >> 8) & 1);

        System.out.println(8192 + 4096 + 2048 + 1024 + 256 + 32 + 16 + 8 + 4 + 2);
        // byte t = 11110100111110;
    }
}
