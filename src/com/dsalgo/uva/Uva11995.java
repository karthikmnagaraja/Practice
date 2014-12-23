package com.dsalgo.uva;



import java.io.*;
import java.util.*;

/**
 * Created by knagaraj on 12/23/2014.
 */
public class Uva11995
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (bf.ready())
        {
            int n = new Integer(bf.readLine());
            Queue<Integer> q = new LinkedList<Integer>();
            TreeSet<Integer> p = new TreeSet<Integer>(new Comparator<Integer>()
            {
                public int compare(Integer o1, Integer o2)
                {
                    if (o1 == o2)
                        return -1;
                    return new Integer(o1).compareTo(o2);
                }
            });
            Stack<Integer> s = new Stack<Integer>();
            boolean Q = true, P = true, S = true;
            while (n-- > 0)
            {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                if (new Integer(st.nextToken()) == 1)
                {
                    int e = new Integer(st.nextToken());
                    q.add(e);
                    p.add(e);

                    s.add(e);
                } else
                {
                    int e = new Integer(st.nextToken());
                    Q &= !q.isEmpty() && e == q.poll();
                    P &= !p.isEmpty() && e == p.pollLast();
                    S &= !s.isEmpty() && e == s.pop();
                }
            }
            if (Q && !P && !S)
                out.println("queue");
            else if (P && !Q && !S)
                out.println("priority queue");
            else if (S && !P && !Q)
                out.println("stack");
            else if (Q || P || S)
                out.println("not sure");
            else
                out.println("impossible");

        }
        out.close();
    }
}