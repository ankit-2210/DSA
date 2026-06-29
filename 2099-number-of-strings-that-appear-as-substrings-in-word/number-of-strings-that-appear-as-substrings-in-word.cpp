class Solution{
public:
    int numOfStrings(vector<string> &p, string w){
        
        int res=0;
        for(auto it: p){
            if(w.find(it) != string::npos)
                res++;
        }

        return res;

    }
};