package gsontest.T1567;

import com.google.gson.Gson;

/* https://github.com/google/gson/issues/1567 */
public class HelloTest {
    public static void main(String[] args) {
        System.out.println("start");

        // 再現しない
        Gson gson = new Gson();
        Example example = gson.fromJson("{\"strsdata\":\"for example\",\"strdata\":\"\",\"intdata\":10.0,\"htmldata\":\"\\u003cp\\u003e\\r\\n\\t12312：\\r\\n\\u003c/p\\u003e\\r\\n\\u003cp\\u003e\\r\\n\\t1.12312\\r\\n\\u003c/p\\u003e\\r\\n\\u003cp\\u003e\\r\\n\\t21231\\r\\n\\u003c/p\\u003e\\r\\n\\u003cp\\u003e\\r\\n\\t3.adasd。\\r\\n\\u003c/p\\u003e\"}", Example.class);
        System.out.println(example);

        System.out.println("end");
    }
}
