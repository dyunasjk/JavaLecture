package lecture_210409;

import java.util.*;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 1; i <= 10; i++) {
            // dq.add(i); // dq.addLast(i);
            dq.push(i); //dq.addFirst();
        }
        while (dq.size() > 0) {
            // Integer val = dq.poll(); FIFO
            // poll(), pollFirst()
            Integer val = dq.pollLast(); // LIFO
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
