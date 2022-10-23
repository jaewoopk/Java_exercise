import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

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

public class Hello {
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();

        cities.add("seoul");
        cities.add("tokyo");
        cities.add("new york");
        for (String str : cities) {
            System.out.println(str);
        }
        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            if (it.next().equals("tokyo")) {
                it.remove();
            }
        }
        System.out.println("-------");
        for (String str : cities) {
            System.out.println(str);
        }

        // B b = new B(10);
        // Counting a = new Counting();
        // Counting b = new Counting();
        // System.out.println( " " +Counting.n);
        // Counting c = new Counting();
        // System.out.println(Counting.n);
        // Node a = new Node(10, null);
        // Node b = new Node(20, a);
        // Node c = new Node(30, b);
        // Node cur = a;
        // while (cur != null) {
        //     System.out.println(cur.data);
        //     cur = cur.next;
        // }
        // Child a = new Child(10);
        // Scanner sc = new Scanner(System.in);
        // float f;

        // String String = "sejong";
        // System.out.println(String);
        // f = sc.nextFloat();
        // System.out.print("f="+f);

        // int a = 5;
        // int b = a << 2;
        // int c = a >> 2;
        // int d = a & 0b0100;

        // System.out.println("a = " + a + ", b = " + b);
        // System.out.println("c = " + c + ", d = " + d);

        // int [][] arr = new int[4][];

        // arr[0] = new int[1];
        // arr[1] = new int[2];
        // arr[2] = new int[3];
        // arr[3] = new int[4];
    }
}
