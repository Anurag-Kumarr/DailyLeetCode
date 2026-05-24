class Solution {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int max=0;
        int dp[]=new int[n];
        
        for(int i=0;i<n;i++){
            max=Math.max(max,fun(arr,d,i,dp));
        }
        return max; 
    }
    public int fun(int []nums,int d,int ind,int dp[]){
        if(dp[ind]>0)
        return dp[ind];
        int res=1;
        for(int i=ind-1;i>=Math.max(0,ind-d)&&nums[ind]>nums[i];i--){
            res=Math.max(res,1+fun(nums,d,i,dp));
        }
         for(int i=ind+1;i<=Math.min(nums.length-1,ind+d)&&nums[ind]>nums[i];i++){
            res=Math.max(res,1+fun(nums,d,i,dp));
        }
        return  dp[ind]=res;
    }
}