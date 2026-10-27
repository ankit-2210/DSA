class Solution:
    def createGrid(self, n: int, m: int) -> list[str]:
        
        res=[]
        for i in range(n):
            temp=[]
            for j in range(m):
                if i == 0 or j == m-1:
                    temp.append('.')
                else:
                    temp.append('#')

            res.append("".join(temp))

        return res