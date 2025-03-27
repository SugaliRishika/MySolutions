class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int cnt = 0;
        int ele = nums.get(0);
        int output=0;
        for(int i = 0; i<n; i++){
            if(cnt==0) {
                cnt=1;
                ele=nums.get(i);
            } else if (ele == nums.get(i)) cnt++;
            else cnt--;
        }

        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == ele) cnt1++;
        }
        if (cnt1 < (n / 2)) {
            return -1;
        } 
            int cnt2=0;
            for(int i = 0;i<n;i++){
            if(ele==nums.get(i)){
                
                cnt2++;
                int rightCount = cnt1 - cnt2;
            if (cnt2 * 2 > (i + 1) && rightCount * 2 > (n - i - 1)) {
                return i;
            }
            } 
            }
        
       return -1;

        
        

    }
}