package src;
import java.util.Objects;
import java.util.Scanner;
public class App {

    static String mainInput;
    static boolean shouldQuitVar;
    static Scanner input = new Scanner(System.in);

    // List class variables
    //static Scanner input2 = new Scanner(System.in);
    static boolean listQuitVar;
    static String listInput;

    private TaskList tasks;
    public App(){
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

    private void processMainMenuInput() {
        while (!shouldQuit(getMainMenuInput())) {

            System.out.println("Step 3: enter while loop");

            validateMainMenuInput();
            System.out.println("finished processing MainMenuInput");
            System.out.println("Your value: " + mainInput);
        }
    }

    public String validateMainMenuInput() {
        System.out.println("Step 4: Open processMainMenuInput");
        //Scanner newInput = new Scanner(System.in);
        if (mainInput.equals("1")) {
            System.out.println("You are making a new List");
            createNewList();
            System.exit(0);

        } else if (mainInput.equals("2")) {
            System.out.println("This feature is not yet ready");
            System.exit(0);
        } else {
            System.out.println("You have entered an incorrect value. Please enter 1, 2, or 3");
            System.out.printf("\n> ");
            mainInput = input.nextLine();
        }
        return mainInput;
    }

    // Here are the List Methods
    public void createNewList() {
        while (!listQuit(printMenu())) {

            System.out.println("Step 3: processListInput");
            processListInput();
            System.out.println("finished processing ListInput");
            System.out.println("Your value: " + listInput);
        }
    }

    private String processListInput() {
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
                tasks.editTaskListItem(taskItemNumber, title, description, dueDate);
                break;
            }
            case "4": {
                tasks.printTaskList();
                System.out.println("Which item will you remove? ");
                String taskItemNumber = input.nextLine();
                tasks.removeTaskListItem(taskItemNumber);
                break;
            }
            case "5": {
                tasks.printTaskList();
                System.out.println("Which item will you mark as completed");
                String taskItemNumber = input.nextLine();
                tasks.markTaskListItemComplete(taskItemNumber);
                break;
            }
            case "6": {
                tasks.printTaskList();
                System.out.println("Which item will you unmark as completed");
                String taskItemNumber = input.nextLine();
                tasks.unmarkTaskListItemComplete(taskItemNumber);
                break;
            }
            case "7": {
                System.out.println("Enter the filename to save as: ");
                String listFileName = input.nextLine();
                tasks.saveTaskList(listFileName);
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
    public static void main(String[] args) {
        App m = new App();
        m.processMainMenuInput();
    }
}
// pseudocode

// initialize title as a list of strings
// initialize date as list of strings
// initialize descriptions as a list of strings

// prompt user to create, load list or quit program from main menu

    // while input != quit
        // if input = create
            // prompt user to view, add item, edit item, remove item, mark completed, unmark completed, save list, or quit
                // if input = view
                    // display uncompleted items in list and prompt user with main menu
                // if input equals add item
                    // prompt user to enter 'title,' 'description,' and 'date'
                        // title = read string from user
                        // description = read String from user
                        // date = read string (until sorted later)

                        // store title, description, and date strings in "data"
                        // store numerical position of item, starting at 0

                        // prompt user with main menu again
                // if input = edit item
                    // display uncompleted items in current list and prompt user to enter the item number to modify
                    // prompt user to enter new 'title,' 'description,' and 'date'
                    // prompt user with main menu again

                // if input = remove
                    // display uncompleted items in current list and prompt user to enter item number
                        //delete item and replace item with those following with position i -1
                    // display main menu
                // if input = mark completed
                    // display incomplete items, prompt the user to enter item number, and use boolean isComplete = false to print "**" before the date value
                    // display main menu
                // if input = mark incomplete
                    // display items having boolean isComplete = true, and prompt user to enter a value
                    // for item entered, mark boolean isComplete = false
                    // prompt list menu
                // if input = save current list
                    // prompt the user to enter filename and save to desktop
                // if input = return to main menu
                    // return to main menu
        // if input = load a list
            // prompt user to enter file name
                // if exact, load file
                // display main menu
        // if input = quit
            // end program

