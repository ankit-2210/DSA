class Solution{
    public boolean findSafeWalk(List<List<Integer>> g, int h){
        int n=g.size();
        int m=g.get(0).size();

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[0]-a[0]);
        h -= g.get(0).get(0);

        int[][] dist=new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }

        pq.offer(new int[]{h, 0, 0});
        dist[0][0]=h;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int x=curr[0];
            int i=curr[1];
            int j=curr[2];

            if(i == n-1 && j == m-1)
                return true;

            if(i-1>=0){
                int newh=x-g.get(i-1).get(j);
                if(newh>=1 && newh>dist[i-1][j]){
                    dist[i-1][j]=newh;
                    pq.offer(new int[]{newh, i-1, j});
                }
            }
            if(i+1<n){
                int newh=x-g.get(i+1).get(j);
                if(newh>=1 && newh>dist[i+1][j]){
                    dist[i+1][j]=newh;
                    pq.offer(new int[]{newh, i+1, j});
                }
            }
            if(j-1>=0){
                int newh=x-g.get(i).get(j-1);
                if(newh>=1 && newh>dist[i][j-1]){
                    dist[i][j-1]=newh;
                    pq.offer(new int[]{newh, i, j-1});
                }
            }
            if(j+1<m){
                int newh=x-g.get(i).get(j+1);
                if(newh>=1 && newh>dist[i][j+1]){
                    dist[i][j+1]=newh;
                    pq.offer(new int[]{newh, i, j+1});
                }
            }
        }

        return false;


    }
}