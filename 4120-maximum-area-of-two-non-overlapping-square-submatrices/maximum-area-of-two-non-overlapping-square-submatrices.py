class Solution:
    def solve(self, mat, prefix, mid, n, m):
        rows=n-mid+1
        cols=m-mid+1

        visited=[[False]*(cols) for _ in range(rows)]
        row=[0]*(rows)
        col=[0]*(cols)
        for i in range(rows):
            for j in range(cols):
                sum=prefix[i+mid][j+mid]-prefix[i][j+mid]-prefix[i+mid][j]+prefix[i][j]

                if sum == mid*mid:
                    visited[i][j]=True
                    row[i]+=1
                    col[j]+=1
            

        rowP=[0]*(rows+1)
        colP=[0]*(cols+1)

        for i in range(1, rows):
            rowP[i]=rowP[i-1]+row[i-1]
        
        for i in range(1, cols):
            colP[i]=colP[i-1]+col[i-1];


        for i in range(rows):
            for j in range(cols):
                if visited[i][j] == False:
                    continue

                a=i-mid
                if a>=0 and rowP[a+1]>0:
                    return True

                b=j-mid
                if b>=0 and colP[b+1]>0:
                    return True
        
        return False

    def maxArea(self, mat: List[List[int]]) -> int:
        n=len(mat)
        m=len(mat[0])

        prefix=[[0]*(m+1) for _ in range(n+1)]
        for i in range(n):
            for j in range(m):
                prefix[i+1][j+1]=mat[i][j]+prefix[i+1][j]+prefix[i][j+1]-prefix[i][j]

        low=1
        high=min(n, m)
        res=0
        while low<=high:
            mid=(low+high)//2
            if self.solve(mat, prefix, mid, n, m):
                res=mid
                low=mid+1
            else:
                high=mid-1
            
        return res*res