import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll();
                if (idx == n - 1) return steps;
                
                if (idx + 1 < n &&!visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }
                if (idx - 1 >= 0 &&!visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }
                List<Integer> sameValIndices = graph.get(arr[idx]);
                if (sameValIndices!= null) {
                    for (int j : sameValIndices) {
                        if (!visited[j]) {
                            visited[j] = true;
                            q.offer(j);
                        }
                    }
                    sameValIndices.clear();
                }
            }
            steps++;
        }
        return -1;
    }
}