package lecture_210409;

import java.util.*;

public class StackTest {
    public static void main(String[] args) {
        // test1();
        // test2();
        checkExpression();
    }

    private static void test1() {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < 10; i++) {
            // auto boxing
            // stack.push(Character c) // char의 wrapper class
            // stack.push(char c)
            stack.push((char)('A'+i));
        }
        System.out.println(stack);
        // 다음에 인출될 원소 엿보기.
        System.out.println("다음에 인출될 원소: " + stack.peek());
        System.out.println("다음에 인출될 원소: " + stack.peek());
        System.out.println("다음에 인출될 원소: " + stack.peek());
        while (stack.size() > 0) {
            Character nextVal = stack.pop(); // stack안의 값들을 뺌
            // System.out.println(nextVal);
            if (nextVal == '(') {

            } else if (nextVal == ')') {
                stack.push(nextVal);
            }
            /* (이면 스택에 푸시,
                ) 이면 스택에서 empty인지 확인, empty가 아니면 pop
                empty이면 잘못된 식이라는 것을 출력
                return */
                
        }
        // stack이 empty이면 유효한 식임을 출력
        // 그렇지 않으면 잘못된 식임을 출력
        System.out.println(stack);
    }

    private static void test2() {
        String str = "APPLE,GRAPE,BANANA,MELON,STRAWBERRY";
        StringTokenizer st = new StringTokenizer(str, ",");
        while(st.hasMoreTokens()) {
            System.out.println("["+st.nextToken()+"]");
        }

    }

    private static void checkExpression() {
        System.out.println("수식을 입력하세요");
        Scanner input = new Scanner(System.in);
        String exp = input.nextLine();

        Stack<String> stack = new Stack<>() ;

        StringTokenizer st = new StringTokenizer(exp);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
             /* (이면 스택에 푸시,
                ) 이면 스택에서 empty인지 확인, empty가 아니면 pop
                empty이면 잘못된 식이라는 것을 출력
                return */
            String nextVal = st.nextToken();
            if (nextVal.equals("(")) {
                stack.push(nextVal);
            } else if (nextVal.equals(")")) {
                stack.push(nextVal);
                if (stack.empty()) {
                    System.out.println("잘못된 식입니다");
                    return;
                }
                stack.pop();
            }
        }
        // stack이 empty이면 유효한 식임을 출력
        // 그렇지 않으면 잘못된 식임을 출력
        if (stack.empty()) {

        }
    }
}

