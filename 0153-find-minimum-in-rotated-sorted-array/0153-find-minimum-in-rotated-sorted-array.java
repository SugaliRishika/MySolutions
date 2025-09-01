class Solution {
    public int findMin(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }

            if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }else if(nums[mid]<=nums[high]){
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }else{
                return -1;
            }
        }
        return ans;
















        // int low=0;
        // int n=nums.length;
        // int high=n-1;
        // int least=Integer.MAX_VALUE;
        // while(low<=high){
        //     int mid=(low+high)/2;
        //     if(nums[low]<=nums[high]){
        //         least=Math.min(least,nums[low]);
        //         break;
        //     }
        //     if(nums[low]<=nums[mid]){ //left sorted
        //     least=Math.min(least,nums[low]);
        //     low=mid+1;
        //     }else if(nums[mid]<=nums[high]){ //right sorted
        //     least=Math.min(least,nums[mid]);
        //     high=mid-1;
        //     }
        //     else{
        //     return -1;
        //     }
        // }
        // return least;
    }
}