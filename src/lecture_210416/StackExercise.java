package lecture_210416;

import java.util.*;

public class StackExercise {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("수식을 입력하시오.");
        String exp = input.nextLine();

        StringTokenizer st = new StringTokenizer(exp, " ");
        while(st.hasMoreTokens()) {
            System.out.println("["+st.nextToken()+"]");
        }
    }

    public static void StringTokenizer() {
        StringTokenizer st = new StringTokenizer("APPLE, GRAPE, BANANA, STRAWBERRY", ", ");
        while (st.hasMoreTokens()) {
            System.out.println("["+st.nextToken()+"]");
        }            
    }
}
