class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int low=1;
        // int result=-1;
        // int high=maxElement(piles);
        // while(low<=high){
        //     int mid=(low+high)/2;
        //     int summ=func(piles,mid);
        //     if(summ<=h){
        //         result=mid;
        //         high=mid-1;
        //     }else{
        //         low=mid+1;
        //     }
        // }
        // return result;


        int low=1;
        int high=maxi(piles);
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;

            int result=satisfy(piles,mid);

            if(result<=h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int satisfy(int[] piles,int mid){
        int ans=0;
        for(int i=0;i<piles.length;i++){
            ans+=Math.ceil((double)piles[i]/(double)mid);
        } 
        return ans;
    }

    public int maxi(int[] piles){
        int maxi=0;
        for(int i=0;i<piles.length;i++){
            maxi=Math.max(maxi,piles[i]);
        }
        return maxi;
    }
    // public int func(int[] piles, int mid){
    //     int ans=0;
    //     for(int i=0;i<piles.length;i++){
    //         ans+=Math.ceil((double)piles[i]/(double)mid);
    //     }
    //     return ans;
    // }
    // public int maxElement(int[] piles){
    //     int maxi=0;
    //     for(int i=0;i<piles.length;i++){
    //         maxi=Math.max(maxi,piles[i]);
    //     }
    //     return maxi;
    // }
}