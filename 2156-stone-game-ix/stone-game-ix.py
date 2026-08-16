class Solution:
    def stoneGameIX(self, s: List[int]) -> bool:
        n=len(s)

        count=[0]*3
        for i in range(n):
            rem=s[i]%3
            count[rem]+=1

        if count[0]%2 == 0:
            if count[1]>0 and count[2]>0:
                return True
            else:
                return False
        
        if abs(count[1]-count[2])>2:
            return True

        return False

