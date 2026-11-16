class Solution:
    def digitSum(self, s: str, k: int) -> str:
        n=len(s)

        while len(s)>k:
            res=[]
            i=0
            while i<len(s):
                total=0
                for j in range(i, min(len(s), i+k)):
                    total += int(s[j])

                res.append(str(total))
                i+=k

            s="".join(res)

        return s

