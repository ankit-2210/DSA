class Solution:
    def sumAndMultiply(self, n: int) -> int:
        sum=0
        num=0
        mul=1
        while n>0:
            rem=n%10
            n //= 10

            if rem != 0:
                num=rem*mul+num
                sum += rem
                mul *= 10
            
        return sum*num

