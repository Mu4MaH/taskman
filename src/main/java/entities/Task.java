package entities;

import java.util.UUID;

public class Task {

    private final String name; //название таска
    private final String author; //автор
    private int term; // срок выполнения
    private Priority priority;
    private State state;
    private final String uid;
    private Project project;
    private Executor executor;
    private int id = 0;

    Task(){
        this.name = "empty";
        this.author = "empty";
        this.term = 0;
        this.priority = Priority.valueOf("IDLE");
        state = State.OPEN;
        uid = UUID.fromString(name).toString();
        this.executor = null;
        this.project = null;
    }


    public Task(String name, String author, int term, String priority) {
        this.name = name;
        this.author = author;
        this.term = term;
        this.priority = Priority.valueOf(priority);
        state = State.OPEN;
        uid = UUID.fromString(name).toString();
        this.executor = null;
        this.project = null;
    }

    Task (String name, String author, Executor executor, Project project, int term, String priority) {
        this.name = name;
        this.author = author;
        this.term = term;
        this.priority = Priority.valueOf(priority);
        state = State.OPEN;
        uid = UUID.fromString(name).toString();
        this.executor = null;
        this.project = null;
    }

    @Override
    public String toString() {
        return "entities.Task{" +
                "name = '" + name + '\'' +
                ", author = '" + author + '\'' +
                ", executor = '" + executor.getName() + '\'' +
                ", term = " + term +
                ", priority = " + priority +
                ", state = " + state +
                ", entities.Project = " + project.getName() +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public String getExecutor() {
        return executor.toString();
    }

    public State getState() {
        return state;
    }

    public void setState (String state){
        this.state = State.valueOf(state.toUpperCase());
    }

    public void addTerm (int hours) {
        this.term += hours;
    }

    public int getTerm() {
        return term;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = Priority.valueOf(priority.toUpperCase());
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    enum Priority {
        idle, urgent, fatal, IDLE, URGENT, FATAL
    }

    enum State {
        OPEN, WORKING, FINISHED, CLOSED, open, working, finished, closed
    }
}
