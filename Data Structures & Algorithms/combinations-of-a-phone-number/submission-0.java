class Solution {
    String[] phone = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return list;
        }
        StringBuilder current = new StringBuilder();
        backtracking(0,current, digits);
        return list;
    }

    public void backtracking(int index,StringBuilder current, String digits){
        if(index == digits.length()){
            list.add(current.toString());
            return;
        }
        for(int i = 0 ; i < phone[digits.charAt(index) - '0'].length(); i++){
            current.append(phone[digits.charAt(index) - '0'].charAt(i));
            backtracking(index + 1, current, digits);
            current.deleteCharAt(current.length() - 1);
        }
    }
}