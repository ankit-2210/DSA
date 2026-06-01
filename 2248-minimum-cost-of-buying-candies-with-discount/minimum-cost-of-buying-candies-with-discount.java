class Solution{
    public int minimumCost(int[] cost){
        int n=cost.length;;

        Integer[] c=Arrays.stream(cost)
                            .boxed()
                            .sorted(Collections.reverseOrder())
                            .toArray(Integer[]::new);
        int sum=0;
        int i=0;
        while(i<n){
            sum += c[i];
            if(i+1<n){
                sum += c[i+1];
            }

            i+=3;
        }

        return sum;
    }
}