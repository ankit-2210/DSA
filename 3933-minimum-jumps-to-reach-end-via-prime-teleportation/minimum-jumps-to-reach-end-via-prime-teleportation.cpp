class Solution{
public:
    int minJumps(vector<int> &nums){
        int n=nums.size();
        if(n == 1)
            return 0;

        int mx=*max_element(nums.begin(), nums.end());
        vector<int> prime(mx+1);
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

        map<int, vector<int>> mp;
        for(int i=0; i<n; i++){
            int x=nums[i];
            set<int> st;
            while(x>1){
                int t=prime[x];
                if(st.find(t) == st.end()){
                    mp[t].push_back(i);
                    st.insert(t);
                }
                x/=t;
            }
        }

        vector<bool> visited(n, false);
        queue<pair<int, int>> q;
        visited[0]=true;
        q.push({0, 0});
        while(!q.empty()){
            int idx=q.front().first;
            int steps=q.front().second;
            q.pop();

            if(idx == n-1)
                return steps;
            
            // if(visited[idx] == true)
                // continue;

            if(idx-1>=0 && visited[idx-1] == false){
                q.push({idx-1, steps+1});
                visited[idx-1]=true;
            }
            if(idx+1<n && visited[idx+1] == false){
                q.push({idx+1, steps+1});
                visited[idx+1]=true;
            }

            if(nums[idx]>1 && prime[nums[idx]] == nums[idx]){
                for(auto it: mp[nums[idx]]){
                    if(visited[it] == false){
                        q.push({it, steps+1});
                        visited[it]=true;
                    }
                }
                mp[nums[idx]].clear();
            }
        }

        return -1;

    }
};