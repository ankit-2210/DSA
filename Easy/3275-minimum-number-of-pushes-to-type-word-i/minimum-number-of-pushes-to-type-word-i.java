class Solution{
    public int minimumPushes(String w){
        int n=w.length();

        int b=n/8;
        return (4*b*(b+1))+((n%8)*(b+1));

    }
}