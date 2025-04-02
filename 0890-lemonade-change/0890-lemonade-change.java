class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five_count=0;
        int ten_count=0;
        int twty_count=0;
        int n=bills.length;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                five_count++;
            }
            else if(bills[i]==10){
                if(five_count==0){
                    return false;
                }
                ten_count++;
                five_count--;
            }
            else{
                if(ten_count>0 && five_count>0){
                    twty_count++;
                    ten_count--;
                    five_count--;
                }
                else if(five_count>=3){
                    twty_count++;
                    five_count-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}