
// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int fi=first(nums,target);
//         int la=last(nums,target);
//         return new int[]{fi,la};
//     }
//     public int first(int[] nums, int target) {
//         int low=0;
//         int n=nums.length;
//         int high=n-1;
//         int first=-1;
//         while(low<=high){
//             int mid=(low+high)/2;
//             if(nums[mid]==target){
//                 first=mid;
//                 high=mid-1;
//             }else if(nums[mid]<target){
//                 low=mid+1;
//             }else{
//                 high=mid-1;
//             }
//         }
//         return first;
//     }
//     public int last(int[] nums, int target) {
//         int low=0;
//         int n=nums.length;
//         int high=n-1;
//         int last=-1;
//         while(low<=high){
//             int mid=(low+high)/2;
//             if(nums[mid]==target){
//                 last=mid;
//                 low=mid+1;
//             }else if(nums[mid]>target){
//                 high=mid-1;
//             }else{
//                 low=mid+1;
//             }
//         }
//         return last;
//     }
// }




class Solution {
   public int[] searchRange(int[] nums, int target) {
        int starting=finding_start(nums,target);
        int ending=finding_second(nums,target);
        return new int[]{starting,ending};
    }
    public int finding_start(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int first=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return first;
    }

    public int finding_second(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int second=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                second=mid;
                low=mid+1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return second;
    }
}
