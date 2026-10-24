class Solution{
    public int countDaysTogether(String aa, String la, String ab, String lb){
        
        int[] prefix=new int[13];
        int[] days={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        prefix[0]=0;
        for(int i=1; i<13; i++){
            prefix[i]=prefix[i-1]+days[i-1];
        }

        int alicestart = prefix[Integer.parseInt(aa.substring(0, 2))]+Integer.parseInt(aa.substring(3, 5));
        int aliceend = prefix[Integer.parseInt(la.substring(0, 2))]+Integer.parseInt(la.substring(3, 5));

        int bobstart = prefix[Integer.parseInt(ab.substring(0, 2))]+Integer.parseInt(ab.substring(3, 5));
        int bobend = prefix[Integer.parseInt(lb.substring(0, 2))]+Integer.parseInt(lb.substring(3, 5));

        if(bobstart>aliceend || alicestart>bobend)
            return 0;

        int start=(alicestart<bobstart)?bobstart:alicestart;
        int end=(aliceend<bobend)?aliceend:bobend;

        return end-start+1;

    }
}