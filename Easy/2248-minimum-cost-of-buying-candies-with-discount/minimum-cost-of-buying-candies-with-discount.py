class Solution:
    def minimumCost(self, c: List[int]) -> int:
        n=len(c)

        c.sort(reverse=True)
        sum=0
        i=0
        while i<n:
            sum += c[i]
            if i+1<n:
                sum += c[i+1]

            i+=3
    
        return sum
