class Solution:
    def evaluate(self, s: str, k: list[list[str]]) -> str:
        n=len(s)

        mp={}
        for x in k:
            mp[x[0]]=x[1]

        sb=[]
        i=0
        while i<n:
            if s[i] == '(':
                j=i+1
                while s[j] != ')':
                    j+=1

                key=s[i+1: j]
                sb.append(mp.get(key, "?"))
                i=j+1
            else:
                sb.append(s[i])
                i+=1

        return ''.join(sb)