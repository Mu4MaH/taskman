package View;

import dao.TaskStorage;

import java.util.Scanner;

import static dao.TaskStorage.tasks;

public class View {


    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: \n 1)Create task \n 2)View tasklist \n 3)Change task executor \n" +
                " 4)Change task priority \n 5)Change task time \n 6)Exit");
        Scanner taskName = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                tasks.();
                break;
            case 2:
                tasksStorage.viewAllTasks();
                mainMenu();
                break;
            case 3:
                tasksStorage.viewAllTasks();
                tasksStorage.modifyTaskExecutor(taskName.nextLine());
                mainMenu();
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
                mainMenu();
                break;
        }
    }

//    public void
}
