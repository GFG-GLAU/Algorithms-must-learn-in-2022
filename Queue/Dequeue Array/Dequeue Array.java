import java.util.*;
public class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.pollLast();
        dq.add(100);
        dq.add(45);
        dq.add(20);
        dq.addFirst(1);
        dq.addLast(99);
        while (!dq.isEmpty()){
            System.out.println(dq.peekLast());
            dq.pollLast();
        }
        //dq.removeFirst();

    }
