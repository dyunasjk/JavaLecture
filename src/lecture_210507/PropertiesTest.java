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
