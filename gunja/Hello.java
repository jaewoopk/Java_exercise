package gunja;
import java.util.Scanner;

public class Hello {
    static int sum(int [] arr) {
        int out = 0;
        for (int a : arr) {
            out += a;
        }
        return out;
    }
    public static void main(String[] args) {

        int [] arr = new int [10];

        for (int i = 0; i < 10; i ++) {
            arr[i] = i;
        }
        
        System.out.println(sum(arr));

        int a = 14;
        int b = 15;
        int c = 12;
        System.out.println((a > b) ? ((a > c) ? a : c) : (b > c ? b : c));
        // Scanner sc = new Scanner(System.in);
        
        // sc.close();

        // float a = 10.0f;
        // int b = (int)(a / 3);
        // byte c = (byte)b;
        // boolean d = (c > 3)? true : false;

        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        // System.out.println(d);
    }
}

// class Parent {
//     Parent (int n) {
//         System.out.println("parent : " + n);
//     }
// }

// class Child extends Parent {
//     Child (int n) {
//         super(n);
//         System.out.println("child : " + n * 2);
//     }
// }

// class Node {
//     int data;
//     Node next;
//     Node(int in, Node prev) {
//         data = in;
//         next = null;
//         if (prev != null) prev.next = this;
//     }
// }

// class Counting {
//     static int n;
//     Counting() {
//         n++;
//     }
// }

// class A {
//     A() {System.out.println("A");}
//     A(int x) {
//         System.out.println("A :" + x);
//     }
// }

// class B extends A{
//     B() {super(100);}
//     B(int x) {
//         System.out.println("B :" + x);
//     }
// }

// public class Hello {
//     public static void main(String[] args) {

//         // LinkedList<String> cities = new LinkedList<>();
//         // cities.add("seoul");
//         // cities.add("tokyo");
//         // cities.add("new york");
//         // for (String str : cities) {
//         //     System.out.println(str);
//         // }
//         // Iterator<String> it = cities.iterator();
//         // while (it.hasNext()) {
//         //     if (it.next().equals("tokyo")) {
//         //         it.remove();
//         //     }
//         // }
//         // System.out.println("-------");
//         // for (String str : cities) {
//         //     System.out.println(str);
//         // }

//         // B b = new B(10);
//         // Counting a = new Counting();
//         // Counting b = new Counting();
//         // System.out.println( " " +Counting.n);
//         // Counting c = new Counting();
//         // System.out.println(Counting.n);
//         // Node a = new Node(10, null);
//         // Node b = new Node(20, a);
//         // Node c = new Node(30, b);
//         // Node cur = a;
//         // while (cur != null) {
//         //     System.out.println(cur.data);
//         //     cur = cur.next;
//         // }
//         // Child a = new Child(10);
//         // Scanner sc = new Scanner(System.in);
//         // float f;

//         // String String = "sejong";
//         // System.out.println(String);
//         // f = sc.nextFloat();
//         // System.out.print("f="+f);

//         // int a = 5;
//         // int b = a << 2;
//         // int c = a >> 2;
//         // int d = a & 0b0100;

//         // System.out.println("a = " + a + ", b = " + b);
//         // System.out.println("c = " + c + ", d = " + d);

//         // int [][] arr = new int[4][];

//         // arr[0] = new int[1];
//         // arr[1] = new int[2];
//         // arr[2] = new int[3];
//         // arr[3] = new int[4];
//     }
// }
