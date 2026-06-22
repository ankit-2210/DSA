class Solution:
    def maxNumberOfBalloons(self, t: str) -> int:
        n=len(t)

        mp={}
        for ch in t:
            if ch in "balon":
                mp[ch]=mp.get(ch, 0)+1

        if len(mp)<5:
            return 0

        res=float('inf')
        for ch in "balon":
            if ch in "ban":
                res=min(res, mp[ch])
            else:   
                res=min(res, mp[ch]//2)

        return res
