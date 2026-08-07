class Solution {
    String s;
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList<>();
        this.s = s;
        backtracking(0,current);
        return result;
    }

    public void backtracking(int start, List<String> current){
        if(start == s.length() ){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(start, end)){
                String sub = s.substring(start, end + 1);
                current.add(sub);
                backtracking(end + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end --;
        }
        return true;
    }
}
