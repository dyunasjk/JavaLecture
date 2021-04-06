package lecture_210402;

import java.util.stream.IntStream;

public class MyLinkedList {
    int size;
    Node head = null;

    public void add(Integer value) {
        Node newNode = new Node();
        newNode.value = value;

        if (head == null) head = newNode;
        else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            } tmp.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Integer get(int index) {
        int idx = 0;
        Node tmp = head;
        while (idx < index && tmp.next != null) {
            tmp = tmp.next;
            idx++;
        }
    }

    public String toString() {
        String result = "[";
        Node tmp = head;
        while(tmp != null) {
            result += tmp.value + ", ";
            tmp = tmp.next;
        } result += "]";
        return result;
    }

    private class Node {
        // Node prev;
        Integer value;
        Node next = null;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        IntStream.rangeClosed(1, 10).forEach(i -> list.add(i));
        System.out.println(list);
    }
}
