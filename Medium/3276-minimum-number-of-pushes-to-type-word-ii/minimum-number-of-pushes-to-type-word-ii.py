class Solution:
    def minimumPushes(self, w: str) -> int:
        n=len(w)

        mp=[0]*26
        for ch in w:
            idx=ord(ch)-ord('a')
            mp[idx]+=1

        sortc=sorted(mp, reverse=True)
        
        res=0
        for idx, count in enumerate(sortc):
            if count == 0:
                break
            res += (idx//8+1)*count

        return res

