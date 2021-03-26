package lecture_210326;

public class utilTest {
    
    public static void main(String[] args) {
        // Integer[] arr = {3, 4, 2, 10, 38, 76, 92, 124, 13, 24};
        // Double[] arr = {3.0, 4.0, 2.0, 10.0, 38.0, 76.0, 92.0, 124.0, 13.0, 24.0}; // 로직은 동일하지만 타입달라서 안됨
        // String[] arr = {"동해물과", "백두산이", "마르고", "닳도록"};
        Student[] arr = {new Student("가", 78), new Student("나", 90), new Student("다", 79)};
        System.out.println("범위값");
        util.getMax(arr);
        System.out.println("최대값: " + util.getMax(arr));
    }
}
