class Solution:
    def checkString(self, s: str) -> bool:
        n=len(s)

        flag=False
        for ch in s:
            if ch == 'a' and flag == True:
                return False
            elif ch == 'b':
                flag=True

        return True