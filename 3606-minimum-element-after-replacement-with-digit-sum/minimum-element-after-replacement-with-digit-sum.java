class Solution {
    public int minElement(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            while(nums[i] > 0){
                int digit = nums[i] % 10;
                nums[i] /= 10;
                sum += digit;
            }
            nums[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
        }
        return min;
    }
}