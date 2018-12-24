import dataLayer.ExecutorStorage;
import dataLayer.ProjectStorage;
import dataLayer.TaskStorage;
import view.View;


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
