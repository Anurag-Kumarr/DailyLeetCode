class Solution {
    public int[] circularGameLosers(int n, int k) {

        int[] count = new int[n];
        int step = 1, pos = 0;
        while (++count[pos] != 2) {
            pos += (k * step++);
            pos %= n;
        }

        int loosers = 0;
        for (int value : count) if (value == 0) loosers++;

        int[] ans = new int[loosers];
        for (int i = 0, j = 0; i < count.length; i++)
            if (count[i] == 0) ans[j++] = i + 1;

        return ans;
    }
}