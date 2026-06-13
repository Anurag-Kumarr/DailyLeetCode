class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for(String s : words){
            int sum=0;
            for(char c : s.toCharArray()){
                sum+=weights[c-'a'];
            }
            sum=sum%26;
            ans=ans.append((char)('z'-sum));
        }
        return ans.toString();
    }
}