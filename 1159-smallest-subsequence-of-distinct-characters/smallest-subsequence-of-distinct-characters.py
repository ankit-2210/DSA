class Solution:
    def smallestSubsequence(self, s: str) -> str:
        n=len(s)

        st=[]
        visited=set()
        mp={}

        for ch in s:
            mp[ch]=mp.get(ch, 0)+1

        for ch in s:
            mp[ch] -= 1

            if ch in visited:
                continue;

            while st and st[-1]>ch and mp[st[-1]]>0:
                visited.remove(st.pop())

            st.append(ch)
            visited.add(ch)

        
        return "".join(st)