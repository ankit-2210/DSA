class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        n=len(arr)

        temp=[]
        mp={}
       
        for a in arr:
            if a not in mp:
                temp.append(a)
                mp[a]=0

        temp.sort()

        for i, num in enumerate(temp):
            mp[num]=i+1

        return [mp[a] for a in arr]