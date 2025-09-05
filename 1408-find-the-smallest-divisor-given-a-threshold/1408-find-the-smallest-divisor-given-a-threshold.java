class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // int low=1;
        // int high=maxElement(nums);
        // int ans=-1;
        // while(low<=high){
        //     int mid=low+(high-low)/2;
        //     int operation=func(nums,mid,threshold);
        //     if(operation<=threshold){
        //         ans=mid;
        //         high=mid-1;
        //     }else{
        //         low=mid+1;
        //     }
        // }
        // return ans;

        int low=-1;
        int high=maxEle(nums);
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int n=cal_sum(nums,threshold,mid);
            if(n<=threshold){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int cal_sum(int[] nums,int threshold,int mid){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/(double)mid);
        }
        return sum;
    }


    public int maxEle(int[] nums){
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(nums[i],maxi);
        }
        return maxi;
    }
    // public int func(int[] nums,int mid, int threshold){
    //     int ans=-1;
    //     int sum=0;
    //     for(int i=0;i<=nums.length-1;i++){
    //         sum+=Math.ceil((double)nums[i]/(double)mid);
    //     }
    //     return sum;
    // }
    // public int maxElement(int[] nums){
    //     int maxi=0;
    //     for(int i=0;i<=nums.length-1;i++){
    //         maxi=Math.max(maxi,nums[i]);
    //     }
    //     return maxi;
    // }
}