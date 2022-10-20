class MyPositiveException extends Exception {
    MyPositiveException(String str) {
        super(str);
    }
}

class MyTooBigException extends Exception {
    MyTooBigException(String str) {
        super(str);
    }
}

class TestClass {
    int x;
    int y;
}

public class ExecptionHandling {
    
    static void func(int a) throws MyPositiveException, MyTooBigException{
        if (a < 0) throw new MyPositiveException("a should be positive!"); // 친절하게 코드하는 것임
        if (a > 100) throw new MyTooBigException("value is over 100");
    }
    static void func2(int a) throws MyPositiveException, MyTooBigException{
        func(a);
    }

    public float slope(int x1, int y1, int x2, int y2) {
        return (0.0f);
    }
    public static void main(String[] args) {
        try {
            //func(-10);
            func2(10000);
        }
        catch (MyPositiveException e){
            System.out.println(e.getMessage());
        }
        catch (MyTooBigException e) {
            System.out.println(e.getMessage());
        }

        int x = 20;
        int y = 0;
        int z;
        try {
            //            z = x/y;
            
            int [] a = new int[10];
            a[10] = 100;
            
        }
        catch (ArithmeticException e){
        z = 100000000;
    }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oppsssssss");
        }
        //System.out.println(z);
        // int [] a = new int [10];
        // a[10] = 100;

        // TestClass [] arr = new TestClass[10];
        // for (int i = 0; i < 10; i++) {
        //     arr[i] = new TestClass();
        // }

        // arr[0].y = 10;
    }
}
