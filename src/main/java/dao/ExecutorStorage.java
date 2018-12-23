package dao;

import entities.Executor;
import entities.Project;

import java.util.HashMap;
import java.util.Map;

public class ExecutorStorage {
    private Map<String, Executor> executors = new HashMap<>();
    
    public ExecutorStorage() {
    }
    
    public void addExecutor (Executor executor) {
        executors.put(executor.getUid(), executor);
    }
    
    public void removeExecutor (Executor executor) {
        executors.remove(executor.getUid());
    }
    
    public void removeExecutor (String uid) {
        executors.remove(uid);
    }
    
    public HashMap<String, Executor> getExecutorsByProject (Project project) {
        Map<String, Executor> result = new HashMap<>();
        for (String key :executors.keySet()) {
            if (executors.get(key).getTaskList().containsKey(project.getUid()))
            result.put(key, executors.get(key));
        }
        return (HashMap)result;
    }

    public void printExecutorsByProject (Project project) {
        for (String key :executors.keySet())
            if (executors.get(key).getTaskList().containsKey(project.getUid()))
                System.out.println(executors.get(key).getName() + " ");

        }
    }


