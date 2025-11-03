class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int total_time=0;
        int n=colors.length();
        for(int i=1;i<n;i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                total_time+=Math.min(neededTime[i],neededTime[i-1]);
                neededTime[i]=Math.max(neededTime[i],neededTime[i-1]);
            }
        }
        return total_time;
    }
}