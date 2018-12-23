import dao.ExecutorStorage;
import dao.ProjectStorage;
import dao.TaskStorage;
import View.View;


public class App {

    /* ***Let's initialize all storages as static*** */
    static {
        ProjectStorage projectStorage = new ProjectStorage();
        ExecutorStorage executorStorage = new ExecutorStorage();
        TaskStorage taskStorage = new TaskStorage();

    }


    public static void main (String ... args) {
        View.mainMenu();
    }

}
