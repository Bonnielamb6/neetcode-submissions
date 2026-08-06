class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b.counter, a.counter));
        Deque<CooldownTask> queue = new ArrayDeque<>();
        int[] tasksArray = new int[26];
        for (char task : tasks) {
            tasksArray[task - 'A']++;
        }
        for (int pointer = 0; pointer < 26; pointer++) {
            if (tasksArray[pointer] != 0) {
                Task tempTask = new Task((char) (pointer + 'A'), tasksArray[pointer]);
                pq.offer(tempTask);
            }
        }
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            Task task;
            CooldownTask cooldownTask;
            if(!pq.isEmpty()){
                task = pq.poll();
                task.counter--;
                if(task.counter > 0){
                    cooldownTask = new CooldownTask(task.name, task.counter,time + n);
                    queue.offer(cooldownTask);
                }
            }
            if(!queue.isEmpty() && queue.peek().available <= time){
                cooldownTask = queue.poll();
                task = new Task(cooldownTask.name, cooldownTask.counter);
                pq.offer(task);
            }
            time++;
        }
        return time;
    }
}

class Task {
    char name;
    int counter;
    public Task(char name, int counter) {
        this.name = name;
        this.counter = counter;
    }
}

class CooldownTask {
    char name;
    int available;
    int counter;

    public CooldownTask(char name, int counter, int available) {
        this.name = name;
        this.available = available;
        this.counter = counter;
    }
}
