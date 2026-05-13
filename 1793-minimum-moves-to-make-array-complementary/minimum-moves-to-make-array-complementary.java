class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int pairs = n / 2;
        int[] diff = new int[2 * limit + 2];
        int left = 0, right = n - 1;
        while (left < right) {
            int a = nums[left++];
            int b = nums[right--];
            int sum = a + b;
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            diff[low] -= 1;
            diff[high + 1] += 1;
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }
        int answer = Integer.MAX_VALUE;
        int current = 2 * pairs;
        for (int SUM = 2; SUM <= 2 * limit; SUM++) {
            current += diff[SUM];
            answer = Math.min(answer, current);
        }
        return answer;
    }
}