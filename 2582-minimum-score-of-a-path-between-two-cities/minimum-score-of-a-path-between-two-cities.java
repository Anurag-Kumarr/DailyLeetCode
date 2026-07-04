class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], p -> new ArrayList<>()).add(new int[] {road[1], road[2]});
            graph.computeIfAbsent(road[1], p -> new ArrayList<>()).add(new int[] {road[0], road[2]});
        }
        boolean[] visited = new boolean[n+1];
        Queue<Integer> tQueue = new LinkedList<>();
        tQueue.offer(1);
        int ans = Integer.MAX_VALUE;
        while (!tQueue.isEmpty()) {
            int node = tQueue.poll();
            if (!visited[node] && graph.containsKey(node)) {
                visited[node] = true;
                for (int[] arr : graph.get(node)) {
                    ans = Math.min(ans, arr[1]);
                    tQueue.offer(arr[0]);
                }
            }
        }
        return ans;
    }
}