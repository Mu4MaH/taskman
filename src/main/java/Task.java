import java.util.Scanner;

public class Task {

    private final String name; //название таска
    private final String author; //автор
    private String executor; // исполнитель
    private int term; // срок выполнения
    private Priority priority;
    private State state;


    Task (String name, String author, String executor, int term, String priority) {
        this.name = name;
        this.author = author;
        this.executor = executor;
        this.term = term;
        this.priority = Priority.valueOf(priority);
        state = State.OPEN;
    }



//    public Task newTask () {
//
//    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", executor='" + executor + '\'' +
                ", term=" + term +
                ", priority=" + priority +
                ", state=" + state +
                '}';
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getExecutor() {
        return executor;
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

    enum Priority {
        idle, urgent, fatal
    }

    enum State {
        OPEN, WORKING, FINISHED, CLOSED
    }
}
