package view;

import java.util.Scanner;

public class View {


    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: \n 1)Create task \n 2)view tasklist \n 3)Change task executor \n" +
                " 4)Change task priority \n 5)Change task time \n 6)Exit");
        Scanner taskName = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:

                break;
            case 2:

                mainMenu();
                break;
            case 3:

                mainMenu();
                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                System.exit(0);
            case 7: //secret rabbit hole  =:

                mainMenu();
                break;
        }
    }

//    public void
}
