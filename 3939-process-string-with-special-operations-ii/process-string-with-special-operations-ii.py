class Solution:
    def processStr(self, s: str, k: int) -> str:
        # n=len(s)

        len=0
        for ch in s:
            if ch == '*':
                len -= 1
            elif ch == '#':
                len *= 2
            elif ch == '%':
                continue
            else:
                len+=1
            if len<0:
                len=0

        k+=1
        if k>len:
            return '.'

        s=s[::-1]
        for ch in s:
            if ch == '*':
                len+=1
            elif ch == '#':
                if k>(len//2):
                    k -= (len//2)
                len//=2
            elif ch == '%':
                k=(len-k+1)
            else:
                if k == len:
                    return ch
                len-=1
        
        return '.'