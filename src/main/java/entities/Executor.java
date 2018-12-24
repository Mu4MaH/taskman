package entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Executor {
    private final String uid;
    private String name;
    private Map<String, Task> taskList = new HashMap<>();
    private boolean named = false;

    Executor() {
        this.name = "empty";
        uid =  UUID.randomUUID().toString();
    }

    Executor(String name){
        this.name = name;
        uid =  UUID.randomUUID().toString();
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
        }
    }

    public void printAllTasks() {
        if (taskList.isEmpty()) System.out.println("No active tasks.");
        else {
            int id = 1;
            for (String key : taskList.keySet())
                System.out.println(id++ + ". " + taskList.get(key).toString());
        }
    }

    public HashMap<String, Task> getAllTasks() {
         Map<String,Task> output = new HashMap<>();
        if (taskList.isEmpty()) System.out.println("No active tasks.");
        else
            for (String key : taskList.keySet())
                output.put(key,taskList.get(key));
        return (HashMap)output;
    }


    public String getUid () {
        return this.uid;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getExecutorOfTask(Task task) {     //Checks if executor is at task and returns his name
        if (taskList.containsKey(task.getUid()))     // Otherwise returns empty string
            return this.name;
        else return "";
    }

    public Map<String, Task> getTaskList() {
        return taskList;
    }
}
