class Solution{
public:
    int find(int node, vector<int> &parent){
        if(node == parent[node])
            return node;
        return parent[node]=find(parent[node], parent);
    }

    void union1(int a, int b, vector<int> &parent, vector<int> &rank){
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

    int minimumHammingDistance(vector<int> &s, vector<int> &t, vector<vector<int>> &as){
        int n=s.size();
        vector<int> parent(n, -1), rank(n, 0);
        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(auto it: as){
            int i=it[0];
            int j=it[1];
            union1(i, j, parent, rank);
        }

        map<int, vector<int>> groups;
        for(int i=0; i<n; i++){
            groups[find(i, parent)].push_back(i);
        }

        int res=0;
        for(auto it: groups){
            vector<int> idxs=it.second;
            map<int, int> mp;
            for(auto it: idxs){
                mp[s[it]]++;
            }

            for(auto it: idxs){
                if(mp[t[it]]>0){
                    mp[t[it]]--;
                }
                else{
                    res++;
                }
            }
        }

        return res;
    }
};