class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> indices = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int actual = 0; actual < temperatures.length; actual++) {
            while (!indices.isEmpty() && temperatures[indices.peek()] < temperatures[actual]) {
                int tempIndex = indices.pop();
                result[tempIndex] = actual - tempIndex;
            }
            indices.push(actual);
        }
        return result;
    }
}
