class MinStack {
    Stack<Pair<Integer,Integer>> st=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair<>(val,val));
        }else{
            int minValue=Math.min(val,st.peek().getValue());
            st.push(new Pair<>(val,minValue));
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
        
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek().getKey();
        }
        return -1;
    }
    
    public int getMin() {
        if(!st.isEmpty()){
            return st.peek().getValue();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 