class Solution{
    public int minJumps(int[] nums){
        int n=nums.length;
        if(n == 1)
            return 0;

        int mx=0;
        for(int x: nums){
            mx=Math.max(mx, x);
        }
        int[] prime=new int[mx+1];
        for(int i=0; i<=mx; i++){
            prime[i]=i;
        }

        for(int i=2; i*i<=mx; i++){
            if(prime[i] == i){
                for(int j=i*i; j<=mx; j+=i){
                    prime[j]=i;
                }
            }
        }

        HashMap<Integer, List<Integer>> mp=new HashMap<>();
        for(int i=0; i<n; i++){
            int x=nums[i];
            HashSet<Integer> st=new HashSet<>();
            while(x>1){
                int t=prime[x];
                if(!st.contains(t)){
                    mp.computeIfAbsent(t, k->new ArrayList<>()).add(i);
                    st.add(t);
                }
                x/=t;
            }
        }

        boolean[] visited=new boolean[n];
        Queue<int[]> q=new LinkedList<>();
        visited[0]=true;
        q.offer(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int idx=curr[0];
            int steps=curr[1];

            if(idx == n-1)
                return steps;

            if(idx-1>=0 && visited[idx-1] == false){
                q.offer(new int[]{idx-1, steps+1});
                visited[idx-1]=true;
            }
            if(idx+1<n && visited[idx+1] == false){
                q.offer(new int[]{idx+1, steps+1});
                visited[idx+1]=true;
            }

            if(nums[idx]>1 && prime[nums[idx]] == nums[idx]){
                for(int it: mp.get(nums[idx])){
                    if(visited[it] == false){
                        q.offer(new int[]{it, steps+1});
                        visited[it]=true;
                    }
                }
                mp.get(nums[idx]).clear();
            }
        }

        return -1;
    }
}