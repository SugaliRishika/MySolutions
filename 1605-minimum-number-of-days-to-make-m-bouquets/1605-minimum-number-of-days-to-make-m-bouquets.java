class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // long val=(long)m*k;
        // if(bloomDay.length<val){
        //     return -1;
        // }
        // int low=minElement(bloomDay);
        // int high=maxElement(bloomDay); 
        // int ans=0;  
        // while(low<=high){
        //     int mid=low+(high-low)/2;
        //     int midN=can_make_bouteq(bloomDay,m,k,mid);
        //     if(midN>=m){
        //         ans=mid;
        //         high=mid-1;
        //     }else{
        //         low=mid+1;
        //     }
        // }
        // return ans;

        long val=(long)m*k;
        if(val>bloomDay.length){
            return -1;
        }

        int low=minEle(bloomDay);
        int high=maxEle(bloomDay);
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;

            int n=can_make_bouteq(bloomDay,m,k,mid);
            if(n>=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int can_make_bouteq(int[] bloomDay,int m,int k,int mid){
        int count=0;
        int num_of_bouteq=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                count++;
            }else{
                num_of_bouteq+=count/k;
                count=0;
            }
        }
        num_of_bouteq+=(count/k);
        return num_of_bouteq;
    }


    public int minEle(int[] bloomDay){
        int mini=0;
        for(int i=0;i<bloomDay.length;i++){
            mini=Math.min(mini,bloomDay[i]);
        }
        return mini;
    }

    public int maxEle(int[] bloomDay){
        int maxi=0;
        for(int i=0;i<bloomDay.length;i++){
            maxi=Math.max(maxi,bloomDay[i]);
        }
        return maxi;
    }

    // public int can_make_bouteq(int[] bloomDay,int m, int k,int mid){
    //     int count=0;
    //     int num_of_boq=0;
    //     for(int i=0;i<bloomDay.length;i++){
    //         if(bloomDay[i]<=mid){
    //             count++;
    //         }else{
    //             num_of_boq+=(count/k);
    //             count=0;
    //         }
    //     }
    //     num_of_boq+=(count/k);
    //     return num_of_boq;
    // }
    // public int maxElement(int[] bloomDay){
    //     int maxi=0;
    //     for(int i=0;i<=bloomDay.length-1;i++){
    //         maxi=Math.max(maxi,bloomDay[i]);
    //     }
    //     return maxi;
    // }
    // public int minElement(int[] bloomDay) {
    //     int mini = bloomDay[0];
    //     for (int i = 1; i < bloomDay.length; i++) {
    //         mini = Math.min(mini, bloomDay[i]);
    //     }
    //     return mini;
    // }
}