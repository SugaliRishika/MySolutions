class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        Integer[][] dp=new Integer[n][m];
        return lcs(0,0,text1,text2,dp);
    }

    private int lcs(int i,int j,String s1,String s2,Integer[][] dp){
        if(i==s1.length() || j==s2.length()) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j]=1+lcs(i+1,j+1,s1,s2,dp);
        }else{
            dp[i][j]=Math.max(lcs(i+1,j,s1,s2,dp),lcs(i,j+1,s1,s2,dp));
        }
        return dp[i][j];
    }
}