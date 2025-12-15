package com.datastructures.graphs;

import java.util.*;

// https://leetcode.com/problems/course-schedule/description/

// ye ek directed graph ka question hai jisme hume check karna hai ki koi cycle to nahi hai
// agar cycle hogi toh course complete nahi kar paenge.

public class CourseSchedule {

    public boolean canFinishUsingBFS(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites)
        {
            int course = edge[0];
            int pre =edge[1];

            adjList.get(pre).add(course);

            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty())
        {
            int currentVertex = queue.poll();
            count++;

            for(Integer neighbour : adjList.get(currentVertex))
            {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                {
                    queue.add(neighbour);
                }
            }

        }

        return count==numCourses;

    }

    public boolean isCycleDFS(int currentVertex, Set<Integer> visited, boolean[] inrecurrsion, List<List<Integer>> adjList)
    {
        visited.add(currentVertex);
        inrecurrsion[currentVertex] = true;

        for(Integer neighbour : adjList.get(currentVertex))
        {
            if(!visited.contains(neighbour))
            {
                if(isCycleDFS(neighbour, visited, inrecurrsion, adjList))
                {
                    return true;
                }
            }
            else if(inrecurrsion[neighbour]==true)
            {
                return true;
            }
        }

        inrecurrsion[currentVertex] = false;
        return false;

    }

    public boolean canFinishUsingDFS(int numCourses, int[][] prerequisites)
    {

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites)
        {
            int course = edge[0];
            int pre = edge[1];

            adjList.get(pre).add(course);
        }

        Set<Integer> visited = new HashSet<>();
        boolean[] inrecurrsion = new boolean[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(!visited.contains(i) && isCycleDFS(i, visited, inrecurrsion, adjList))
            {
                return false;
            }
        }

        return true;

    }

}
