class Solution:
    def sumGame(self, s: str) -> bool:
        n=len(s)

        leftsum, rightsum=0, 0
        qleft, qright=0, 0
        for i in range(n):
            if i<n//2:
                if s[i] == '?':
                    qleft+=1
                else:
                    leftsum += int(s[i])
            else:
                if s[i] == '?':
                    qright+=1
                else:
                    rightsum += int(s[i])

        if (qleft+qright)%2 != 0:
            return True

        diffsum=leftsum-rightsum
        qdiff=qright-qleft

        if diffsum != (qdiff//2)*9:
            return True

        return False