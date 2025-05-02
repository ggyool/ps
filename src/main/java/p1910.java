import java.util.Stack;

public class p1910 {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            int idx = sb.indexOf(part);
            if (idx == -1) break;
            // end exclusive 임
            sb.delete(idx, idx + part.length());
        }
        return sb.toString();
    }

//    public String removeOccurrences(String s, String part) {
//        Stack<Character> stk = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            stk.push(s.charAt(i));
//            checkAndRemove(stk, part);
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!stk.isEmpty()) {
//            sb.append(stk.pop());
//        }
//        return sb.reverse().toString();
//    }
//
//    private void checkAndRemove(Stack<Character> stk, String part) {
//        if (stk.size() < part.length()) {
//            return;
//        }
//        boolean includes = true;
//        Stack<Character> tmp = new Stack<>();
//        for (int i = 0; i < part.length(); i++) {
//            Character c = stk.pop();
//            tmp.push(c);
//            if (c != part.charAt(part.length() - 1 - i)) {
//                includes = false;
//                break;
//            }
//        }
//        if (!includes) {
//            while (!tmp.isEmpty()) {
//                stk.push(tmp.pop());
//            }
//        }
//    }
}
