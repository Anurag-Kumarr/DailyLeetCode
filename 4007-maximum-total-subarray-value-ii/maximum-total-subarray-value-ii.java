import java.util.*;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int[] log2 = new int[n + 1];
        log2[1] = 0;
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }
        int K = log2[n] + 1;

        int[][] stMax = new int[K][n];
        int[][] stMin = new int[K][n];
        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }
        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[j][i] = Math.max(stMax[j - 1][i], stMax[j - 1][i + (1 << (j - 1))]);
                stMin[j][i] = Math.min(stMin[j - 1][i], stMin[j - 1][i + (1 << (j - 1))]);
            }
        }
        class RMQ {
            int rangeMax(int l, int r) {
                int len = r - l + 1;
                int p = log2[len];
                return Math.max(stMax[p][l], stMax[p][r - (1 << p) + 1]);
            }

            int rangeMin(int l, int r) {
                int len = r - l + 1;
                int p = log2[len];
                return Math.min(stMin[p][l], stMin[p][r - (1 << p) + 1]);
            }
        }

        RMQ rmq = new RMQ();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++) {
            long val = (long) rmq.rangeMax(l, n - 1) - rmq.rangeMin(l, n - 1);
            pq.offer(new long[]{val, l, n - 1});
        }

        long ans = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            long[] top = pq.poll();
            long val = top[0];
            int l = (int) top[1];
            int r = (int) top[2];
            ans += val;
            if (r > l) {
                int newR = r - 1;
                long newVal = (long) rmq.rangeMax(l, newR) - rmq.rangeMin(l, newR);
                pq.offer(new long[]{newVal, l, newR});
            }
        }

        return ans;
    }
}