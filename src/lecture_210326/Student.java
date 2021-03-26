package lecture_210326;

public class Student implements util{
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }   
    public void getName() {
        this.name = name;
    }
    public void getScore() {
        this.score = score;
    }

    public String setName() {
        return name;
    }

    public int setScore() {
        return score;
    }
    @Override 
    public int compareTo(Student o) {
        return this.score - o.score;
    }
    @Override
    public String toString{} {
        return "[name: "+name+ ", score: " +score + "]";
    }
}