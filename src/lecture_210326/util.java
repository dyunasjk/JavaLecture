package lecture_210326;

import java.util.*;

public class util {
    
    // public static <T extends Comparable<T>> T getMax(T[] arr) { // 비교가능한 T만 오게 하고 싶을 떄는 이렇게 처리
    //     T max = arr[0];
    //     for (int i = 1; i < arr.length; i++) if (max.compareTo(arr[i]) < 0) max = arr[i]; // if (조건)에서 에러 => 모든 타입의 연산자가 올수있기 떄문
    //     return max;
    // }
    // public static <T> void println(T[] arr) {
    //     for (int i = 0; i<arr.length; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    // }

    public static <T extends Comparable<T>> T getMax(T[] arr) { // 비교가능한 T만 오게 하고 싶을 떄는 이렇게 처리
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) if (max.compareTo(arr[i]) < 0) max = arr[i]; // if (조건)에서 에러 => 모든 타입의 연산자가 올수있기 떄문
        return max;
    }

    // public static <T extends Number> void printValueOf5Times(T value) { // Number class를 받음
    //     Double result = value.doubleValue() * 5;
    //     System.out.println(result);
    // }

    public static <T extends Number> void printSum(List<T> list) {
        Double sum = 0.0;
        for (T val : list) sum += val.doubleValue();
        System.out.println("sum :" + sum);
    }

    public static <T> void println(T[] arr) {
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
}
