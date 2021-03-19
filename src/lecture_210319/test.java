package lecture_210319;

import java.io.*;

import javax.security.auth.login.LoginException;

public class test {
    public static void main(String[] args) {
        String id = "Jeong";
        String pw = "1111";
        try {
        login(id, pw);
        } catch(Exception e){
            // 로그인 에러 처리 로직 실행
            System.out.println(e.getMessage()+ ": " + e.getErrorCode());
            System.out.println("아이디, 암호 똑바로 입력해라");
        }
    }
    
    private static void login(String id, String pw) throws Exception{
        // try {
        //     checkDB(id, pw);
        // } catch(Exception e) { // 오류처리
        //     System.out.println(e.getMessage());
        // }
        checkDB(id, pw);
    }
    private static void checkDB(String id, String pw) throws Exception {
            if (id.equals("Jeong") == false ){
                throw new Exception("ID Error"); 
            } else if (pw.equals("1111") == false) {
                throw new Exception("Password Error");
            } else {
                System.out.println("login success");
            }
        
    } 
}