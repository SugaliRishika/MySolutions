class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st=new HashSet<>();
        int left=0;
        int maxLen=0;
        for(int right=0;right<s.length();right++){
            if(!st.contains(s.charAt(right))){
                st.add(s.charAt(right));
                maxLen=Math.max(right-left+1,maxLen);
            }else{
                while(st.contains(s.charAt(right))){
                    st.remove(s.charAt(left));
                    left++;
                }
                st.add(s.charAt(right));
            }
        }
        return maxLen;
    }
}