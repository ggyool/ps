import java.util.Stack;

public class p2375 {

    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i <= pattern.length(); i++) {
            stk.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stk.isEmpty()) {
                    sb.append((char) (stk.pop() + '0'));
                }
            }
        }
        return sb.toString();
    }

    // 첫 pass
//    public String smallestNumber(String pattern) {
//        Deque<Character> dq = new ArrayDeque<>();
//        dq.addLast('1');
//        Stack<Character> stk = new Stack<>();
//        for (int i = 0; i < pattern.length(); i++) {
//            char c = pattern.charAt(i);
//            if (c == 'I') {
//                if (!stk.isEmpty()) {
//                    char tmp = dq.pollLast();
//                    while (!stk.isEmpty()) {
//                        dq.addLast(stk.pop());
//                    }
//                    dq.addLast(tmp);
//                }
//                dq.addLast((char) ('2' + i));
//            } else {
//                stk.push((char) ('2' + i));
//            }
//        }
//        char tmp = dq.pollLast();
//        while (!stk.isEmpty()) {
//            dq.addLast(stk.pop());
//        }
//        dq.addLast(tmp);
//        StringBuilder sb = new StringBuilder();
//        while (!dq.isEmpty()) {
//            sb.append(dq.pollFirst());
//        }
//        return sb.toString();
//    }
}
