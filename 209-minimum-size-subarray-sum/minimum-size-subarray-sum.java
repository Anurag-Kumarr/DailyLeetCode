class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int total=0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            while(total>=target){
                res=Math.min(res,i-l+1);
                total-=nums[l];
                l+=1; 
            }
        }  
        return res==Integer.MAX_VALUE?0: res;
    }
}