class Solution {
    public int minimumEffort(int[][] tasks) {
        int[] mapDiffToCost = new int[10001];
        for(int[] task : tasks) {
            mapDiffToCost[task[1] - task[0]] += task[0];
        }

        int cost = 0;
        for(int i = 0; i <= 10000; i++) {
            if(mapDiffToCost[i] > 0) {
                cost = mapDiffToCost[i] + Math.max(cost , i);
            }
        }
        return cost;
    }
}