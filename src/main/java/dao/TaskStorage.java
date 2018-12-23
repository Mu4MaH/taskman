package dao;

import entities.Task;
import View.View;

import java.util.*;

public class TaskStorage {

    public static Map<String, Task> tasks = new HashMap ();

    public static void TestFill () {
       Task task1 = new Task("repair","Ivan", 3, "idle");
       Task task2 = new Task("install", "Fred",  2, "idle");
       Task task3 = new Task("clean", "James", 1, "FATAL");
       tasks.put(task1.getName(), task1);
       tasks.put(task2.getName(), task2);
       tasks.put(task3.getName(), task3);
    }

public void addTask () {
    Task task = new Task();
    tasks.put(task.getUid(),task);
    View.mainMenu();
}

    public Task getTask (String uid) {
        return (Task) tasks.get(uid);
    }

    public void viewAllTasks () {
        if (tasks.isEmpty()) System.out.println("No active tasks.");
        else {
            int id = 0;
            for (String key : tasks.keySet())
                System.out.println(id++ + " " + tasks.get(key).toString());
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
                //TODO: changer.setExecutor(toChange.nextLine()); Добавить метод changeExecutor с проверкой на существование
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
        View.mainMenu();
    }

    public void modifyTaskExecutor(String name) {
        final Task changer = tasks.get(name);
        System.out.print("Enter name of task to change executor: ");
        final Scanner sc = new Scanner(System.in);
        tasks.replace(name, changer);
        View.mainMenu();
    }

    public void modifyTaskState (String name) {
        final Task changer = tasks.get(name);
        System.out.print("Enter name of task to change state: ");
        final Scanner sc = new Scanner(System.in);
        changer.setState(sc.nextLine());
        tasks.replace(name, changer);
        View.mainMenu();
    }

    public void modifyTaskPriority(String name) {
        final Task changer = tasks.get(name);
        System.out.print("Enter name of task to change priority: ");
        final Scanner sc = new Scanner(System.in);
        changer.setPriority(sc.nextLine());
        tasks.replace(name, changer);
        View.mainMenu();
    }

    public void modifyTaskTime(String name) {
        final Task changer = tasks.get(name);
        System.out.print("Enter name of task to add required hours: ");
        final Scanner sc = new Scanner(System.in);
        changer.addTerm(sc.nextInt());
        tasks.replace(name, changer);
        View.mainMenu();
    }

    public void deleteTask (String uid) {


    }

}



