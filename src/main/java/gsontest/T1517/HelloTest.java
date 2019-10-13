package gsontest.T1517;

import com.google.gson.Gson;
import gsontest.T1567.Example;

/* https://github.com/google/gson/issues/1517 */
public class HelloTest {
    public static void main(String[] args) {
        System.out.println("start");

        // 再現しない
        Gson gson = new Gson();
        String str = gson.fromJson("\"http://localhost/test?aa=aa&mid=aa\"", String.class);
        System.out.println("String: " + str);

        System.out.println("end");
    }
}
