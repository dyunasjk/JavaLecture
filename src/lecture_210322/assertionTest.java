package lecture_210322;

import java.util.*;

public class assertionTest {
    
    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)) {
            System.out.println("날짜를 입력하시오");
            int date = input.nextInt();
            //formatted text
            assert date >= 1 && date <= 31 : "잘못된 날짜:" + date;

            System.out.printf("입력된 날짜는 %d 입니다.\n", date);
        }
    }
}
