class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gain=0;
        int total_fuel=0;
        int curr_fuel=0;
        int start_index=0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            gain=gas[i]-cost[i];
            total_fuel=total_fuel+gain;
            curr_fuel=curr_fuel+gain;
            if(curr_fuel<0){
                curr_fuel=0;
                start_index=i+1;
            }
        }
        return total_fuel>=0?start_index:-1;
    }
}