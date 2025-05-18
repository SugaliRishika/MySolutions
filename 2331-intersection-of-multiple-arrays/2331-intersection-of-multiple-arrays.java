class Solution {
    public List<Integer> intersection(int[][] nums) {
         Map<Integer, Integer> countMap = new HashMap<>();
        int totalArrays = nums.length;

        for (int[] arr : nums) {
            Set<Integer> unique = new HashSet<>();
            for (int num : arr) {
                unique.add(num);
            }
            for (int num : unique) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == totalArrays) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result); 
        return result;
    }
}
