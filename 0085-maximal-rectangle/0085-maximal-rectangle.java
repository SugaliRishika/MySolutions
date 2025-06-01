class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[] heights=new int[cols];
        int maxArea=0;
       for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    heights[j]+=1;
                }else{
                    heights[j]=0;
                }
            }
            maxArea=Math.max(maxArea,calculating_area(heights));
        }
        return maxArea;
    }
    public int calculating_area(int[] heights){
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                int width=nse-pse-1;
                int area=heights[element]*width;
                maxArea=Math.max(maxArea,area);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int element=st.pop();
            int nse=heights.length;
            int pse=st.isEmpty()?-1:st.peek();
            int width=nse-pse-1;
            int area=heights[element]*width;
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}