class Solution{
    public int maxScore(int[] p, int[] op, int[] s){
        int n=p.length;

        List<Integer>[] child = new ArrayList[n];
        for(int i=0; i<n; i++){
            child[i]=new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            child[p[i]].add(i);
        }

        Stack<Integer> st=new Stack<>();
        int[] order = new int[n];

        st.push(0);
        order[0]=0;
        int idx=0;
        while(!st.empty()){
            int u=st.peek();
            st.pop();

            order[idx++]=u;
            for(int v: child[u]){
                st.push(v);
            }
        }
        
        long[] dp=new long[n];
        int k=n-1;
        while(k>=0){
            int u=order[k];
            
            if(child[u].isEmpty()){
                dp[u]=s[u];
                k--;
                continue;
            }
            
            long sum=s[u];
            long mn=Long.MAX_VALUE;

            for(int v: child[u]){
                sum += dp[v];
                mn=Math.min(mn, dp[v]);
            }

            if(op[u] == 0){
                if(mn<0){
                    sum -= mn;
                }
            }
            else{
                sum -= mn;
            }

            dp[u]=sum;
            k--;
        }

    return (int)dp[0]; 
        
    }
}