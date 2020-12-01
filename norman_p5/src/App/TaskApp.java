package App;

import java.util.Scanner;

public class TaskApp {
    static final String fileLocation = "c:/temp/TaskList.txt";
    private TaskList tasks;

    public TaskApp() {
        tasks = new TaskList();
    }

    public void taskMainLoop(Scanner input) {
        Boolean stillMain = true;
        do {
            printMainMenu();
            String input2 = input.nextLine();
            try{
                if (input2.equals("1")) {
                    operationLoop(input);
                } if (input2.equals("2")) {
                    tasks = TaskList.stringToTaskList(fileLocation);
                    operationLoop(input);
                } if (input2.equals("3")) {
                    System.out.println("Exiting TaskList program\n\n");
                    break;

                } else {throw new Exception();}
            } catch(Exception e){
                System.out.println("Enter 1, 2, or 3");
            }
        } while (stillMain);
    }

    public void operationLoop(Scanner input) throws Exception{
        while(true){
            printOperationMenu();
            //Scanner input3 = new Scanner(System.in);
            String input3 = input.nextLine();
            //print menu
            if (input3.equals("1")){
                tasks.printTaskList();
            }
            else if (input3.equals("2")){
                System.out.println("Task title: ");
                String title = input.nextLine();
                System.out.println("Task description: ");
                String description = input.nextLine();
                System.out.println("Task due date [YYYY-MM-DD]: ");
                String dueDate = input.nextLine();
                tasks.addTaskListItem(title, description, dueDate);

            }
            else if (input3.equals("3")){
                tasks.printTaskList();
                System.out.println("Which task will you edit? ");
                String taskItemNumber = input.nextLine();
                System.out.println("Enter a new title for task: ");
                String title = input.nextLine();
                System.out.println("Enter a new description for task %n " + taskItemNumber);
                String description = input.nextLine();
                System.out.println("Task due date (YYYY-MM-DD): ");
                String dueDate = input.nextLine();
                tasks.editTaskListItem(Integer.valueOf(taskItemNumber), title, description, dueDate, Integer.valueOf(taskItemNumber));
            }
            else if (input3.equals("4")){
                tasks.printTaskList();
                System.out.println("Which item will you remove? ");
                String taskItemNumber = input.nextLine();
                tasks.removeTaskListItem(Integer.valueOf(taskItemNumber));
            }
            else if (input3.equals("5")){
                tasks.printTaskList();
                System.out.println("Which item will you mark as completed");
                String taskItemNumber = input.nextLine();
                tasks.markTaskListItemComplete(Integer.valueOf(taskItemNumber));
            }
            else if (input3.equals("6")){
                tasks.printTaskList();
                System.out.println("Which item will you unmark as completed");
                String taskItemNumber = input.nextLine();
                tasks.unmarkTaskListItemComplete(Integer.valueOf(taskItemNumber));
            }
            else if (input3.equals("7")){
                tasks.saveTaskList(fileLocation);

            }
            else if (input3.equals("8")){
                tasks.deleteTempTaskList();
                break;
            }
            else {
                System.out.println("Enter 1, 2, or 3");
            }
        }
    }
    public void printMainMenu(){
        System.out.println("Main Menu");
        System.out.println("-------------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println(">");
    }
    public void printOperationMenu() {
        System.out.println("List Operation Menu\n-----------");
        System.out.println("1) View the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as competed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save current list");
        System.out.println("8) quit to the main menu");
        System.out.println("> ");
    }
}
