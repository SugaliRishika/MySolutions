class Solution {
    public boolean canJump(int[] nums) {
        int max_Index=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int current=i+nums[i];
            if(i>max_Index){
                return false;
            }
            max_Index=Math.max(current,max_Index);
        }
        return true;
    }
}