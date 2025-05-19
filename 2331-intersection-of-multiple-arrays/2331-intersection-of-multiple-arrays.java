// class Solution {
//     public List<Integer> intersection(int[][] nums) {
//          Map<Integer, Integer> countMap = new HashMap<>();
//         int totalArrays = nums.length;

//         for (int[] arr : nums) {
//             Set<Integer> unique = new HashSet<>();
//             for (int num : arr) {
//                 unique.add(num);
//             }
//             for (int num : unique) {
//                 countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//             }
//         }

//         List<Integer> result = new ArrayList<>();
//         for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//             if (entry.getValue() == totalArrays) {
//                 result.add(entry.getKey());
//             }
//         }

//         Collections.sort(result); 
//         return result;
//     }
// }


class Solution {
    public List<Integer> intersection(int[][] nums) {
        int num_of_arrays=nums.length;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<num_of_arrays;i++){
            for(int j=0;j<nums[i].length;j++){
                int value=nums[i][j];
                mpp.put(value,mpp.getOrDefault(value,0)+1);
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            if(entry.getValue()==num_of_arrays){
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    } 
}
