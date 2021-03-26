package lecture_210326;

import javax.swing.*;

// <> 안에는 생략 가능
public class MyBoxTest {
    public static void main(String[] args) {
        MyBox<String> box1 = new MyBox<>(); //이렇게 제네릭 클래스로 만들면 String 이외에는 전부 사용불가, 오픈박스에서 타입캐스팅도 필요 없어짐
        box1.setValue("홍길동");
        // box1.setValue(100);
        // box1.setValue(123.4);
        // box1.setValue(new JFrame()); // 이러면 되는데 제네릭을 굳이 쓰는 이유는?
        
        openBox(box1);
        // print(Integer.valueOf(100)); // new Integer(); 이런식이 아닌 다음과 같이 생성
    
        MyBox<Integer> box2 = new MyBox<>();
        box2.setValue(100);
    }

    private static void print(int val) {
        System.out.println(val);
    }

    private static void  openBox(MyBox<String> box) {
        // Object obj = box.getValue();
        String d = box.getValue();//auto Boxing이란 개념 주의, integer class : 래퍼클래스
        // type casting할 때 안에 들어가는 타입들 전부 알고 있어야함. 주의 안하면 런타임 에러가 함께하는 즐거운 자바시간이 될수도 있음
        System.out.println(d);
    }

}
