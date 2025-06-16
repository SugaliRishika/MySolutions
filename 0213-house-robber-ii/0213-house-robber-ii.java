import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int max1 = robLinear(Arrays.copyOfRange(nums, 0, n - 1));
        int max2 = robLinear(Arrays.copyOfRange(nums, 1, n));

        return Math.max(max1, max2);
    }

    private int robLinear(int[] nums) {
        int prev = 0;
        int prev2 = 0;

        for (int num : nums) {
            int take = num + prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
