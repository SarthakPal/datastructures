package com.datastructures.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Info {
    int time;
    int profit;

    Info(int time, int profit) {
        this.time = time;
        this.profit = profit;
    }
}

class InfoComparator implements Comparator<Info> {
    public int compare(Info info1, Info info2) {
        return Integer.compare(info1.time, info2.time);
    }
}

public class FreeCars {

        public static int solve(int[] A, int[] B) {

            PriorityQueue<Info> minHeap = new PriorityQueue<>((a, b) -> a.profit - b.profit);

            int mod = 1000000007;

            ArrayList<Info> list = new ArrayList<>();

            int n = A.length;
            for(int i=0;i<n;i++)
            {
                Info info = new Info(A[i], B[i]);
                list.add(info);
            }

            Collections.sort(list, new InfoComparator());

            int res = 0;
            int curr_time = 0;

            for(int i=0;i<n;i++)
            {
                Info new_info = list.get(i);
                int new_time = new_info.time;
                int new_profit = new_info.profit;

                if(curr_time<=new_time-1)
                {
                    res = (res+new_profit)%mod;
                    minHeap.offer(new_info);
                    curr_time++;
                }
                else if(curr_time==new_time)
                {
                    Info top = minHeap.peek();
                    int top_profit = top.profit;
                    if(top_profit<new_profit)
                    {
                        res = (res-top_profit)%mod;
                        minHeap.poll();
                        res = (res+new_profit)%mod;
                        minHeap.offer(new_info);
                    }
                }
            }
            return res;
        }

        public static void main(String args[])
        {
            int  A[] = {1, 3, 2, 3, 3};
            int  B[] = {5, 6, 1, 3, 9};

            solve(A, B);

        }

}
