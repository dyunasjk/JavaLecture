package lecture_210326;

import java.util.*;

public class utilTest2 {
    public static void main(String[] args) {
        Number n = Integer.valueOf(100);

        ArrayList<Integer> list = new ArrayList<Integer>(); // 이렇게는 안됨 number <-> Integer사이 부모자식 관계 X
        ArrayList<Double> list2 = new ArrayList<Double>(); // 이렇게는 안됨 number <-> Integer사이 부모자식 관계 X
        ArrayList<Student> list3 = new ArrayList<>(); // 이렇게는 안됨 number <-> Integer사이 부모자식 관계 X

        // ArrayList<Number> list = new ArrayList<Integer>(); // 이렇게는 안됨 number <-> Integer사이 부모자식 관계 X

        process1(list); // 실제론 안됨
        process2(list2); // 데이터 타입마다 만들어주어야하는가? NO, Use Generic and Wild Card

        process(list); // 와일드 카드를 이용하여 구현
        process(list2);

        // 제네릭을 쓰는 이유
        // 로직은 같고 내부적으로 사용하는 데이터의 타입만
        // 다른 경우에도, 하나의 클래스만 생성해서 사용할 수
        // 있도록 하기 위해...
        // 실제로 사용할 데이터 타입은
        // 객체 생성 시에 type parameter로 받아서 처리.
        // 그리고, 명시적인 type castinhg도 안해도 되도록 하기 위해...

    }    

    public static void process(ArrayList<? extends Number> list) {

    }

    public static void process1(ArrayList<Integer> list) {

    }

    public static void process2(ArrayList<Double> list) {

    }
}
