class Solution:
    def maxNumOfSubstrings(self, s: str) -> list[str]:
        n=len(s)

        start=[-1]*26
        end=[-1]*26

        for i, ch in enumerate(s):
            idx=ord(ch)-ord('a')

            if start[idx] == -1:
                start[idx]=i

            end[idx]=i


        isValid=[False]*26
        for c in range(26):
            if start[c] == -1:
                continue

            isValid[c]=True
            i=start[c]

            while i<=end[c]:
                idx=ord(s[i])-ord('a')
                if start[idx]<start[c]:
                    isValid[c]=False
                    break

                end[c]=max(end[c], end[idx])
                i += 1


        res=[]
        last=n
        for i in range(n-1, -1, -1):
            idx=ord(s[i])-ord('a')

            if isValid[idx] and i == start[idx] and end[idx]<last:
                res.append(s[i:end[idx]+1])
                last=i

        return res