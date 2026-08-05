class Solution{
    public List<Integer> remainingMethods(int n, int k, int[][] invo){
        
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        } 

        for(int[] it: invo){
            adj.get(it[0]).add(it[1]);
        }

        boolean[] visited=new boolean[n];
        // Arrays.fill(visited, false);
        Queue<Integer> q=new LinkedList<>();
        q.offer(k);
        visited[k]=true;

        while(!q.isEmpty()){
            int node=q.poll();

            for(int it: adj.get(node)){
                if(!visited[it]){
                    q.offer(it);
                    visited[it]=true;
                }
            }
        }

        boolean flag=true;
        for(int i=0; i<n && flag; i++){
            if(!visited[i]){
                for(int it: adj.get(i)){
                    if(visited[it]){
                        flag=false;
                        break;
                    }
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        if(!flag){
            for(int i=0; i<n; i++){
                res.add(i);
            }
        }
        else{
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    res.add(i);
                }
            }
        }

        return res;


    }
}