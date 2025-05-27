class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generating(n,0,0,result,"");
        return result;
    }

    public void generating(int n,int opening,int closing,List<String> result,String s){
        if(opening+closing==n*2 && opening==closing){
            result.add(s);
            return;
        }
        if(opening<n){
            generating(n,opening+1,closing,result,s+"(");
        }
        if(closing<opening){
            generating(n,opening,closing+1,result,s+")");
        }

    }      
}