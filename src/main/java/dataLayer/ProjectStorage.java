package dataLayer;

import entities.Project;

import java.util.HashMap;
import java.util.Map;

 public class ProjectStorage {

    static private Map<String, Project> projects = new HashMap();

    public ProjectStorage(){
    }

    public void addProject(Project project) {
        projects.put(project.getUid(), project);
    }

    public void removeProject(String uid) {
        projects.remove(uid);
    }

    public void removeProject(Project project) {
        projects.remove(project.getUid());
    }

    public Project getProject(String uid) {
        return projects.get(uid);
    }
}
