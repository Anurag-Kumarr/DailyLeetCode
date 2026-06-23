class Solution {
    public boolean isUgly(int n) {
        int a=n;
        if(a<=0)
        {
            return false;
        }
        while(a%2==0){
            a=a/2;
        }
        while(a%3==0){
            a=a/3;
        }
        while(a%5==0){
            a=a/5;
        }
        if(a==1){
            return true;
        } else {
            return false;
        }
    }
}