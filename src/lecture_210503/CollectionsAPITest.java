package lecture_210503;

import java.util.*;

public class CollectionsAPITest {
   public static void main(String[] args) {
    //  sortTest();
    //  shuffleTest(); // 섞기
        binarySearch();
   }
   public static void binarySearch() {
       // 수만개의 정수 원소를 가진 리스트에서 내가 찾고자 하는 값
       // ex) 123이 있는지, 어디에 있는지를 찾고자 함
       // 어떻게 해야할까?
   }

   public static void shuffleTest() {
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 1; i <= 10; i++)
         list.add(i);
      
      System.out.println(list);
      
      System.out.println("After shuffling");
      Collections.shuffle(list);
      
      System.out.println(list);
   }
   
   public static void sortTest() {
      String[] sample = {"i", "walk", "The", "Line"};
      // "i", "line", "the", "walk"
      
      // 대소문자 구별없이 알파벳 순으로 정렬되도록 하시오.
      List<String> list = Arrays.asList(sample);
      Collections.sort(list);
      System.out.println(list);
      Collections.sort(list, (o1, o2) -> o1.compareToIgnoreCase(o2));
      System.out.println(list);
   }
   
   
}