class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        if (s.length() % 2 == 1) return false;
        for (char c : s.toCharArray()) {
            if (isOpeningBrackets(c)) stack.push(c);
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else return false;
            }

        return stack.isEmpty();
        }

    }
    public boolean isOpeningBrackets(char c) {
        return c == '(' || c == '[' || c == '{';
    }

