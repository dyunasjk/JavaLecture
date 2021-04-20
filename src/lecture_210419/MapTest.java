package lecture_210419;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        /* Map 인터페이스이고 요놈을 구현한 구현 클래스가 HashMap, TreeMap, LinkedHashMap 3개가 있다.
        그래서 Map타입의 변수는 위의 3개 타입의 객체를 수용할 수 있다.
        Map은 값을 <key, value> 쌍으로 저장한다.
        Map은 Generic이다.
        클래스, 메소드 내부에서 사용할 데이터 타입이 정해져 있지 않고
        실제 그 클래스 객체를 만들거나 메소드를 호출할 때 사용할 데이터 타입을
        파라미터로 받아서 처리하는 것.
        문자열 타입의 학번을 키로, Student 객체를 값으로 Map에 저장*/
        Map<String, Student> st = new HashMap<String, Student>();

        // Map에 원소(<key,value>로 구성된 entry)를 넣을 때는 put 메소드를 사용
        // put 메소드를 사용 : put 메소드는 원소 삽입과 변경에 모두 사용됨
        // Map에서 원소(엔트리)를 읽을때는 get(key)메소드를 사용
        // 이미 존재하는 키값으로 put하면 기존 원소를 replace하게됨
        st.put("20090001", new Student(20090001, "구준표"));
        st.put("20090002", new Student(20090002, "금잔디"));
        st.put("20090003", new Student(20090003, "윤지후"));
        st.put("20090004", new Student(20090003, "금태양"));

        // 원소값을 읽을 때는 키 값을 줘야한다
        // map 객체에게 가진 key값을 전부 다 반환하라고 요청 가능
        Set<String> keySet = st.keySet();
        // keySet에 있는 각 원소를 통해서 map에게 값을 요구하면 된다.
        // 왜냐하면 그 원소가 map에 저장된 값이 key이기 때문

        Iterator<String> iter = keySet.iterator();
        while(iter.hasNext()) {
            Student stud;
            String key = iter.next();
            stud = st.get(key);
            System.out.println(stud);
        }

        // entrySet(): <key, value> pair의 셋
        Set<Map.Entry<String,Student>> entrySet = st.entrySet();
        // Map 객체에게 entrySet 메소드를 호출하면 Map.Entry 타입 객체를 원소로 가지는 set 객체가 반환된다.

        Set<String> set1;
        Set<Integer> set2;
        Set<Student> set3;
        // set에 들어갈 원소가 map.entry 객체 ,근데 map.entry 객체가 generic이다. map.entry<string, student>

        Iterator<Map.Entry<String,Student>> iter2 = entrySet.iterator();
        while(iter2.hasNext()) {
            Map.Entry<String, Student> entry = iter2.next();
            String mykey = entry.getKey();
            Student mystd = entry.getValue();
            System.out.println("Key: " + mykey + ", value: " + mystd);
        }

        for (Map.Entry<String,Student> entry: st.entrySet()) {
            String mykey = entry.getKey();
            Student mystd = entry.getValue();
            System.out.println("Key: " + mykey + ", value: " + mystd);
        }

        System.out.println(st);

        st.remove("20090002");

        st.put("20090003", new Student(20090003, "소이정"));

        for(Map.Entry<String, Student> s: st.entrySet()) {
            String key = s.getKey();
            Student value = s.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }
    }
}
