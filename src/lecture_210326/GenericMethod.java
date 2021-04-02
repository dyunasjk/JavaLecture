package lecture_210326;

public class GenericMethod {
    public static <T> T get(T[] arr, int idx) {
        return arr[idx];
    }
}
