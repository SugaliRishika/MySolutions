class Solution {
    public int maxDistinctElements(int[] nums, int k) {
         Arrays.sort(nums);

        int curr = Integer.MIN_VALUE; 
        int count = 0;

        for (int num : nums) {

            int assign = Math.max(curr, num - k);
            if (assign <= num + k) {
                count++;         
                curr = assign + 1; 
            }
        }

        return count; 
    }
}