package lecture_210402;

import java.util.*;
import java.math.*;
import java.lang.*;

public class LottoNum {

        // set 6개의 원소가 들어갈 때까지
        // 1 ~ 45 사이의 무작위 값을 생성해 add 하면 됨
        // 출력은 오름차순으로 정렬된 순서로
        Set<Integer> set = new TreeSet<>();
        Random random = new Random(System.currentTimeMillis());
        while(set.size() < 6) {
            int num = random.nextInt(45)+1;
            set.add(num);
        }
        System.out.println(set);
        System.out.println("원소의 수: "+ set.size());


    public static void main(String[] args) {
        LottoNum ln = new LottoNum();

    }
}
