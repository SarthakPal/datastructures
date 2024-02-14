package com.datastructures.greedy;

import java.util.PriorityQueue;

public class NMeetingsInOneRoom {

    class Info
    {
        int start;
        int end;
        Info(int start,  int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    PriorityQueue<Info> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);

    public int solve(int[] A, int[] B) {

        int n = A.length;

        for(int i=0;i<n;i++)
        {
            Info info = new Info(A[i], B[i]);
            minHeap.offer(info);
        }

        int max_jobs = 1;

        Info curr_info = minHeap.poll();

        int curr_start = curr_info.start;
        int curr_end = curr_info.end;

        while(minHeap.size()>0)
        {
            Info new_info = minHeap.poll();
            int new_start = new_info.start;
            int new_end = new_info.end;

            if(new_start >= curr_end)
            {
                curr_start = new_start;
                curr_end = new_end;
                max_jobs++;
            }
        }
        return max_jobs;
    }
}

