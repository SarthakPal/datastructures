package com.datastructures.graphs;

import java.util.*;


// toplogical sort aur find cycle in directed graph ka mixed solution hai

public class CourseScheduleII {

        public int[] findOrderUsingBFS(int numCourses, int[][] prerequisites) {

            List<List<Integer>> adjList = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            int[] indegree = new int[numCourses];

            for (int[] edge : prerequisites) {
                int course = edge[0];
                int pre = edge[1];

                adjList.get(pre).add(course);
                indegree[course]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }

            List<Integer> list = new ArrayList<>();

            int count = 0;

            while (!queue.isEmpty()) {
                Integer currentVertex = queue.poll();
                list.add(currentVertex);
                count++;

                for (Integer neighbour : adjList.get(currentVertex)) {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }

            if (count == numCourses) {
                int[] resultantArray = list.stream().mapToInt(Integer::intValue).toArray();
                return resultantArray;
            } else {
                return new int[0];
            }

        }


    public boolean findCycleUsingDFS(int currentVertex, List<List<Integer>> adjList, Set<Integer> visited, boolean[] inRecurrsion, Stack<Integer> stack)
    {
        visited.add(currentVertex);
        inRecurrsion[currentVertex] = true;

        for(Integer neighbour : adjList.get(currentVertex))
        {
            if(!visited.contains(neighbour))
            {
                if(findCycleUsingDFS(neighbour, adjList, visited, inRecurrsion, stack))
                {
                    return true;
                }
            }
            else if(inRecurrsion[neighbour]==true)
            {
                return true;
            }
        }

        inRecurrsion[currentVertex] = false;
        stack.push(currentVertex);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int pre = edge[1];

            adjList.get(pre).add(course);
            indegree[course]++;
        }

        Set<Integer> visited = new HashSet<>();
        boolean[] inRecurrsion = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean isCycle = false;

        for(int i=0;i<numCourses;i++)
        {
            if(!visited.contains(i))
            {
                if(findCycleUsingDFS(i, adjList, visited, inRecurrsion, stack))
                {
                    isCycle = true;
                    break;
                }

            }
        }

        if(isCycle)
        {
            return new int[0];
        }

        int[] result = new int[numCourses];

        int idx = 0;

        while(!stack.isEmpty())
        {
            result[idx] = stack.pop();
            idx++;
        }

        return result;
    }

}
