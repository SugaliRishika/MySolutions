// class Solution {
//     public int minBitFlips(int start, int goal) {
//         int count=0;
//         while(start>0 || goal>0){
//             if((start&1)!=(goal&1)){
//                 count++;
//             }
//             start>>=1;
//             goal>>=1;
//         }
//         return count;
//     }
// }

class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        int result=start^goal;
        while(result!=0){
            count=count+(result&1);
            result>>=1;
        }
        return count;
    }
}
