class TrieNode:
    def __init__(self):
        self.children=[None]*10;
        self.count=0
        self.isEnd=False

class Solution:
    def __init__(self):
        self.root=TrieNode()

    def insert(self, num):
        pCrawl=self.root
        s=str(num)
        for ch in s:
            idx=ord(ch)-ord('0')
            if pCrawl.children[idx] is None:
                pCrawl.children[idx]=TrieNode()
            pCrawl.children[idx].count += 1
            pCrawl=pCrawl.children[idx]
        
        pCrawl.isEnd=True
    

    def search(self, num):
        pCrawl=self.root
        s=str(num)
        c=0
        for ch in s:
            idx=ord(ch)-ord('0')
            if pCrawl.children[idx] is None:
                return c
            pCrawl=pCrawl.children[idx]
            c+=1
        
        return c

    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:

        for num in arr1:
            self.insert(num)

        res=0
        for num in arr2:
            c=self.search(num)
            res=max(res, c)
        return res

