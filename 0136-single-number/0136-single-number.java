class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int xor=0;
        for(int i=0;i<n;i++){
            xor=xor ^ nums[i];
        }
        return xor;
        // HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // int n=nums.length;
        // for (int i=0;i<n;i++) {
        //     frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        // }
        // final int[] uniqueElement = new int[1];
        // frequencyMap.forEach((key, value) -> {
        //     if (value == 1) {
        //         uniqueElement[0] = key;
        //     }
        // });
        // return uniqueElement[0];
    }
}