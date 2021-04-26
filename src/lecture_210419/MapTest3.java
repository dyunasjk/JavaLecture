package lecture_210419;

import java.util.HashMap;
import java.util.StringTokenizer;

import java.util.*;

public class MapTest3 {
    public static void main(String[] args) {
        test();
    }
    private static void test() {
        String sample = "What a radical idea, the great gift that our Founders gave to us. " +
        "The freedom to chase our individual dreams through our sweat, and toil, " +
        "and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
        "For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
        "It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
        "It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
        "It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
        "It’s why GIs gave their lives at Omaha Beach and Iwo Jima; " +
        "Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";

        /*  한 문자열을 각 단어별로 쪼개기
            StringTokenizer(), split
        */

        StringTokenizer st = new StringTokenizer(sample, ".,- ;"); // delimeter를 공백, 마침표, 쉼표, 세미콜론, 대쉬
        // st가 위의 구분자로 분리된 토큰들을 품고있다.
        // 하나씩 빼먹어보자
        // 있는지 물어보고 있으면 달라고 한다
        // Map이라는 자료구조를 이용해서, 각 단어가 몇 번 출현했는지 그 빈도를 저장하고자 한다.
        // Map은 <key, value>의 쌍으로 저장한다. key는 단어로, value를 빈도로
        // Map은 generic인터페이스. 이 의미는 객체 생성할때 내부에서 사용할 데이터 타입을 파라미터로 명시
        // Map<> map = new HashMap<>();
        // HashMap<> map = new HashMap<>();
        // Object o = new Student();

        Map<String, Integer>map = new HashMap<>();
        // Map<String, Integer>map = new TreeMap<>(Comparator<String>());

        // map에 <key, value> 쌍으로 저장. 이때 사용하는 메소드는 put
        // put 메소드를 통해 <key,value>의 쌍으로 맵에 저장
        // 이전에 이미 추가된 것과 동일한  key가 명시되면, 그 키와 연결된 값이 갱신
        
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            System.out.println(str);
            Integer value = map.get(str);
            // 맵에 넣기 전에, 지금 삽입하고자 하는 키와 연결된 값이 이미 있는지 체크
            // map.get(key)는 그 키와 연결된 값이 있으면 그 값을 반환하고 없으면 null을 반환
            // map.put(str, (value == null?1:value+1));
            if (value==null) { // 처음 나온 단어
                map.put(str,1);
            } else { // 이미 이전에 나와서 맵에 추가된 단어
                map.put(str, value+1); // 그 단어와 연결되어 있던 value 값이 갱신되는 것
            }
        }
        // 맵에게 맵이 가진 키들을 전부 달라 요청을 하고
        // 그렇게 ㅣ전달받은 키들에 대해서 값을 하나씩 찍어보면됨
        System.out.println(map.size() + "개의 단어가 있습니다.");
        System.out.println(map);
        
        Set<String> keySet = map.keySet();
        // set 에 있는 원소를 하나씩 빼볼수 있어야하는데
        // 1. Iterator 2. for each 문 등

        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Integer value = map.get(key);
            System.out.println(key + ": " + value);
        }
        ArrayList<Map.Entry<String, Integer>> eList = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entryset = map.entrySet(); // Map.Entry<String, Integer> 객체를 원소로 가지는 set을 반환
        Iterator<Map.Entry<String, Integer>> eIter = entryset.iterator();
        while (eIter.hasNext()) {
            Map.Entry<String, Integer> entry = eIter.next();
            System.out.println(entry.getKey() +": " + entry.getValue());
            eList.add(entry);
        }

        // Collections.sort(eList, new Comparator<Map.Entry<String, Integer>>(){
        //     @Override
        //     public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        //         return o2.getValue() - o1.getValue();
        //     }            
        // });
        // 1. 단어의 앏파벳 순으로 그 단어의 빈도를 출력
        // 2. 단어가 많이 나온 순으로 그 빈도를 출력

        List<Integer> list = new ArrayList<>();
        for (int i = 10; i> 0; i--) list.add(i);
        System.out.println("정렬하기전 ");
        System.out.println(list);

        Collections.sort(list);

        System.out.println("after sort");
        System.out.println(list);
    }
}
