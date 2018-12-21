package entities;

import java.util.HashMap;
import java.util.Map;

public class Project {

    private String name;

    Project() {
        this.name="empty";
        this.stuff = null;
    }

    Project(String name) {
        this.name = name;
        this.stuff = null;
    }

    private Map<String, Executor> stuff = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStuff(Executor executor) {
        stuff.put(executor.getUid(),executor);
    }
}
