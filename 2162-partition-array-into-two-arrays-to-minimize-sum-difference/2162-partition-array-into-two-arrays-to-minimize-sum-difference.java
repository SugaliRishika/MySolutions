import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        List<List<Integer>> leftSums = generateSums(left);
        List<List<Integer>> rightSums = generateSums(right);

        int minDiff = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> list1 = leftSums.get(k);
            List<Integer> list2 = rightSums.get(n - k);
            Collections.sort(list2);

            for (int sum1 : list1) {
                int target = totalSum / 2 - sum1;

                int idx = Collections.binarySearch(list2, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < list2.size()) {
                    int sum2 = list2.get(idx);
                    int currSum = sum1 + sum2;
                    int diff = Math.abs(totalSum - 2 * currSum);
                    minDiff = Math.min(minDiff, diff);
                }
                if (idx > 0) {
                    int sum2 = list2.get(idx - 1);
                    int currSum = sum1 + sum2;
                    int diff = Math.abs(totalSum - 2 * currSum);
                    minDiff = Math.min(minDiff, diff);
                }
            }
        }
        return minDiff;
    }

    private List<List<Integer>> generateSums(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) result.add(new ArrayList<>());

        int total = 1 << n;
        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            int bits = Integer.bitCount(mask);
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) sum += nums[j];
            }
            result.get(bits).add(sum);
        }
        return result;
    }
}
