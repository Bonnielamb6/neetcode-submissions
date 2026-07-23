class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.count,a.count));
        Deque<CooldownTask> queue = new ArrayDeque<>();
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] != 0){
                Task task = new Task((char)(i + 'A'),freq[i]);
                pq.offer(task);
            }
        }
        int time = 0;
        while(!queue.isEmpty() || !pq.isEmpty()){
            CooldownTask tempTask;
            Task task;
            if(!pq.isEmpty()){
                task = pq.poll();
                task.count--;
                if(task.count > 0){
                    tempTask = new CooldownTask(task.name, task.count,time + n);
                    queue.offer(tempTask);
                }
            }
            if(!queue.isEmpty() && queue.peek().availableTime <= time){
                tempTask = queue.poll();
                task = new Task(tempTask.name,tempTask.count);
                pq.offer(task);
            }
            
            time++;
        }

        return time;

    }


}

class Task{
    int count;
    char name;
    Task(char name, int count){
        this.count = count;
        this.name = name;
    }
}

class CooldownTask{
    int count;
    char name;
    int availableTime;
    CooldownTask(char name, int count, int availableTime){
        this.count = count;
        this.name = name;
        this.availableTime = availableTime;
    }
}