package brackets;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

public class BracketsStaticUtils {

    public static String bracketEncoding(String s){
        Map<Character, Integer> map = new HashMap<>();
        s = s.toLowerCase(Locale.ROOT);

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.merge(s.charAt(i), 1, Integer::sum);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > 1) {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }

        return sb.toString();
    }

    public static boolean bracketSequenceValidator(String s){
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x=='(') {
                stack.push(')');
            } else if (x=='{') {
                stack.push('}');
            } else if (x=='[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop()!=x) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
