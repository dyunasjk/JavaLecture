package lecture_210402;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        // test();
        // test1();
        countDistictWorld();
    }

    private static void countDistictWorld() {
        // Set<String> set = new HashSet<>();
        Map<String, Integer> map = new TreeMap<>();
        
        File file = new File("c:/Users/jgh49/Desktop/javaPractice/javaLecture/wordbook.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s = null;
            while ((s = br.readLine()) != null){
                System.out.println("["+s.trim() + "]");
                // set.add(s);
                Integer n = map.get(s);
                if (n == null) {
                    map.put(s,1);
                } else {
                    map.put(s, n+1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());   
        }
        // System.out.println("중복되지 않은 단어 수: " + set.size());
        Set<String> set = map.keySet();
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            map.get(key);
            Integer value = map.get(key);
            System.out.println(key + ":" + value+", ");
        }
    }
    // public class LottoNum {

    //     // set 6개의 원소가 들어갈 때까지
    //     // 1 ~ 45 사이의 무작위 값을 생성해 add 하면 됨
    //     // 출력은 오름차순으로 정렬된 순서로
    //     Set<Integer> set = new TreeSet<>();
    //     Random random = new Random(System.currentTimeMillis());
    //     while(set.size() < 6) {
    //         int num = random.nextInt(45)+1;
    //         set.add(num);
    //     }
    //     System.out.println(set);
    //     System.out.println("원소의 수: "+ set.size());

    // }


    private static void test1() {
        // HashSet
        // 순서 없고, 중복 허용하지 않는 집합
        // Set<String> set = new HashSet<>();
        // treeSet은 중복은 허용하지 않지만, 값에 따라 순서대로 정렬 및 출력
        // Set<String> set = new LinkedHashSet<>(); // 중복은 허용하지 않지만 입력된 순서는 유지됨. 입력된 순서로 인출됨
        Set<String> set = new TreeSet<>(new Comparator<String>(){
            public int compare(String o1, String o2) {
                return o2.compareTo(o1); // 내림차순
            }
        });
        String[] strArr = {"word", "중복", "구절", "중복"};
        for (String s: strArr) {
            if (set.add(s) == false) {
                System.out.println(s + "는 이미 존재하는 값");
           }
        }
        System.out.println(set);

        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
        // iter.next(); 여기서 익셉션 발생
        System.out.println();
        iter = set.iterator();
        iter.next();
        System.out.println("끝...");
    }

    private static void test() {
        // List<Integer> list = new ArrayList<>(); // arrayList 일시 속도 23ms
        List<Integer> list = new LinkedList<>(); //linkedList 일시 속도 8ms
        IntStream.rangeClosed(1, 10000).forEach(i -> list.add(i));
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            // list.add(100, (i+1)*1000);
            list.get(i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("elapsed time: " + (endTime- startTime));
    }
    private void test0() {
                
    //List<String> list = new ArrayList<>();
    List<String> list = new LinkedList<>();

    list.add("Milk");
    list.add("Bread");
    list.add("Butter");
    System.out.println(list);

    list.add(1,"Apple");
    System.out.println(list);

    list.set(2, "Grape");
    System.out.println(list);

    list.remove(3);
    System.out.println(list);

    for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i) + " ");
    } System.out.println();

    for (String s : list) {
        System.out.print(s + " ");
    } System.out.println();

    Iterator<String> iter = list.iterator();
    while(iter.hasNext()) {
        iter.next(); } 
    }
}
