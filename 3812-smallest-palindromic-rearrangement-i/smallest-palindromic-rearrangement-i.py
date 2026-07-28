class Solution:
    def smallestPalindrome(self, s: str) -> str:
        n=len(s)

        freq=[0]*26
        for ch in s:
            freq[ord(ch)-ord('a')]+=1
            

        res=['']*n
        left, right=0, n-1
        i=0;
        while i<26 and left<=right:
            while freq[i]>=2:
                res[left]=(chr)(i+ord('a'))
                res[right]=(chr)(i+ord('a'))
                freq[i]-=2
                left += 1
                right -= 1
            
            if freq[i] == 1:
                res[n//2]=(chr)(i+ord('a'))
                freq[i]=0
            
            i+=1
    

        return ''.join(res)