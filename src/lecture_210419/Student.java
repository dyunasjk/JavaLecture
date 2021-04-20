package lecture_210419;

import java.util.*;

class Student {
    int number;
    String name;

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }
    public String toString() {
        return "[number:" + number +", name: " + name+ "]" ;
    }
}
