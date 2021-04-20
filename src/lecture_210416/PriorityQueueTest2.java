package lecture_210416;

import java.util.*;

public class PriorityQueueTest2 {
    public static void main(String[] args) {
        // test1();
        test2();

        // MyInterface mi = (n1, n2) -> System.out.println(n1+n2);
    }

    private static void test1() {
        Queue<Integer> q = new PriorityQueue<>();

        // 무작위로 1~100 사이의 10개의 정수를 넣기
        // queue 안의 내용을 출력 해보고
        // queue 안의 원소를 하나씩 순서대로 빼보자
        Random random = new Random();

        for (int i= 0; i< 10; i++) {
            int val = random.nextInt(100)+1;
            q.offer(val);
        }

        System.out.println(q);
        while(q.size()>0) {
            System.out.println(q.poll());
        }
    }

    private static void test2() {
        /*
        정렬을 하려면 Comparable 객체이어야하는데 안되서 컴파일 에러발생
        비교를 하는 방법을 따로 명시해줘야 에러발생 X
        => 우선순위 쿠에 들어갈 원소를 정렬하는 방법은 2가지
        1. 그 원소의 클래스 Comparable 인터페이스를 구현
        2. 우선순위 큐에게 그 우너소를 비교하는 방법을 따로 알려주는 것
        => Comparator 인터페이스를 구현하는 것이다. (우선순위가 훨씬 높다)
        참고로, 원소가 Comparable 인터페이스를 구현한 객치에고 우선순위
        큐에서 원소를 비교하는 방법도 따로 알려주면 도대체 어떤 순서로 정렬
        하라는 건가?
        */
        // Queue<MyTask> q = new PriorityQueue<>();
        // MyTaskComparator comp = new MyTaskComparator();
        // Queue<MyTask> q = new PriorityQueue<>(comp);
    
        // q.add(new MyTask(5,"작업1"));
        // q.add(new MyTask(1,"작업2"));
        // q.add(new MyTask(7,"작업3"));
        // q.add(new MyTask(8,"작업4"));
        // q.add(new MyTask(4,"작업5"));

        // while(q.size() > 0) {
        //     MyTask task = q.poll();
        //     System.out.println(task);
        // }

        // 람다식으로 표현
        MyTaskComparator comp = new MyTaskComparator();
        Queue<MyTask> q = new PriorityQueue<>(
            (o1, o2) -> o2.priority - o1.priority
        );
    }
}

class MyTask implements Comparable<MyTask> {
    // 1번 방법: Comparable<MyTask>를 해줌으로써 비교가능 구현
    int priority;
    String desc;

    public MyTask(int priority, String desc) {
        this.priority = priority;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "[priority:" + priority + ", desc: " + desc + "]";
    }

    @Override
    public int compareTo(MyTask o) {
        // object type인 이유: compartTo가 제네릭이기 때문
        // 내가 크면 양수, 같으면 0, 내가 작으면 음수를 반환하면 된다.
        return this.priority - o.priority; // 오름차순 정렬
    }
}
// 2번 방법 다른 외부 클래스를 구현
class MyTaskComparator implements Comparator<MyTask> {

    @Override
    public int compare(MyTask o1, MyTask o2) {
        // o1 크면 양수, 같으면 0, o1 작으면 음수를 반환
        // return o1.desc.compareTo(o2.desc); <=desc 값을 기준으로 정렬하고 싶다면
        return (-1) * (o1.priority - o2.priority); //내림차순 정렬
    }
}