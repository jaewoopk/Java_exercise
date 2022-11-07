import java.util.Vector;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GenericPractice {
    // Vector는 배열과 비슷하지만 훨 더 많은 기능을 제공하기때문에 매우 편리하다.
    // Vector와 ArrayList의 차이
    // Vector는 병렬처리에 안전하다. ArrayList는 병렬처리에 안전하지 않다.

    public static void main(String[] args) {


        // iterator : 반복자 (LinkedList에 이게 있어야 제대로 쓰이는 것)
        // 따라서 LinkedList를 만들면 for문을 쓰지 않음, 대신 for each


        LinkedList<String> arr = new LinkedList<>(); // Object

        arr.add("Sejong"); // String
        arr.add("Software"); // Integer
        arr.add("department"); // Double
        arr.add(1, "university");
        arr.add("AI Centor");
        arr.add("B101");
        arr.remove(2);
        
        Collections.sort(arr);
        
        //System.out.println(arr.capacity());
        System.out.println(arr.get(0));
       
        /*
        int i = 0;
        for (Object e : arr) {
            if (e.equals("department")) {
                arr.remove(i);
            }
            else {
                System.out.println(e);
                i++;
            }
        } */ // 이것도 불가능 (for each는 read only다) (remove를 사용할 때)


        // 이게 베스트
        //Iterator<String> it = arr.iterator(); //밑에랑 같음
        var it = arr.iterator();
        while(it.hasNext() == true) {
            String str = it.next();
            if (str.equals("department") == true) {
                it.remove();
            }
            else
                System.out.println(str);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(10);
        q.add(55);
        q.add(3);
        q.add(5);

        for(var e : q) {
            System.out.println(e);
        }
    }
}
