import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

// class Employee implements Comparable<Employee>{
//     String name;
//     Employee(String in) {name = in;}
//     @Override
//     public int compareTo(Employee o) {
//         // TODO Auto-generated method stub
//         if (this.name.compareTo(o.name) > 0) {
//             return 1;
//         }
//         else if (this.name.compareTo(o.name) < 0)
//             return -1;
//         return 0;
//     }

    
// }

public class ForExam {
//     static void func(Object o) {
//         if (o instanceof Integer) {
//             System.out.println("정수입력: " + o);
//         }
//         if (o instanceof String) {
//             System.out.println("문자열입력: " + o);
//         }
//     }
    public static void main(String[] args) throws Exception{
        ForExam test = new ForExam();
        test.throwException(13);
        // func(10);
        // func("Sejong");
        // ArrayList<String> arr = new ArrayList<String>();

        // arr.add("a");
        // arr.add("b");
        // arr.add("c");

        // for (Iterator<String> str = arr.iterator(); str.hasNext();) {
        //     if (str.next().equals("a")) {
        //         str.remove();
        //     }
        // }
        // for (String str : arr) {
        //     System.out.println(str);
        // }
        // int a = 3;
        // int b = 4;
        // int c = 5;
        // System.out.println("a + b"+(a+b*c));
        
        // String s1 = "Sejong";
        // String s2 = "Sejong";
        // String s3 = new String("Sejong");

        // System.out.println("s1 == s2"+(s1==s2));
        // System.out.println("s1 == s3"+(s1==s3));

        // Employee [] arr = new Employee[3];

        // arr[0] = new Employee("Kim");
        // arr[1] = new Employee("Park");
        // arr[2] = new Employee("Lee");

        // Arrays.sort(arr);
        // for (Employee e : arr) {
        //     System.out.println(e.name);
        // }

    }
    public void throwException(int num) throws Exception {
        if (num > 12) {
            throw new Exception("Number is over than 12");
        }
        System.out.println("number is = " + num);
    }
}
