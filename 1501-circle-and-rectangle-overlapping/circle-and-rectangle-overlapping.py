class Solution:
    def checkOverlap(self, r: int, x: int, y: int, x1: int, y1: int, x2: int, y2: int) -> bool:
        xi=max(x1, min(x2, x))-x
        yi=max(y1, min(y2, y))-y
        
        return (xi*xi)+(yi*yi)<=(r*r)