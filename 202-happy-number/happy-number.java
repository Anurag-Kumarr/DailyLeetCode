class Solution {
    public boolean isHappy(int n) {
        int num=n;
        int sum=0;
        while(num!=1 && num!=4){
            sum=0;
            while(num!=0){
                int rem=num%10;
                sum=sum+rem*rem;
                num=num/10;
            }
            num=sum;
        }
        if(num==1){
            return true;
        } else {
            return false;
        }
    }
}