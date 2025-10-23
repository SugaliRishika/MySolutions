class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,0,0,target);
    }

    public int dfs(int[] nums,int index,int currsum,int target){
        if(index==nums.length){
            return currsum==target?1:0;
        }

        int add=dfs(nums,index+1,currsum+nums[index],target);
        int sub=dfs(nums,index+1,currsum-nums[index],target);

        return add+sub;
    }
}