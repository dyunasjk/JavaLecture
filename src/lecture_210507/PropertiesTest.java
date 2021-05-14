package lecture_210507;

import java.util.*;
import java.io.*;

public class PropertiesTest {
    public static void main(String[] args) {
        // Map<String, String> env = System.getenv();
        // Set<String> keys = env.keySet();
        // for (String s : keys) {
        //     System.out.println(keys + ": " + env.get(keys));
        // }
        // Properties는 <key, value>의 타입이 각각 String, String으로 고정된 일종의 Map 객체
        Properties props = new Properties();
        try (FileReader reader = new FileReader("./dict.props")) {
            props.load(reader);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        Set<Object> keys = props.keySet();
        for (Object key : keys) {
            System.out.println(key + ": " + props.get(key));
        }
        props.put("나무", "tree");
        try (PrintWriter out = new PrintWriter(new File("dict.props"))) {
            props.store(out, "My Dictionary");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // props.put("name", "홍길동");
        // props.put("age", "21");

        // Set<Object> keys = props.keySet();
        // for (Object key: keys) {
        //     System.out.println(key + ": " + props.get(key));
        // }
    }
}
// connection oriented
// http는 커넥션 리스(응답시 연결이 끊어짐)
// 하지만 DB는 연결이 끊어지지 않는 계속 연결되있는 상태
// 서버가 하나일 경우 수십만명이 데이터를 요청할 경우 서버가 뻗는다
// 그러면 로드발란스를 통해 분산데이터베이스를 만들어 각 데이터베이스로 요청을 분산 및 보낸다.
// 하지만 특정 데이터베이스에서는 로그인 정보라던가 정보가 한정되있다면 해당 데이터를 공유할 수 있는 공유데이터를 만들어 사용한다던가 그런식으로 운용을 해봐야 한다