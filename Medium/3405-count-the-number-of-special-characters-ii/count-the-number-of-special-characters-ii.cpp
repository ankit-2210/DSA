class Solution{
public:
    int numberOfSpecialChars(string w){
        int n=w.size();

        vector<int> lower(26, -1), upper(26, -1);
        for(int i=0; i<n; i++){
            if(w[i]>='a' && w[i]<='z'){
                lower[w[i]-'a']=i;
            }
            else{
                if(upper[w[i]-'A'] == -1){
                    upper[w[i]-'A']=i;
                }
            }
        }

        int res=0;
        for(int i=0; i<26; i++){
            if(lower[i] != -1 && lower[i]<upper[i]){
                res+=1;
            }
        }

        return res;

    }
};