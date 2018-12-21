package service;

import dao.TaskStorage;
import entities.Task;

import java.util.Scanner;

import static dao.TaskStorage.tasks;


public class TaskService {

    private TaskStorage storage = new TaskStorage();



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
        Controller.Controller();
    }

    public Task getTask (String uid) {
        return (Task) storage.tasks.get(uid);
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
        Controller.Controller();
    }

    public void modifyTaskExecutor(String name) {
        final Task changer = tasks.get(name);
        System.out.print("Enter name of task to change executor: ");
        final Scanner sc = new Scanner(System.in);
        tasks.replace(name, changer);
        Controller.Controller();
    }

    public void modifyTaskState (String name) {
        final Task changer = tasks.get(name);
        System.out.print("Enter name of task to change state: ");
        final Scanner sc = new Scanner(System.in);
        changer.setState(sc.nextLine());
        tasks.replace(name, changer);
        Controller.Controller();
    }

    public void modifyTaskPriority(String name) {
        final Task changer = tasks.get(name);
        System.out.print("Enter name of task to change priority: ");
        final Scanner sc = new Scanner(System.in);
        changer.setPriority(sc.nextLine());
        tasks.replace(name, changer);
        Controller.Controller();
    }

    public void modifyTaskTime(String name) {
        final Task changer = tasks.get(name);
        System.out.print("Enter name of task to add required hours: ");
        final Scanner sc = new Scanner(System.in);
        changer.addTerm(sc.nextInt());
        tasks.replace(name, changer);
        Controller.Controller();
    }

    public void deleteTask (String uid) {


    }
}
