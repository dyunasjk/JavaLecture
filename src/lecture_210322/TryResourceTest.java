package lecture_210322;

import java.io.*;

public class TryResourceTest {

    public static void main(String[] args) {
        writeList();
    } 
    
    public static void writeList() {
        // PrintWriter out = null;
        // FileOutputStream fout = null; // 아래 텍스트이름 앞에 폴더명을 지정하고, 만약 폴더가 없으면 폴더를 만들지는 않고, 에러 발생
        // try {
        //     out = new PrintWriter("outfile.txt");
        //     for (int i = 0; i < 10; i ++) {
        //         out.println("배열 원소 " +i+" = "+i);
        //     }
            
        // } catch (FileNotFoundException e) {
        //     // System.out.println(e.getMessage());
        //     e.printStackTrace();
        // } finally {
        //     if (out != null)
        //         out.close(); //사용하고 나서 연결을 끊는 과정
        //     System.out.println("파일을 닫았습니다.");
        // }

        try (PrintWriter out = new PrintWriter("outfile2.txt")) {
            for (int i = 0; i < 10; i ++) {
                out.println("배열 원소" +i+ " = " +i);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
