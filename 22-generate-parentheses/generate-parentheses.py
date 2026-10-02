class Solution:
    def solve(self, str, open, close, temp):
        if open == 0 and close == 0:
            temp.append("".join(str))
            return

        if open>0:
            str.append('(')
            self.solve(str, open-1, close, temp)
            str.pop()
        
        if open<close:
            str.append(')')
            self.solve(str, open, close-1, temp)
            str.pop()

    
    def generateParenthesis(self, n: int) -> list[str]:
        res=[]
        str=[]
        self.solve(str, n, n, res)

        return res
