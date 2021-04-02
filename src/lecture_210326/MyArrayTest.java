package lecture_210326;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();

        for (int i = 0; i <= 100; i++) {
            list1.add(i);
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        MyArrayList<Student> list2 = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list2.add(new Student(i + "", (i+1)*10));
        }

        // for (int i = 0; i < list2.size(); i++) {
        //     System.out.println(list2.get(i));
        // }

        // for (Student std : list2) {
        //     System.out.println(std);
        // }

        // @Override
        // public static void Iterable() {
        //     return new Itr();
        // }
    }
}
