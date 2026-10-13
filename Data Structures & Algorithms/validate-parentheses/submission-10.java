class Solution {
  public boolean isValid(String s) {
    Deque < Character > stack = new ArrayDeque < >();
    if (s.length() % 2 == 1) return false;
    for (char c: s.toCharArray()) {
      if (isOpeningBrackets(c)) stack.push(c);
      else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
      else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
      else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
      else return false;
    }
    // this ensures that the edge case of (((, only opening brackets are in the string but none of the closings are in, so the else if and onwards are never executed, only when stack is emmpty then the whole string of parenthesis is valid
    return stack.isEmpty();
  }

}
public boolean isOpeningBrackets(char c) {
  return c == '(' || c == '[' || c == '{';
}