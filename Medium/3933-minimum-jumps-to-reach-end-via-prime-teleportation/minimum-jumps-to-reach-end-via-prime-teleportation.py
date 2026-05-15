class Solution:
    def minJumps(self, nums: List[int]) -> int:
        n=len(nums)
        if n == 1:
            return 0

        mx=max(nums)
        prime=list(range(mx+1))
        for i in range(2, int(mx**0.5)+1):
            if prime[i] == i:
                for j in range(i*i, mx+1, i):
                    prime[j]=i
                
        mp=defaultdict(list)
        for i in range(n):
            x=nums[i]
            st=set()
            while x>1:
                t=prime[x]
                if t not in st:
                    mp[t].append(i)
                    st.add(t)
                x//=t

        visited=[False]*n
        q=deque()
        visited[0]=True
        q.append((0, 0))
        while q:
            idx, steps=q.popleft()
            if idx == n-1:
                return steps

            if idx-1>=0 and not visited[idx-1]:
                q.append((idx-1, steps+1))
                visited[idx-1]=True
            if idx+1<n and not visited[idx+1]:
                q.append((idx+1, steps+1))
                visited[idx+1]=True

            if nums[idx]>1 and prime[nums[idx]] == nums[idx]:
                for it in mp[nums[idx]]:
                    if not visited[it]:
                        q.append((it, steps+1))
                        visited[it]=True
                mp[nums[idx]].clear()

        return -1