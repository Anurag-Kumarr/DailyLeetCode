 class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int prefixCount = 0;
        
        for (int j = 1; j < n; j++) {
            if (j >= minJump && dp[j - minJump]) prefixCount++;
            if (j > maxJump && dp[j - maxJump - 1]) prefixCount--;
            dp[j] = prefixCount > 0 && s.charAt(j) == '0';
        }
        
        return dp[n - 1];
    }
 }