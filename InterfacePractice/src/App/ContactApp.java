import java.util.Scanner;


public class ContactApp {
    static final String fileLocation = "c:/temp/ContactList.txt";
    private ContactList contacts;

    public ContactApp()  {
        contacts = new ContactList();
    }

    public void contactMainLoop(Scanner input) throws Exception {
        System.out.println("we entered");
        while(true){
            printMainMenu();
            String input2 = input.nextLine();

            if (input2.equals("1")){
                operationLoop(input);
            }
            else if (input2.equals("2")){
                contacts = ContactList.stringToTaskList(fileLocation);
                operationLoop(input);
            }
            else if (input2.equals("3")){
                System.out.println("Exiting ContactList program");
                System.exit(0);
            }
            else {
                System.out.println("Enter 1, 2, or 3");
            }
        }
    }

    public void operationLoop(Scanner input) throws Exception{
        while(true){
            printOperationMenu();
            //Scanner input3 = new Scanner(System.in);
            String input3 = input.nextLine();
            //print menu
            if (input3.equals("1")){
                contacts.printContactList();
            }
            else if (input3.equals("2")){
                System.out.println("First Name: ");
                String firstName = input.nextLine();
                System.out.println("Last Name: ");
                String lastName = input.nextLine();
                System.out.println("Phone number (xxx-xxx-xxxx): ");
                String phoneNumber = input.nextLine();
                System.out.println("Email address (x@y.z): ");
                String email = input.nextLine();
                contacts.addContactListItem(firstName, lastName, phoneNumber, email);

            }
            else if (input3.equals("3")){
                contacts.printContactList();
                System.out.println("Which contact will you edit? ");
                String contactItemNumber = input.nextLine();
                System.out.println("New First Name: ");
                String firstName = input.nextLine();
                System.out.println("New Last Name: ");
                String lastName = input.nextLine();
                System.out.println("New Phone number (xxx-xxx-xxxx): ");
                String phoneNumber = input.nextLine();
                System.out.println("New Email address (x@y.z): ");
                String email = input.nextLine();
                contacts.editContactListItem(Integer.valueOf(contactItemNumber), firstName, lastName, phoneNumber, email, Integer.valueOf(contactItemNumber));
            }
            else if (input3.equals("4")){
                contacts.printContactList();
                System.out.println("Which item will you remove? ");
                String contactItemNumber = input.nextLine();
                contacts.removeContactListItem(Integer.valueOf(contactItemNumber));
            }
            else if (input3.equals("5")){
                contacts.saveContactList(fileLocation);

            }
            else if (input3.equals("6")){
                contacts.deleteTempContactList();
                break;
            }
            else {
                System.out.println("Enter valid number");
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
     System.out.println("1) view the list");
     System.out.println("2) add an item");
     System.out.println("3) edit an item");
     System.out.println("4) remove an item");
     System.out.println("5) save current list");
     System.out.println("6) quit to the main menu");
     System.out.println("> ");
    }
}
