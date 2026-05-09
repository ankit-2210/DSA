class Solution:
    def rotateGrid(self, mat: List[List[int]], k: int) -> List[List[int]]:
        n=len(mat)
        m=len(mat[0])

        layers=min(n, m)//2
        for l in range(layers):
            vals=[]
            top, bottom=l, n-l-1;
            left, right=l, m-l-1;
            for i in range(left, right):
                vals.append(mat[top][i])
            for i in range(top, bottom):
                vals.append(mat[i][right])
            for i in range(right, left, -1):
                vals.append(mat[bottom][i])
            for i in range(bottom, top, -1):
                vals.append(mat[i][left])

            shift=k%len(vals)
            vals=vals[shift:]+vals[:shift]
            idx=0
            for i in range(left, right):
                mat[top][i]=vals[idx]
                idx+=1
            for i in range(top, bottom):
                mat[i][right]=vals[idx]
                idx+=1
            for i in range(right, left, -1):
                mat[bottom][i]=vals[idx]
                idx+=1
            for i in range(bottom, top, -1):
                mat[i][left]=vals[idx]
                idx+=1

        return mat