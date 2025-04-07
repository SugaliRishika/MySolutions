class Solution {
    public int candy(int[] ratings) {
        int i = 0;
        int sum = 0;
        int n = ratings.length;

        while (i < n) {
            int peak = 0, down = 0;
            while (i + 1 < n && ratings[i + 1] > ratings[i]) {
                peak++;
                i++;
            }
            while (i + 1 < n && ratings[i + 1] < ratings[i]) {
                down++;
                i++;
            }

            if (peak == 0 && down == 0) {
                sum += 1;
                i++;
            } else {
                sum += (peak * (peak + 1)) / 2 + (down * (down + 1)) / 2 + Math.max(peak, down);
            }
        }

        return sum;
    }
}
