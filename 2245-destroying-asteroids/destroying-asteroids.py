class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        n=len(asteroids)

        ms=mass
        asteroids.sort();
        for a in asteroids:
            if ms<a:
                return False

            ms += a

        return True