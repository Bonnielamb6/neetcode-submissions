class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        backtracking(str, 0, 0, n * 2);
        return result;
    }

    public void backtracking(StringBuilder str, int open, int closed, int pairs){
        if(open + closed == pairs){
            result.add(str.toString());
        }
        if(open < pairs / 2){
            str.append('(');
            backtracking(str, open + 1, closed, pairs);
            str.deleteCharAt(str.length() - 1);
        }
        if(closed < open){
            str.append(')');
            backtracking(str, open, closed + 1, pairs);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
