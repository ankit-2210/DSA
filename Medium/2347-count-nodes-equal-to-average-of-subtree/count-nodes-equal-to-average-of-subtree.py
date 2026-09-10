# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def solve(self, root, count, res):
        if root is None:
            return 0

        lcount=[0]
        rcount=[0]
        lsum=self.solve(root.left, lcount, res)
        rsum=self.solve(root.right, rcount, res)

        sum=root.val+lsum+rsum
        count[0]=1+lcount[0]+rcount[0]

        if root.val == sum//count[0]:
            res[0] += 1

        return sum
    
    def averageOfSubtree(self, root: TreeNode) -> int:
        res=[0]
        count=[0]

        self.solve(root, count, res)
        return res[0]