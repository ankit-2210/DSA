class Solution:
    def findThePrefixCommonArray(self, a: List[int], b: List[int]) -> List[int]:
        n=len(a)
        m=len(b)

        prefix=[0]*n
        c=0
        mp={}
        for i in range(n):
            if a[i] == b[i]:
                mp[a[i]]=mp.get(a[i], 0)+2
                c+=1
            else:
                mp[a[i]]=mp.get(a[i], 0)+1
                mp[b[i]]=mp.get(b[i], 0)+1
                if mp[a[i]] == 2:
                    c+=1
                if mp[b[i]] == 2:
                    c+=1
            prefix[i]=c

        return prefix