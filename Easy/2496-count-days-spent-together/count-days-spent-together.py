class Solution:
    def countDaysTogether(self, aa: str, la: str, ab: str, lb: str) -> int:
        
        prefix=[0]*13
        days=[0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

        prefix[0]=0
        for i in range(1, 13):
            prefix[i]=prefix[i-1]+days[i-1]

        def getdayofyear(date_str: str) -> int:
            month=int(date_str[0:2])
            day=int(date_str[3:5])
            return prefix[month]+day


        alicestart = getdayofyear(aa)
        aliceend = getdayofyear(la)

        bobstart = getdayofyear(ab)
        bobend = getdayofyear(lb)

        if bobstart>aliceend or alicestart>bobend:
            return 0

        start=max(alicestart, bobstart)
        end=min(aliceend, bobend)

        return end-start+1