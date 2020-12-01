package App;
import java.util.Scanner;

public class MainMenu  {

    Scanner input = new Scanner(System.in);
    public void loop() throws Exception {
        while (true) {
            printMainMenu();
            String in = input.nextLine();
            if (in.equals("1")) {
                new TaskApp().taskMainLoop(input);
            } else if (in.equals("2")) {
                new ContactApp().contactMainLoop(input);
            } else if (in.equals("3")) {
                System.exit(0);
            } else {
                System.out.println("Enter 1, 2 or 3.");
            }
        }
    }
    public void printMainMenu(){
        System.out.println("Select Your Application");
        System.out.println("-----------------------");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
        System.out.println(">");
    }
}