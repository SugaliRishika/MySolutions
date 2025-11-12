class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int m=nums1.length;
        int n=nums2.length;
        int low=0,high=m;

        while(low<=high){
            int x=(low+high)/2;
            int y=(m+n+1)/2-x;

            int leftmax=(x==0)?Integer.MIN_VALUE:nums1[x-1];
            int rightmin=(x==m)?Integer.MAX_VALUE:nums1[x];
            int maxleftY=(y==0)?Integer.MIN_VALUE:nums2[y-1];
            int minrightY=(y==n)?Integer.MAX_VALUE:nums2[y];

            if(leftmax<=minrightY && maxleftY<=rightmin){
                if((m+n)%2==0)
                    return (Math.max(leftmax,maxleftY)+Math.min(rightmin,minrightY))/2.0;
                else
                    return Math.max(leftmax,maxleftY);
            }else if(leftmax>minrightY){
                high=x-1;
            }else{
                low=x+1;
            }
        }
        return 0.0;
    }
}