class Solution:
    def numOfStrings(self, p: List[str], w: str) -> int:
        n=len(p)

        res=0
        for it in p:
            if it in w:
                res+=1


        return res