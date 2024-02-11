package com.datastructures.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Pair
{
    int first; int second; int third;
    Pair(int first, int second, int third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class PairComparator implements Comparator<Pair>
{
    public int compare(Pair p1, Pair p2)
    {
        if(p1.first < p2.first)
        {
            return -1;
        }
        else if(p1.first==p2.first)
        {
            return 0;
        }
        else
        {
           return 1;
        }
    }
}

public class MergeKSortedLists {

    public List<Integer> solve(ArrayList<ArrayList<Integer>> lists, int k)
    {

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new PairComparator());

        for(int i=0;i<k;i++)
        {
            minHeap.add(new Pair(lists.get(i).get(0), i, 0));
        }

        while(minHeap.isEmpty()==false)
        {
            Pair p = minHeap.remove();

            int i = p.second;
            int j = p.third;

            result.add(p.first);

            if(j+1<lists.get(i).size())
            {
                minHeap.add(new Pair(lists.get(i).get(j+1), i, j+1));
            }
        }

        return result;
    }

}
