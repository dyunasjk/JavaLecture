package lecture_210326;

import java.util.*;

public class MyArrayList<T> {
    
    Object[] array;
    private int capacity = 10;
    private int size = 0;

    public MyArrayList() {
        array = new Object [capacity];
    }

    public void add(T value) {
        System.out.println();
        if (size >= capacity) {
            int increasedCapacity = (int)(capacity * 1.5);
            T[] tmpArray = (T[]) new Object[increasedCapacity]; // 안됨. 안에 있던거 다 날아감=> tmpArray 만들어주고 값을 미리 복사
            // for (int i = 0; i < size; i++) 
            //     tmpArray[i] = array[i]; 비효율적
            System.arraycopy(array, 0, tmpArray, 0, size);
            array = tmpArray;
            capacity = increasedCapacity;
        }
        array[size++] = value;
    }

    public void add(T value, int idx) {

    }

    public void remove(int idx) {

    }

    public T get(int idx) {
        if (idx < size) return (T) array[idx];
        else return null;
    }
}
