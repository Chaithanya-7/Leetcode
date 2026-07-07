class Solution {
    public long sumAndMultiply(int n) {
        long num=0;
        int sum=0;
        int cnt=0;
        while(n>0){
            int temp = n%10;n/=10;sum+=temp;
            if(temp!=0) num+=temp *Math.pow(10,cnt++);
        }
        return num*sum;
    }
}