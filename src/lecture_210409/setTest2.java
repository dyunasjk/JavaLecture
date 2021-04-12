package lecture_210409;

import java.util.*;

public class setTest2 {
    
    public static void main(String[] args) {
        // test1();
        testPriorityQueue();
    }
    private static void test1() {
        /*
        합집합 : addAll()
        교집합 : retainAll() 
        차집합 : removeAll()
        */
        /*
            set1: {1, 3, 4, 5, 7, 8, 10}
            set2: {2, 4, 10}
            set1 U set2 = {1, 2, 3, 4, 5, 7, 8, 10}
            set1 interection set2 
        */
        Integer[] arr1 = {1, 3, 4, 5, 7, 9, 10};
        List<Integer> list1 = Arrays.asList(arr1);
        Set<Integer> set1 = new HashSet<>(list1);

        Integer[] arr2 = {2, 4, 6, 8, 10};
        List<Integer> list2 = Arrays.asList(arr2);
        Set<Integer> set2 = new HashSet<>(list2);

        // set1.addAll(set2); // 원본데이터가 변경된다
        // 원본데이터 유지를 위해 변수 새로 만듬
        // 합집합 
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("합집합: " + unionSet);

        // 교집합
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("교집합: " + intersectionSet);

        // 차집합
        Set<Integer> diffSet = new HashSet<>(set1);
        diffSet.removeAll(set2);
        System.out.println("차집합: " + diffSet);
        
        boolean flag = set1.containsAll(set2);
        if (flag) {
            System.out.printf("집합 %s는 집합 %s의 모든 원소를 포함합니다", set1, set2);
        } else {
            System.out.printf("집합 %s는 집합 %s의 모든 원소를 포함하지 않습니다", set1, set2);
        }
    }

    private static void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(new MyComparator());
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
class MyComparator implements Comparator<Integer> {

    
    @Override
    public int compare(Integer o1, Integer o2) {
        return (o1.intValue() - o2.intValue())*-1;
    }
    
}
