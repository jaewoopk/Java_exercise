class MyString {
    protected String str;
    MyString() {
        str = "N/A";
    };
    MyString(String in) {
        str = in;
    }
    void print() {
        System.out.println("[STR] = " + str);
    }
}


class MyColorString extends MyString{
    public String color;
    MyColorString() {
        super("hello");
        color = "black";
    }
    MyColorString(String in, String c) {
        super(in);
        color = c;
    }
    void colorPrint() {
        System.out.println("[ClrSTR] " + str + ", " + "color = " + color);
    };
}

class MySimplestClass {

}

public class InheritancePractice {
    static void function(Object in) {
        if (in instanceof MyColorString) {
            System.out.println(in.getClass());
        }
    }
    public static void main(String[] args) {
        // StaticTest a = new StaticTest();
        // a.func1();
        // StaticTest.func1();
        int a;
        a = 20;
        System.out.println(a);
        MyColorString abc = new MyColorString("Sejong", "Magenta");
        //abc.str = "Sejong univ.";
        //abc.color = "yellow";
        abc.colorPrint();
        abc.print();

        MyString b = abc;
        System.out.println(b.str.length());

        MySimplestClass simple = new MySimplestClass();
        System.out.println(simple.hashCode());

        MyString c = abc;
        function(abc);

        MyColorString d = (MyColorString)c; // 부모인척하는 자식일 때

    }
}



// class StaticTest {
//     static int value;
//     private StaticTest(){};
//     static void func1() {
//         int a;
//         a = 10;
//         System.out.println(a);
//     };
//     static void func2() {};
//     static void func3() {};
//     static void func4() {};
// }
