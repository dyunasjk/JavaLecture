package lecture_210409;

import java.util.*;

public class Que {
    public static void main(String[] args) {
        testPriorityQueue();
    }    
    private static void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 10; i > 0; i--) queue.offer(i);
        System.out.println(queue);

        for (Integer n : queue) System.out.print(n + " ");

        System.out.println();
        int length = queue.size();
        for (int i = 0; i < length; i++) {
            System.out.println((i+1)+ "번째 원소: " + queue.poll());
        }
        System.out.println();
    }
}
