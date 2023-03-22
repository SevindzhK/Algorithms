import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> myStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (isCloseChar(ch)){
                if (myStack.isEmpty()){
                    return false;
                }
                if (myStack.peek() == reverseChar(ch)){
                    myStack.pop();
                    continue;
                }
            }
            myStack.push(ch);
        }

        return myStack.isEmpty();
    }

    public boolean isCloseChar(Character ch) {
        return (ch == ')' || ch == '}' || ch == ']');
    }

    public Character reverseChar(Character ch) {
        Character reverseChar = null;
        switch (ch) {
            case '(':
                reverseChar = ')';
            break;
            case '{':
                reverseChar = '}';
            break;
            case '[':
                reverseChar = ']';
            break;
            case ')':
                reverseChar = '(';
                break;
            case '}':
                reverseChar = '{';
                break;
            case ']':
                reverseChar = '[';
                break;
        }
        return reverseChar;
    }
}

public class Main{
    public static void main(String[] args) {
        String s = "(((){}[)]())";
        Solution sol = new Solution();
        System.out.println(sol.isValid(s));
    }
}
