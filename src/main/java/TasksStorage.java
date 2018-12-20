import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TasksStorage {

    private static Map<String, Task> tasks = new HashMap ();

    public void addTask () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new task descriprion: " );
        String description = sc.nextLine();
        System.out.print("Enter new task author: ");
        String author = sc.nextLine();
        System.out.print("Set executor of task: ");
        String executor = sc.nextLine();
        System.out.print("Set priority of task (IDLE/URGENT/FATAL): ");
        String priority = sc.nextLine();
        System.out.print("Enter hours required to complete task: ");
        int term = sc.nextInt();
        tasks.put(description, new Task(description, author, executor, term, priority));
        App.Controller();
    }

    public Task getTask (String name) {
        return (Task) tasks.get(name);
    }

    public void viewAllTasks () {
        for (String key : tasks.keySet()) {
            System.out.println(tasks.get(key).toString());
        }
        
    }

    public void modifyTaskChoice(String name) {
        Task changer = tasks.get(name);
        System.out.println("What would you like to modify? \n 1)Executor \n 2)Time \n 3)State \n 4)Priority ");
        final Scanner sc = new Scanner(System.in);
        final Scanner toChange = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                System.out.print("Set new executor: ");
                changer.setExecutor(toChange.nextLine());
                break;
            case 2:
                System.out.print("Add required hours to complete task");
                changer.addTerm(toChange.nextInt());
                break;
            case 3:
                System.out.print("Set new state of task: ");
                changer.setState(toChange.nextLine());
                break;
            case 4:
                System.out.print("Change priority of task: ");
                changer.setPriority(toChange.nextLine());
        }
        tasks.replace(name,changer);
        App.Controller();
    }

    public void modifyTaskExecutor(String name) {
        Task changer = tasks.get(name);
        System.out.print("Changing Executor, enter new name: ");
        Scanner sc = new Scanner(System.in);
        changer.setExecutor(sc.nextLine());
        tasks.replace(name,changer);
        App.Controller();
    }

    public void modifyTaskState (String name) {
        Task changer = tasks.get(name);
        System.out.print("Changing task state, enter new state: ");
        Scanner sc = new Scanner(System.in);
        changer.setState(sc.nextLine());
        tasks.replace(name,changer);
        App.Controller();
    }

    public void modifyTaskPriority(String name) {
        Task changer = tasks.get(name);
        System.out.print("Changing task priority, enter new option: ");
        Scanner sc = new Scanner(System.in);
        changer.setPriority(sc.nextLine());
        tasks.replace(name,changer);
        App.Controller();
    }

    public void modifyTaskTime(String name) {
        Task changer = tasks.get(name);
        System.out.print("Add time to task term, add required hours: ");
        Scanner sc = new Scanner(System.in);
        changer.addTerm(sc.nextInt());
        tasks.replace(name,changer);
        App.Controller();
    }
}



