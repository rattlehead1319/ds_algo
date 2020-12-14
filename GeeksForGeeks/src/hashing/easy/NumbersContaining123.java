package hashing.easy;

import java.util.*;

public class NumbersContaining123 {
    static HashMap<Integer,Integer>mp=new HashMap<>();

    public static void findAll()
    {
        int i = 1000000;
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        q.add("3");

        while (Integer.parseInt(q.peek()) <= 1000000) {
            String a = q.poll();
            String b = q.poll();
            String c = q.poll();

            mp.put(Integer.parseInt(a), 1);
            mp.put(Integer.parseInt(b), 1);
            mp.put(Integer.parseInt(c), 1);

            q.add(a + "1");
            q.add(a + "2");
            q.add(a + "3");

            q.add(b + "1");
            q.add(b + "2");
            q.add(b + "3");

            q.add(c + "1");
            q.add(c + "2");
            q.add(c + "3");
        }
    }
}
