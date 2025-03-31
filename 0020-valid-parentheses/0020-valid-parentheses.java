class Solution {
    public boolean isValid(String s) {
        // Stack<Character> stack = new Stack<>();
        // Map<Character, Character> mapping = new HashMap<>();
        // mapping.put(')', '(');
        // mapping.put('}', '{');
        // mapping.put(']', '[');

        // for (char c : s.toCharArray()) {
        //     if (mapping.containsValue(c)) {
        //         stack.push(c);
        //     } else if (mapping.containsKey(c)) {
        //         if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
        //             return false;
        //         }
        //     }
        // }

        // return stack.isEmpty();  
        Stack<Character> st=new Stack<>();
        for(char it:s.toCharArray()){
            if(it=='('||it=='{'||it=='['){
                st.push(it);
            }else{
                if(st.isEmpty()) return false;
                char ch=st.pop();
                if((it==')' && ch=='(') || (it== '}' && ch=='{') || (it==']' && ch=='[')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}