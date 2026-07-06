class Solution{
    public int removeCoveredIntervals(int[][] it){
        int n=it.length;
        int m=it[0].length;

        Arrays.sort(it, (a, b)->{
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int res=0;
        int end=-1;
        for(int[] itt: it){
            if(itt[1]>end){
                res++;
                end=itt[1];
            }
        }

        return res;


    }
}