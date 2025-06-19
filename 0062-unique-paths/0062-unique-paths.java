// class Solution {
//     public int func(int i,int j,int[][] dp){
//         if(i==0 && j==0){
//             return 1;
//         }
//         if(i<0 && j<0){
//             return 0;
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         int up=func(i-1,j,dp);
//         int left=func(i,j-1,dp);
//         return dp[i][j]=up+left;
//     }
//     public int uniquePaths(int m, int n) {
//         int[][] dp=new int[n][4];
//         for(int[] num:dp){
//             Arrays.fill(num,-1);
//         }
//         return func(m-1,n-1,dp);
//     }
// }


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j]=1;
                }else{
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}