class Solution{
    int find(int node, int[] parent){
        if(node == parent[node])
            return node;
        return parent[node]=find(parent[node], parent);
    }

    void union1(int a, int b, int[] parent, int[] rank){
        int a1=find(a, parent);
        int b1=find(b, parent);

        if(a1 == b1)
            return;
        if(rank[a1]<rank[b1]){
            parent[a1]=b1;
            rank[b1]++;
        }
        else if(rank[a1]>rank[b1]){
            parent[b1]=a1;
            rank[a1]++;
        }
        else{
            parent[b1]=a1;
            rank[a1]=b1;
        }
    }
    
    public int minimumHammingDistance(int[] s, int[] t, int[][] as){
        int n=s.length;
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(int[]it: as){
            int i=it[0];
            int j=it[1];
            union1(i, j, parent, rank);
        }

        HashMap<Integer, List<Integer>> groups=new HashMap<>();
        for(int i=0; i<n; i++){
            int root=find(i, parent);
            groups.computeIfAbsent(root, k->new ArrayList<>()).add(i);
        }

        int res=0;
        for(List<Integer> idxs: groups.values()){
            HashMap<Integer, Integer> mp=new HashMap<>();
            for(int it: idxs){
                mp.put(s[it], mp.getOrDefault(s[it], 0)+1);
            }

            for(int it: idxs){
                if(mp.getOrDefault(t[it], 0)>0){
                    mp.put(t[it], mp.get(t[it])-1);
                }
                else{
                    res++;
                }
            }
        }

        return res;
    }
}