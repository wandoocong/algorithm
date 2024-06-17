package stackAndqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "[]{}()";

        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println("IS validParentheses ?? = " + validParentheses.isValid(str));

    }

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        for (int i = 0; i < s.length(); i++) {
            // 닫힘 괄호가 아닌경우에는 stack 에 push
            if (!table.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
                // 닫힘 괄호라면,
                // stack 에 열린괄호가 있어야하고, Hash table 에서 꺼낸 value 랑 stack 에 있는 value 랑 같아야함
            } else if (stack.isEmpty() || table.get(s.charAt(i))!= stack.pop()) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
