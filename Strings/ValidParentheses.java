/*
Problem no.: 20
Problem: Valid Parentheses
Platform: LeetCode
Difficulty: Easy

Approach:
We use a Stack to keep track of the expected closing brackets.

We traverse each character of the string:
1. If the character is an opening bracket '(' or '{' or '[',
   we push the corresponding closing bracket ')', '}', or ']'
   onto the stack.
2. If the character is a closing bracket, we check:
   - If the stack is empty, the string is invalid.
   - Otherwise, we pop the top element from the stack and check
     if it matches the current closing bracket.
3. If it does not match, the parentheses are not valid.

At the end, if the stack is empty, all brackets were matched
correctly and the string is valid. Otherwise, it is invalid.

Time Complexity: O(n)
Space Complexity: O(n)

Pattern: Stack
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else if(c == '['){
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
