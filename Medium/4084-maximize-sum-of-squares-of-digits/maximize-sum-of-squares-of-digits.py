class Solution:
    def maxSumOfSquares(self, num: int, sum: int) -> str:
        if sum>9*num:
            return ""

        qt=sum//9
        rem=sum%9

        res=[]
        for i in range(qt):
            res.append('9')
        
        if rem>0:
            res.append(str(rem))

        for i in range(qt+(1 if rem>0 else 0), num):
            res.append('0')

        return ''.join(res)