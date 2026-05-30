
class Solution {
    private static final int MAX_X = 50000;

    private final int size;
    private final int[] seg;

    public Solution() {
        int s = 1;
        while (s <= MAX_X)
            s <<= 1;
        size = s;
        seg = new int[size << 1];
    }

    private void update(int pos, int val) {
        int node = pos + size;
        seg[node] = val;

        node >>= 1;
        while (node > 0) {
            seg[node] = Math.max(seg[node << 1], seg[node << 1 | 1]);
            node >>= 1;
        }
    }

    private int query(int left, int right) {
        int res = 0;

        left += size;
        right += size;

        while (left <= right) {
            if ((left & 1) == 1) {
                res = Math.max(res, seg[left++]);
            }

            if ((right & 1) == 0) {
                res = Math.max(res, seg[right--]);
            }

            left >>= 1;
            right >>= 1;
        }

        return res;
    }

    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> ans = new ArrayList<>();

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(MAX_X);

        update(MAX_X, MAX_X);

        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];

                int prev = obstacles.floor(x);
                int next = obstacles.ceiling(x);

                obstacles.add(x);

                update(x, x - prev);
                update(next, next - x);
            } else {
                int x = q[1];
                int sz = q[2];

                int prev = obstacles.floor(x);

                int bestGap = Math.max(
                        query(0, prev),
                        x - prev);

                ans.add(bestGap >= sz);
            }
        }

        return ans;
    }
}