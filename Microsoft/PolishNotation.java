import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> stk = new Stack<String>();
        int index =0;
        stk.push(tokens[0]);

        while(!stk.empty() && index<tokens.length){
            index++;
            //  System.out.println(stk);
            if(index<tokens.length && (tokens[index].equals("+")||tokens[index].equals("*")||tokens[index].equals("/") ||tokens[index].equals("-"))){
                // System.out.println(stk);
                int a = Integer.parseInt(stk.pop());
                int b = Integer.parseInt(stk.pop());

                 
                if(tokens[index].equals("+")){
                    stk.push(Integer.toString(b+a));
                }
                else if(tokens[index].equals("-")){
                    stk.push(Integer.toString(b-a));
                }
                else if(tokens[index].equals("*")){
                    stk.push(Integer.toString(b*a));
                }
                else{
                    stk.push(Integer.toString(b/a));
                }

            }else{
                if(index<tokens.length){
                    stk.push(tokens[index]);
                }
                
            }
 
            
        }

        // System.out.println(stk);

        return Integer.parseInt(stk.pop());
    }
}

public class PolishNotation {

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.evalRPN(new String [] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}