class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int time = 0, ans = Integer.MAX_VALUE;
        
        for(int i=0; i<landStartTime.length; i++){
            time = landStartTime[i] + landDuration[i];

            for(int j=0; j<waterStartTime.length; j++){
                int water = Math.max(time, waterStartTime[j]);
                int finish = water + waterDuration[j];
                ans = Math.min(finish, ans);
            }
        }
        for(int i=0; i<waterStartTime.length; i++){
            time = waterStartTime[i] + waterDuration[i];

            for(int j=0; j<landStartTime.length; j++){
                int land = Math.max(time, landStartTime[j]);
                int finish = land + landDuration[j];
                ans = Math.min(finish, ans);
            }
        }
        return ans;
    }
}