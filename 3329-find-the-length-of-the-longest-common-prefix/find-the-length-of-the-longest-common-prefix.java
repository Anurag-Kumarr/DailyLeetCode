class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr1) {
            while(i > 0) {
                set.add(i);
                i /= 10;
            }
        }
        int max = 0;
        for(int i : arr2) {
            while(i > 0) {
                if (set.contains(i)) {
                    max = Math.max(max, (int)Math.log10(i) + 1);
                }
                i /= 10;
            }
        }
        return max;
    }
}