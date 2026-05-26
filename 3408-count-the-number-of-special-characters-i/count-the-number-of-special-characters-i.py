class Solution:
    def numberOfSpecialChars(self, w: str) -> int:
        lower=[0]*26
        upper=[0]*26

        for ch in w:
            if ch.islower():
                lower[ord(ch)-ord('a')] += 1
            else:
                upper[ord(ch)-ord('A')] += 1

        res=0
        for i in range(26):
            if lower[i]>0 and upper[i]>0:
                res+=1

        return res
        