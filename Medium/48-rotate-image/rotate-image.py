class Solution:
    def rotate(self, mat: List[List[int]]) -> None:
        n=len(mat)

        for i in range(n):
            for j in range(i, n):
                mat[i][j], mat[j][i] = mat[j][i], mat[i][j]

        for i in range(n):
            left, right = 0, n-1
            while left < right:
                mat[i][left], mat[i][right] = mat[i][right], mat[i][left]
                left += 1
                right -= 1
        
