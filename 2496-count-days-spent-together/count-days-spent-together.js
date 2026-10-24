/**
 * @param {string} arriveAlice
 * @param {string} leaveAlice
 * @param {string} arriveBob
 * @param {string} leaveBob
 * @return {number}
 */
var countDaysTogether = function(aa, la, ab, lb) {
        
        const prefix=new Array(13).fill(0);
        const days=[0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

        for(let i=1; i<13; i++){
            prefix[i]=prefix[i-1]+days[i-1];
        }

        const getDays=(dateStr) => {
            const month = parseInt(dateStr.substring(0, 2), 10);
            const day = parseInt(dateStr.substring(3, 5), 10);
            return prefix[month] + day;
        };

        alicestart=getDays(aa);
        aliceend=getDays(la);

        bobstart=getDays(ab);
        bobend=getDays(lb);

        if(bobstart>aliceend || alicestart>bobend)
            return 0;

        const start=(alicestart<bobstart)?bobstart:alicestart;
        const end=(aliceend<bobend)?aliceend:bobend;

        return end-start+1;
};