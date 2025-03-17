class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int num:nums){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        for(int count:mpp.values()){
            if(count%2!=0){
                return false;
            }
        }
        return true;
    }
}