class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        for(int i=0;i<nums.length;i++){
            int mid=(left+right)/2;
            if(nums[i]==target){
                return i;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}