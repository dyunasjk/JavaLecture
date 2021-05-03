package lecture_210430;

import java.util.*;
import java.util.Map.Entry;

public class NumberBooks {
    public static void main(String[] args) {
        NumberBooks();
    }

    private static void NumberBooks() {
        
        /*
        분반별 전화전호부 구현
        맵 타입의 폰북에 A반 전화번호부, B반 전화번호부를 저장
        A반, B반 전화번호부도 맵 타입
        A반 전화번호부에는 A반 학생들의 전화번호가 <이름, 전화번호>의 쌍으로
        B반 전화번호부에는 B반 학생들의 전화번호가 <이름, 전화번호>의 쌍으로 저장됨
        */ 
        //  A반 전화번호부 <이름, 전화번호>의 쌍으로 저장되니
        Map<String, String> aClass = new TreeMap<>();
        aClass.put("박동현", "010-1111-1111");
        aClass.put("김정세", "010-2222-2222");
        aClass.put("장재현", "010-3333-3333");

        Map<String, String> bClass = new TreeMap<>();
        bClass.put("구나현", "010-4444-4444");
        bClass.put("김새별", "010-5555-5555");
        bClass.put("한규민", "010-6666-6666");

        //<"A반", aClass>, <"B반", bClass>
        Map<String, Map<String, String>> phoneBook = new TreeMap<>();
        
        phoneBook.put("A반", aClass);
        phoneBook.put("B반", bClass);

        /* Set<Map.Entry<String, Map<String, String>>> entrySet = phoneBook.entrySet();

        Iterator<Map.Entry<String, Map<String,String>>> iter1 = entrySet.iterator();

        while(iter1.hasNext()) {
            Map.Entry<String, Map<String, String>> entry = iter1.next();
            System.out.println(entry.getKey()); // A반 또는 B반
            Map<String, String> pb = entry.getValue();
            
            Set<Map.Entry<String,String>> phones = pb.entrySet();
            Iterator<Map.Entry<String,String>> iter2 = phones.iterator();
            while(iter2.hasNext()) {
                Map.Entry<String, String> phone = iter2.next();
                System.out.println(phone.getKey() + ": " + phone.getValue());
            }
            System.out.println("\n");
        } */
        // 위와 동일한 기능을 맵의 keySet을 이용해 구현하시오


        
        // Scanner input = new Scanner(System.in);
        // while(true) {
        //     System.out.println("어느 반 입니까?(A반 or B반), 종료는 Q");
        //     String ban = input.nextLine();
        //     if(ban.equalsIgnoreCase("Q")) break;
        //     Map<String, String> classPB = phoneBook.get(ban);
        //     if (classPB == null) {
        //         System.out.println("그런 반은 없어요");
        //         continue;
        //     }
        //     System.out.println("누구?");
        //     String who = input.nextLine();
        //     String phone = classPB.get(who);
        //     if (who == null) {
        //         System.out.println("그런 학생은 없어요");
        //         continue;
        //     }
        //     System.out.println(ban + "의" + who + ": " + phone);
        // }
        // input.close();
        // System.out.println("프로그램을 종료합니다");
    }
}
