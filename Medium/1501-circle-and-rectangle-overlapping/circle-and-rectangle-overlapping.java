class Solution{
    public boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2){
        
        int xi=Math.max(x1, Math.min(x2, x))-x;
        int yi=Math.max(y1, Math.min(y2, y))-y;
        return (xi*xi)+(yi*yi)<=(long)(r*r);


    }
}