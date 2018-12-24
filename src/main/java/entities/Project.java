package entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Project {
    private final String uid;
    private String name;
    private String description;
    private Map<String, Executor> executorList = new HashMap<>();
    private Map<String, Task> taskList = new HashMap<>();
    private int projectTerm = 0;
    private boolean finished = false;

    Project() {
        this.name="empty";
        this.executorList = null;
        this.uid =  UUID.randomUUID().toString();
    }

    Project(String name) {
        this.name = name;
        this.executorList = null;
        this.uid =  UUID.randomUUID().toString();
    }

    public String getUid(){
        return this.uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProjectTerm() {
        return projectTerm;
    }

    public void setProjectTerm(int projectTerm) {
        this.projectTerm = projectTerm;
    }

    public void assignExecutor(Executor executor) {
        executorList.put(executor.getUid(),executor);
    }

    public void assignTask(Task task){
        taskList.put(task.getUid(), task);
    }

    public HashMap<String,Task> getAllProjectTasks() {
        return (HashMap)taskList;
    }

    public void printAllProjectTasks() {
        if (taskList.isEmpty()) System.out.println("No assigned tasks.");
        else {
            int id = 1;
            for (String key : taskList.keySet())
                System.out.println(id++ + ". " + taskList.get(key).toString());
        }
    }

    public void removeTask(Task task) {
        taskList.remove(task.getUid());
    }

    public void removeTask(String uid) {
        taskList.remove(uid);
    }

    public void removeExecutor(Executor executor) {
        executorList.remove(executor.getUid());
    }

    public void removeExecutor(String uid) {
        executorList.remove(uid);
    }

}
