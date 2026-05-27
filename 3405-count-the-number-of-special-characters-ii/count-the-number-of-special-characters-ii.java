class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        for(char c = 'a'; c <= 'z'; c++){
            int lastLower=word.lastIndexOf(c);
            int firstUpper=word.indexOf(Character.toUpperCase(c));
            if(lastLower != -1 && firstUpper != -1 && lastLower<firstUpper)
            {
                count++;
            }
        }
        return count;
    }
}