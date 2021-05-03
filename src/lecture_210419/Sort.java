package lecture_210419;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        test1();
    }
    private static void test1() {
        ArrayList<Student> list = new ArrayList<>();
        Random random = new Random();
        for (int i =0; i< 10; i++) {
            list.add(new Student("이름"+i, random.nextInt(100)+1));
        }
        System.out.println(list);
        
        Collections.sort(list);
        System.out.println("after sort...");
        System.out.println(list);
    }

    private void selectionSort(List<Student> list) {
        /*
        selection sort
        1. list의 0번 부터 마지막 인덱스의 원소까지 다음을 반복
            현재 인덱스를 i 라 하면
            min = i;

            list의 i+1이 인덱스부터 마지막 인덱스의 원소까지 다음을 반복
                중첩 반복문의 현재 인덱스를 j라 하자
                if (min 인덱스의 원소 값보다 j인덱스의 원소값이 작으면)
                min =j;
        */
        for (int i = 0; i < list.size(); i++) {
            int min = i;
            for (int j = 0; j< list.size(); j++) {
                if (list.get(min).compareTo(list.get(j)) > 0) {
                    min = j;
                }
            }
            // min변수가 가리키는 위치의 원소가 지금 현재 남아있는 것 중에서는 제일 작은 놈
            // j가 i 위치에 와야한다.
            // swap(list.get(min), list.get(i));
            // swap(list, min, i)
        }
    }

    private void swap(List<Student> list, int i, int j) { 
        Student tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}



class Student implements Comparable<Student> {
    private String name;
    private int grade;

    @Override
    public String toString() {
        return "[name: " + name + ", grade : " + grade + "]";
    }
    public Student(String name, int grade) {
    super();
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return this.grade - o.grade;
    }
}