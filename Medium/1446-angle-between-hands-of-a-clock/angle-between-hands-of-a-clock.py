class Solution:
    def angleClock(self, hr: int, m: int) -> float:
        hour = 30*hr+0.5*m
        minute = 6*m

        angle=abs(hour-minute)
        if angle>180:
            angle=360-angle
        
        return angle