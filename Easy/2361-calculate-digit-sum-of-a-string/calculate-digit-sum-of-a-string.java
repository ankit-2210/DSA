class Solution{
    public String digitSum(String s, int k){
        int n=s.length();

        while(s.length()>k){
            StringBuilder str=new StringBuilder();
            int i=0;
            while(i<s.length()){
                int sum=0;
                for(int j=i; j<s.length() && j<i+k; j++){
                    sum += (s.charAt(j)-'0');
                }

                str.append(sum);
                i+=k;
            }

            s=str.toString();
        }

        return s;
    }
}