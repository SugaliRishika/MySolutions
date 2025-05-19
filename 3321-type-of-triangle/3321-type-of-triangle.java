class Solution {
    public String triangleType(int[] nums) {
        int i=nums[0];
        int j=nums[1];
        int k=nums[2];
        if (i + j <= k || j + k <= i || k + i <= j) {
            return "none"; 
        }
        if(i==j && j==k){
            return "equilateral";
        } else if (i == j || j == k || i == k) {
            return "isosceles";
        }
        return "scalene";
    }
}