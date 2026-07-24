class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for(String str : strs){
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String tempStr = new String(word);
            groups.computeIfAbsent(tempStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
