class Solution{
    public double angleClock(int hr, int min){
        
        double hour = 30*hr+0.5*min;
        double minute = 6*min;

        double angle=Math.abs(hour-minute);
        if(angle>180){
            angle=360-angle;
        }

        return angle;


    }
}