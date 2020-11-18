package src;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
public class App {
    static final String fileLocation = "c:/temp/TaskList.txt";
    static String mainInput;
    static boolean shouldQuitVar;
    static Scanner input = new Scanner(System.in);

    // List class variables
    //static Scanner input2 = new Scanner(System.in);
    static boolean listQuitVar;
    static String listInput;

    private TaskList tasks;
    public App() throws IOException {
        tasks = new TaskList();
    }

    public static String getMainMenuInput() {
        System.out.println("Main menu");
        System.out.println("-----------");
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Exit program");
        System.out.printf("\n> ");
        mainInput = input.nextLine();
        return mainInput;
    }

    public static boolean shouldQuit(String mainMenuInput) {
        System.out.println("Step 2: Opened shouldQuit");
        shouldQuitVar = mainMenuInput.equals("3");
        return shouldQuitVar;
    }

    private void processMainMenuInput() throws IOException {


        while (!shouldQuit(getMainMenuInput())) {

            System.out.println("Step 3: enter while loop");

            validateMainMenuInput();
            System.out.println("finished processing MainMenuInput");
            System.out.println("Your value: " + mainInput);
        }
    }

    public String validateMainMenuInput() throws IOException {
        System.out.println("Step 4: Open processMainMenuInput");
        //Scanner newInput = new Scanner(System.in);
        if (mainInput.equals("1")) {
            System.out.println("You are making a new List");
            createNewList();
            System.exit(0);

        } else if (mainInput.equals("2")) {
            tasks = TaskList.stringToTaskList(fileLocation);

            createNewList();
            System.exit(0);
        } else {
            System.out.println("You have entered an incorrect value. Please enter 1, 2, or 3");
            System.out.printf("\n> ");
            mainInput = input.nextLine();
        }
        return mainInput;
    }

    // Here are the List Methods
    public void createNewList() throws IOException {
        while (!listQuit(printMenu())) {

            System.out.println("Step 3: processListInput");
            processListInput();
            System.out.println("finished processing ListInput");
            System.out.println("Your value: " + listInput);
        }
    }

    private String processListInput() throws IOException {
        switch (listInput) {
            case "1": {
                tasks.printTaskList();
                break;
            }
            case "2": {
                System.out.println("Task title: ");
                String title = input.nextLine();
                System.out.println("Task description: ");
                String description = input.nextLine();
                System.out.println("Task due date (YYYY-MM-DD): ");
                String dueDate = input.nextLine();
                tasks.addTaskListItem(title, description, dueDate);

                break;
            }
            case "3": {
                tasks.printTaskList();
                System.out.println("Which task will you edit? ");
                String taskItemNumber = input.nextLine();
                System.out.println("Enter a new title for task: ");
                String title = input.nextLine();
                System.out.println("Enter a new description for task %n " + taskItemNumber);
                String description = input.nextLine();
                System.out.println("Task due date (YYYY-MM-DD): ");
                String dueDate = input.nextLine();
                tasks.editTaskListItem(Integer.valueOf(taskItemNumber), title, description, dueDate);
                break;
            }
            case "4": {
                tasks.printTaskList();
                System.out.println("Which item will you remove? ");
                String taskItemNumber = input.nextLine();
                tasks.removeTaskListItem(Integer.valueOf(taskItemNumber));
                break;
            }
            case "5": {
                tasks.printTaskList();
                System.out.println("Which item will you mark as completed");
                String taskItemNumber = input.nextLine();
                tasks.markTaskListItemComplete(Integer.valueOf(taskItemNumber));
                break;
            }
            case "6": {
                tasks.printTaskList();
                System.out.println("Which item will you unmark as completed");
                String taskItemNumber = input.nextLine();
                tasks.unmarkTaskListItemComplete(Integer.valueOf(taskItemNumber));
                break;
            }
            case "7": {
                tasks.saveTaskList(fileLocation);
                break;
            }
            case "8":
                processMainMenuInput();
                break;
            default:
                System.out.println("Please enter a valid number from 1-8\n");
                System.out.print("> ");
                //listInput = input.nextLine();

        }
        return listInput;
    }

    private boolean listQuit(Object listInput) {
        System.out.println("Opened listQuit");
        listQuitVar = listInput.equals("8");
        return listQuitVar;
    }

    private Object printMenu() {
        System.out.println("List Operation Menu\n-----------");
        System.out.println("1) View the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as competed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save current list");
        System.out.println("8) quit to the main menu");
        System.out.printf("\n> ");
        listInput = input.nextLine();
        return listInput;
    }

    private void processTaskListData(){
        //while(listInput == "2")
    }
    public static void main(String[] args) throws IOException {
        App m = new App();
        m.processMainMenuInput();
    }
}

