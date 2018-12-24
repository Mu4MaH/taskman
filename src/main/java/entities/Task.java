package entities;

import java.util.Scanner;
import java.util.UUID;

public class Task {

    private final String uid = UUID.randomUUID().toString();;
    private String name; //название таска
    private String description;
    private final String author; //автор
    private int term; // срок выполнения
    private Priority priority;
    private State state;
    private int id = 0;

    public Task(){
        final Scanner sc = new Scanner(System.in);
        System.out.print("Enter new task descriprion: " );
        this.name = sc.nextLine();
        System.out.print("Enter new task author: ");
        this.author = sc.nextLine();
        System.out.print("Set executor of task: ");
        final String executor = sc.nextLine();
        System.out.print("Set priority of task (IDLE/URGENT/FATAL): ");
        this.priority = Priority.valueOf(sc.nextLine());
        System.out.print("Enter hours required to complete task: ");
        this.term = Integer.parseInt(sc.nextLine());
        this.state = State.OPEN;
    }


    public Task(String name, String author, int term, String priority) {
        this.name = name;
        this.author = author;
        this.term = term;
        this.priority = Priority.valueOf(priority);
        this.state = State.OPEN;
    }

    Task (String name, String author, Executor executor, Project project, int term, String priority) {
        this.name = name;
        this.author = author;
        this.term = term;
        this.priority = Priority.valueOf(priority);
        state = State.OPEN;
    }

    @Override
    public String toString() {
        return "entities.Task{" +
                "name = '" + name + '\'' +
                ", author = '" + author + '\'' +
// TODO: get executors list, who are on this task               ", executor = '" + TaskStorage.tasks.get() + '\'' +
                ", term = " + term +
                ", priority = " + priority +
                ", state = " + state +
                //TODO: get project which this task is assigned at    ", entities.Project = " + project.getName() +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
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
