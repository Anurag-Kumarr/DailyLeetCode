class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean found = nums[n - 1] > nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            int n1 = nums[i];
            int n2 = nums[i + 1];

            if (n1 > n2) {
                if (!found) {
                    found = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}