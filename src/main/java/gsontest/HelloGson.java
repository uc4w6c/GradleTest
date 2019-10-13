package gsontest;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.util.Collection;

public class HelloGson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Collection<Integer> ints = ImmutableList.of(1,2,3,4,5);
        String json = gson.toJson(ints);  // ==> json is [1,2,3,4,5]
        System.out.println(json);
        System.out.println("Hello, Gson!");
    }
}
