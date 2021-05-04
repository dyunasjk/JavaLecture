package lecture_210503;

import java.util.*;

public class CollectionsAPITest {
    public static void main(String[] args) {
    //  sortTest();
    //  shuffleTest(); // 섞기
        // binarySearch();
        // Integer arr[] = new Integer[7];
        // for (int i = 0; i <arr.length; i++) arr[i] =i;
        // List<Integer> list = Arrays.asList(arr);
        // String[] str = {"a", "b","c","d","e","f","g","h","i" };
        // // binarySearch2();
        // List<String> list2 = Arrays.asList(str);
        // System.out.println(binarySearch2(list,"b"));
        
    }
   public static void binarySearch() {
       // 수만개의 정수 원소를 가진 리스트에서 내가 찾고자 하는 값
       // ex) 123이 있는지, 어디에 있는지를 찾고자 함
       // 어떻게 해야할까?
       // 만약, 리스트의 원소가 정렬되어 있다면?
       // 만개의 원소에서 내가 원하는 값 찾기를 할때
       // 최대 몇 번의 비교를 해야할까?

       // 이진 탐색을 하기 위한 대전제 조건은?
       // 리스트의 원소가 정렬되어 있어야한다.

       List<Integer> list = new ArrayList<>();
       for (int i =0; i<=10; i++) list.add(i);
    //    Collections.shuffle(list); // 정렬되지 않은 리스트에선 이진탐색은 불가
    //    System.out.println(list);
       int idx = Collections.binarySearch(list, 7);
       if (idx>=0) System.out.println((idx+1) + "위치에 있습니다");
       else System.out.println("7은 리스트에 없습니다");
       
   }
    public static <T extends Comparable<T>> int binarySearch2(List<T> list, T key) {
        int left = 0;
        int right = list.size()-1;

       // left가 right 이하인 동안 다음을 반복
       /* 
       mid = (left+right)/2
       if (list.get(mid) == key) return mid;
       else if (listget(mid) > key) {right = mid -1;}
       else left = mid +1
       */
        int mid = (left+right)/2;
        if (list.get(mid).compareTo(key) == 0) return mid;
        else if (list.get(mid).compareTo(key) > 0) right = mid -1;
        else left = mid +1;
        return left*(-1);
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