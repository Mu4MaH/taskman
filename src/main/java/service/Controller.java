package service;

import dao.TaskStorage;
import service.TaskService;

import java.util.Scanner;

public class Controller {

    static TaskStorage tasksStorage = new TaskStorage();

    public static void Controller() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: \n 1)Create task \n 2)View tasklist \n 3)Change task executor \n" +
                " 4)Change task priority \n 5)Change task time \n 6)Exit");
        Scanner taskName = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                tasksStorage.addTask();
                break;
            case 2:
                tasksStorage.viewAllTasks();
                Controller();
                break;
            case 3:
                tasksStorage.viewAllTasks();
                tasksStorage.modifyTaskExecutor(taskName.nextLine());
                Controller();
                break;
            case 4:
                tasksStorage.viewAllTasks();
                System.out.print("Enter task to change priority");
                tasksStorage.modifyTaskPriority(taskName.nextLine());
                break;
            case 5:
                tasksStorage.viewAllTasks();
                System.out.print("Enter task to change time");
                tasksStorage.modifyTaskTime(taskName.nextLine());
                break;
            case 6:
                System.out.println("Bye..");
                System.exit(0);
            case 7:
                TaskStorage.TestFill();
                tasksStorage.viewAllTasks();
                Controller();
                break;
        }
    }
}
