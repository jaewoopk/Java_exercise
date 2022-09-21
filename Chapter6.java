public class Chapter6 {
    public static void main(String[] args) {
        int a = 10;
        int b = 52;
        int n = 878;

        System.out.println(abs(a, b));
        intToByte(n);
    }

    public static int abs(int a, int b) {
        return Math.abs(a - b);
    }

    public static void intToByte(int n) {
        if (n < 1)
            return ;
        intToByte(n / 2);
        System.out.print(n % 2);
    }
}
