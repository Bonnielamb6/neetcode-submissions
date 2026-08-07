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
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        StringBuilder current = new StringBuilder();
        if(digits.isEmpty()){
            return result;
        }
        backtracking(0, current, digits);
        return result;
    }

    public void backtracking(int index, StringBuilder current, String digits){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }
        for(int pointer = 0 ; pointer < phone[digits.charAt(index) - '0'].length(); pointer++){
            current.append(phone[digits.charAt(index) - '0'].charAt(pointer));
            backtracking(index + 1, current, digits);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
