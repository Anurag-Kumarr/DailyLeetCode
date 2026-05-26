class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        for (char i='a';i<='z';i++) {
            if(word.indexOf(i) != -1 && word.indexOf(Character.toUpperCase(i)) != -1) {
                count++;
            }
        }
        return count;
    }
}