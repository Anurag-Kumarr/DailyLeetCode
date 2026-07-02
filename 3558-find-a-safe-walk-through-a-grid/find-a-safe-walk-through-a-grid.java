class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[] dx4 = {0, 1, 0, -1};
        int[] dy4 = {1, 0, -1, 0};

        int m = grid.size();
        int n = grid.get(0).size();

        Queue<int[]> q = new LinkedList<>();

        int[][] best = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(best[i], -1);
        }

        best[0][0] = health;
        if (grid.get(0).get(0) == 1)
            best[0][0]--;

        q.offer(new int[]{0, 0, best[0][0]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int h = cur[2];

            if (x == m - 1 && y == n - 1)
                return true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx4[i];
                int ny = y + dy4[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nh = h - grid.get(nx).get(ny);

                    if (nh > 0 && nh > best[nx][ny]) {
                        best[nx][ny] = nh;
                        q.offer(new int[]{nx, ny, nh});
                    }
                }
            }
        }

        return false;
    }
}