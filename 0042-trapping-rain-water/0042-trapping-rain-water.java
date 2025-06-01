class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int leftMax=0;
        int rightMax=0;
        int total=0;
        int leftptr=0;
        int rightptr=n-1;
        while(leftptr<rightptr){
            if(height[leftptr]<=height[rightptr]){
                if(leftMax>height[leftptr]){
                    total=total+(leftMax-height[leftptr]);
                }else{
                    leftMax=height[leftptr];
                }
                leftptr=leftptr+1;
            }else{
                if(rightMax>height[rightptr]){
                    total=total+(rightMax-height[rightptr]);
                }else{
                    rightMax=height[rightptr];
                }
                rightptr=rightptr-1;
            }  
        }
        return total;
    }
}