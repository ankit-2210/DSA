class Solution {
public:
    int maxNumberOfBalloons(string t){
        int n=t.size();

        map<char, int> mp;
        for(char ch: t){
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n'){
                mp[ch]++;
            }
        }

        if(mp.size()<5)
            return 0;

        int res=INT_MAX;
        for(char ch: t){
            if(ch == 'b' || ch == 'a' || ch == 'n'){
                res=min(res, mp[ch]);
            }
            else if(ch == 'l' || ch == 'o'){   
                res=min(res, mp[ch]/2);
            }
        }

        return res;

    }
};