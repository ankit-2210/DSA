class Solution:
    def solve(self, idx, arr, visited, n):
        if idx<0 or idx>=n:
            return False

        if arr[idx] == 0:
            return True

        if visited[idx] is True:
            return False

        visited[idx]=True
        left=self.solve(idx-arr[idx], arr, visited, n)
        right=self.solve(idx+arr[idx], arr, visited, n)
        return left or right
    
    def canReach(self, arr: List[int], start: int) -> bool:
        n=len(arr)

        visited=[False]*n
        return self.solve(start, arr, visited, n)

