package entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Executor {
    private String name;
    private Map<String, Task> taskList = new HashMap<>();
    private boolean named = false;
    private String uid;

    Executor() {
        this.name = "empty";
        uid = null;
    }

    Executor(String name){
        this.name = name;
        uid =  UUID.fromString(name).toString();
        named = true;
    }

    public String getName() {
        if (named) return name;
        else return "No name. Set name";
    }

    public void setName(String name) {
        if (named) System.out.println("You are not allowed to change name");
        else {
            this.name = name;
            uid =  UUID.fromString(name).toString();
        }
    }

    public Task getTask(String taskUid) {
        return taskList.get(taskUid);
    }

    public void addTask (Task task) {
        taskList.put(task.getUid(),task);
    }

    public void viewAllTasks () {
        if (taskList.isEmpty()) System.out.println("No active tasks.");
        else {
            int id = 1;
            for (String key : taskList.keySet())
                System.out.println(id++ + ". " + taskList.get(key).toString());
        }
    }

    public void replaceTask (String oldTaskUid, Task newTask) {
        taskList.replace(oldTaskUid, newTask);
    }

    public String getUid () {
        return this.uid;
    }



}
