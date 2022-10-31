package sejong;

class Test{
    int a;
    int b;

    @Override
    public int hashCode() { // 원래는 메모리 주소값인데 이렇게 지정해주면 객체 구분하기가 편해짐
        return a + 1000 * b;
    }

    @Override
    public boolean equals(Object in) {
        if (hashCode() == in.hashCode()) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class Hello {
    public static void main(String[] args) {
        System.out.println("Sejong Package!");
        gunja.Hello.main(null);

        Test c = new Test();
        Test d = new Test();

        c.a = 3;
        c.b = 2;
        d.a = 3;

        if (c.hashCode() == d.hashCode()) {
            System.out.println("it's equal!");
        }
        else {
            System.out.println("it's not equal");
        }

        if (c.equals(d)) {
            System.out.println("it's equal!");
        }
        else {
            System.out.println("it's not equal");
        }

        String str = "str" + c;
        System.out.println(str);
        System.out.println(c.toString());
        System.out.println(c.equals(str));
        System.out.println(str.hashCode());
        System.out.println(str.compareTo("strsejong.Test@7d"));
        System.out.println(str.compareTo("strsejong.Test@7d3"));
        System.out.println(str.compareTo("strsejong.Test@7d444"));

        Object arr[] = new Object[10];

        arr[0] = new String("sejong");
        arr[1] = c;
        arr[2] = 100; // int가 되는 이유 => int는 자동으로 Integer, float는 자동으로 Float등 형변환됨
                      // Wrapper class

        int aaa1 = 100;
        //Integer aaa2 = new Integer(aaa1); -> 이게 안됨
        Integer aaa3 = Integer.valueOf(aaa1);
        Integer aaa4 = aaa1; //-> 위에부터 int를 Integer로 == Boxing

        int aaa5 = aaa4.intValue(); // -> unBoxing
        int aaa6 = aaa4; // -> 이것도 unBoxing
        int aaa7 = Integer.parseInt("1000");
        final int MAX = Integer.MAX_VALUE;

        System.out.println(MAX);

        System.out.println(aaa5 + " " + aaa6 + " " + aaa7);
        // for (var e : arr) {
        //     System.out.println(e);
        // }
    }
}
