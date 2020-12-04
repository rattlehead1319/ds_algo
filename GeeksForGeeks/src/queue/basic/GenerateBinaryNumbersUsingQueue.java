package queue.basic;

import java.util.*;

public class GenerateBinaryNumbersUsingQueue {
    static void generate(long n)
    {
        Queue<String> q=new LinkedList<String>();
        q.add("1");
        for(int i=1;i<=n;i++){
            String val=q.poll();
            System.out.print(val+" ");
            q.add(val+"0");
            q.add(val+"1");
        }
    }
}
