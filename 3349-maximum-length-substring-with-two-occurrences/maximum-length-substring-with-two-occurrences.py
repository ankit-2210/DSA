class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        n=len(s)

        mp={}
        res=0
        i, j=0, 0

        while j<n:
            mp[s[j]] = mp.get(s[j], 0) + 1
            while mp[s[j]] > 2:
                mp[s[i]] -= 1
                i += 1

            res=max(res, j-i+1)
            j += 1

        return res
