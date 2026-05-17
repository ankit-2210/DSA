class Solution:
    def countLocalMaximums(self, mat: List[List[int]]) -> int:
        n=len(mat)
        m=len(mat[0])

        pos=[[] for _ in range(201)]
        for i in range(n):
            for j in range(m):
                    pos[mat[i][j]].append((i, j))

        res=0
        for i in range(n):
            for j in range(m):
                x=mat[i][j]
                if x == 0:
                    continue

                flag=True
                for val in range(x+1, 201):
                    if not flag:
                        break
                    for r, c in pos[val]:
                        dir=abs(r-i)
                        dic=abs(c-j)

                        if dir<=x and dic<=x:
                            if dir == x and dic == x:
                                continue;
                            flag=False;
                            break
                    
                if flag:
                    res+=1
            
        return res