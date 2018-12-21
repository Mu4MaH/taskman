import java.util.*;

public class TasksStorage {

    private static Map<String, Task> tasks = new HashMap ();

    public static void TestFill () {
       Task task1 = new Task("repair","Ivan", 3, "idle");
       Task task2 = new Task("install", "Fred",  2, "idle");
       Task task3 = new Task("clean", "James", 1, "FATAL");
       tasks.put(task1.getName(), task1);
       tasks.put(task2.getName(), task2);
       tasks.put(task3.getName(), task3);
    }

    public void addTask () {
        final Scanner sc = new Scanner(System.in);
        System.out.print("Enter new task descriprion: " );
        final String description = sc.nextLine();
        System.out.print("Enter new task author: ");
        final String author = sc.nextLine();
        System.out.print("Set executor of task: ");
        final String executor = sc.nextLine();
        System.out.print("Set priority of task (IDLE/URGENT/FATAL): ");
        final String priority = sc.nextLine();
        System.out.print("Enter hours required to complete task: ");
        final int term = sc.nextInt();
        Task task = new Task(description, author, term, priority);
        tasks.put(task.getUid(),task);
        App.Controller();
    }

    public Task getTask (String uid) {
        return (Task) tasks.get(uid);
    }

    public void viewAllTasks () { //реализовать вывод по 10 записей
        if (tasks.isEmpty()) System.out.println("No active tasks.");
        else {//if (tasks.size() <= 10) {
            int id = 0;
            for (String key : tasks.keySet())
                System.out.println(id++ + " " + tasks.get(key).toString());
//        } else {
//            for (int i = 1; i < 11; i++) {
//
//            }
        }

        System.out.println();
    }

    public void modifyTaskChoice(String name) {
        Task changer = tasks.get(name);
        System.out.println("What would you like to modify? \n 1)Executor \n 2)Time \n 3)State \n 4)Priority ");
        final Scanner sc = new Scanner(System.in);
        final Scanner toChange = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                System.out.print("Set new executor: ");
                //changer.setExecutor(toChange.nextLine());
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
        System.out.print("Enter name of task to change executor: ");
        Scanner sc = new Scanner(System.in);
        //changer.setExecutor(sc.nextLine());
        tasks.replace(name,changer);
        App.Controller();
    }

    public void modifyTaskState (String name) {
        Task changer = tasks.get(name);
        System.out.print("Enter name of task to change state: ");
        Scanner sc = new Scanner(System.in);
        changer.setState(sc.nextLine());
        tasks.replace(name,changer);
        App.Controller();
    }

    public void modifyTaskPriority(String name) {
        Task changer = tasks.get(name);
        System.out.print("Enter name of task to change priority: ");
        Scanner sc = new Scanner(System.in);
        changer.setPriority(sc.nextLine());
        tasks.replace(name,changer);
        App.Controller();
    }

    public void modifyTaskTime(String name) {
        Task changer = tasks.get(name);
        System.out.print("Enter name of task to add required hours: ");
        Scanner sc = new Scanner(System.in);
        changer.addTerm(sc.nextInt());
        tasks.replace(name,changer);
        App.Controller();
    }

    public void deleteTask (String uid) {

    }
}



