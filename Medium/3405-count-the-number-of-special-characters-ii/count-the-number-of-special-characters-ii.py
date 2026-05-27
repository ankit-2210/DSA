class Solution:
    def numberOfSpecialChars(self, w: str) -> int:
        n=len(w)

        lower=[-1]*26
        upper=[-1]*26
        for i, ch in enumerate(w):
            if ch.islower():
                lower[ord(ch)-ord('a')]=i
            else:
                if upper[ord(ch)-ord('A')] == -1:
                    upper[ord(ch)-ord('A')]=i

        res=0
        for i in range(26):
            if lower[i] != -1 and lower[i]<upper[i]:
                res+=1

        return res