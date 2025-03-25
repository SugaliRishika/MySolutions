// import java.util.*;

// class Solution {
//     public int countDays(int days, int[][] meetings) {
//         boolean[] visited=new boolean[days];
//         for(int[] num:meetings){
//         for(int j=num[0];j<=num[1];j++){
//             visited[j-1]=true;
//         }
//        }
//        int count=0;
//        for(boolean day:visited){
//         if(!day) count++;
//        }
//        return count;
//     }
// }

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int unvisited=0;
        int temp=1;
        for(int[] m:meetings){
            unvisited=unvisited+Math.max(0,m[0]-temp);
            temp=Math.max(temp,m[1]+1);
            if(temp>days){
                break;
            }
        }
        return unvisited+Math.max(0,days-temp+1);
    }
}