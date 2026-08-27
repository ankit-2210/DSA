class Solution:
    def solve(self, freq):
        str=""
        for i in range(26):
            for _ in range(freq[i]):
                str += chr(ord('a')+i)

        return str;
    
    def lexGreaterPermutation(self, s: str, t: str) -> str:
        n=len(s)

        freq=[0]*26
        for ch in s:
            freq[ord(ch)-ord('a')]+=1

        res=""
        prefix=""
        for ch in t:
            for c in range(ord(ch)+1, ord('z')+1):
                if freq[c-ord('a')]>0:
                    freq[c-ord('a')]-=1

                    suffix=self.solve(freq)
                    str=prefix+chr(c)+suffix

                    if res == "" or str<res:
                        res=str
                    
                    freq[c-ord('a')]+=1
                    break
                

            if freq[ord(ch)-ord('a')] == 0:
                return res

            freq[ord(ch)-ord('a')]-=1
            prefix += ch
        
        return res
