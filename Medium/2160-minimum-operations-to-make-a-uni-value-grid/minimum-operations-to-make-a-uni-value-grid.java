class Solution{
    public int minOperations(int[][] g, int x){
        int n=g.length;
        int m=g[0].length;

        List<Integer> temp=new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                temp.add(g[i][j]);
            }
        }
        
        Collections.sort(temp);
        int rem=temp.get(0)%x;
        for(int val: temp){
            if(val%x != rem)
                return -1;
        }
        int size=n*m;
        int mid=temp.get(size/2);
        // cout << mid << endl;
        int res=0;
        for(int val: temp){
            res += Math.abs(val-mid)/x;
        }

        return res;
    }
}