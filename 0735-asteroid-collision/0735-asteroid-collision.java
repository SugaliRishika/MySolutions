class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int asteroid:asteroids){
            boolean destroyed=false;
            while(!st.isEmpty() && asteroid<0 && st.peek()>0){
            if(st.peek() < -asteroid){
                st.pop();
                continue;
            }else if(st.peek()==-asteroid){
                st.pop();
                destroyed=true;
                break; 
            }else{
                destroyed=true;
                break;
            }
            }
            if(!destroyed){
                st.push(asteroid);
            }
        }
        
        int[] final_ans= new int[st.size()];
        int m=final_ans.length;
        for(int i=m-1;i>=0;i--){
            final_ans[i]=st.pop();
        }
        return final_ans;
    }
}

// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> stack = new Stack<>();

//         for (int asteroid : asteroids) {
//             boolean destroyed = false;

//             // Only check collision if asteroid is moving left (negative)
//             while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
//                 if (stack.peek() < -asteroid) {
//                     stack.pop(); // Top explodes, current asteroid keeps going
//                     continue;
//                 } else if (stack.peek() == -asteroid) {
//                     stack.pop(); // Both explode
//                     destroyed = true;
//                     break;
//                 } else {
//                     // Current asteroid explodes
//                     destroyed = true;
//                     break;
//                 }
//             }

//             if (!destroyed) {
//                 stack.push(asteroid);
//             }
//         }

//         // Convert stack to int array
//         int[] result = new int[stack.size()];
//         for (int i = result.length - 1; i >= 0; i--) {
//             result[i] = stack.pop();
//         }

//         return result;
//     }
// }
