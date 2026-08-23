class Solution{
    public boolean sumGame(String s){
        int n=s.length();

        int leftsum=0, rightsum=0;
        int qleft=0, qright=0;
        for(int i=0; i<n; i++){
            if(i<n/2){
                if(s.charAt(i) == '?')
                    qleft++;
                else
                    leftsum += (s.charAt(i)-'0');
            }
            else{
                if(s.charAt(i) == '?')
                    qright++;
                else
                    rightsum += (s.charAt(i)-'0');
            }   
        }

        if((qleft+qright)%2 != 0)
            return true;

        // System.out.println(leftsum + " " + rightsum + " " + qleft + " " + qright);

        int diffsum=leftsum-rightsum;
        int qdiff=qright-qleft;

        if(diffsum != (qdiff/2)*9)
            return true;

        return false;

    }
}