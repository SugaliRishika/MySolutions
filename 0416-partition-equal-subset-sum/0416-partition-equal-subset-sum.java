class Solution {
    public boolean canPartition(int[] nums) {
        int tot_sum=0;

        for(int i=0;i<nums.length;i++){
            tot_sum+=nums[i];
        }

        if(tot_sum%2==1)
            return false;
        else{
            int k=tot_sum/2;

            boolean[][] dp=new boolean[nums.length][k+1];
            for(int i=0;i<nums.length;i++){
                dp[i][0]=true;
            }

            if(nums[0]<=k){
                dp[0][nums[0]]=true;
            }

            for(int idx=1;idx<nums.length;idx++){
                for(int target=1;target<=k;target++){
                    boolean notTaken=dp[idx-1][target];

                    boolean taken=false;
                    if(nums[idx]<=target){
                        taken=dp[idx-1][target-nums[idx]];
                    }
                    dp[idx][target]=notTaken || taken;
                }
            }
            return dp[nums.length-1][k];
        }
    }
}