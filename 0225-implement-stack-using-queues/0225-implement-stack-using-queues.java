class MyStack {
    public Queue<Integer> queu;
    public MyStack() {
        queu=new LinkedList<>();
    }
    
    public void push(int x) {
        int n=queu.size();
        queu.add(x);
        for(int i=0;i<n;i++){
            queu.add(queu.poll());
        }
    }
    
    public int pop() {
        return queu.poll();
    }
    
    public int top() {
        return queu.peek();
    }
    
    public boolean empty() {
        return queu.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */