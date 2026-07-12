class Solution{
    public int[] arrayRankTransform(int[] arr){
        int n=arr.length;

        ArrayList<Integer> temp=new ArrayList<>();
        HashMap<Integer, Integer> mp=new HashMap<>();

        for(int a: arr){
            if(!mp.containsKey(a)){
                temp.add(a);
                mp.put(a, 0);
            }
        }

        Collections.sort(temp);

        for(int i=0; i<temp.size(); i++){
            mp.put(temp.get(i), i+1);
        }

        for(int i=0; i<n; i++){
            arr[i]=mp.get(arr[i]);
        }

        return arr;
    }
}