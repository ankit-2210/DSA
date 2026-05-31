class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;

        long ms=mass;
        Arrays.sort(asteroids);
        for(int a: asteroids){
            if(ms<a)
                return false;

            ms += a;
        }

        return true;
    }
}