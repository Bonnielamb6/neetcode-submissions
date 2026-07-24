class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Character current : s.toCharArray()){
            switch(current){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != ')') return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '}') return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != ']') return false;
                    
            }
        }
        if(!stack.isEmpty())return false;
        return true;
    }
}
