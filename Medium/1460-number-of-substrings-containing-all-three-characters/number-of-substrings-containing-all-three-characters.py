class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        n=len(s)

        mp={}
        res=0
        i, j = 0, 0
        while j<n:
            mp[s[j]]=mp.get(s[j], 0)+1
            while len(mp) ==  3:
                res += (n-j)
                mp[s[i]] -= 1

                if mp[s[i]] == 0:
                    del mp[s[i]]

                i+=1
            j+=1

        return res