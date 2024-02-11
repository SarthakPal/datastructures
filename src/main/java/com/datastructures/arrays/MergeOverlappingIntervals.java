package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals {

    public int[][] solve(int[][] intervals)
    {
        if(intervals.length<=1)
        {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval : intervals)
        {
            if(interval[0]<=newInterval[1])
            {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

}
