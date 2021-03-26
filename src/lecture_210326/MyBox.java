package lecture_210326;

public class MyBox <T>  { //<>를 통해 파라미터를 불러오는 제네릭 클래스 생성
    T[] value;

    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
