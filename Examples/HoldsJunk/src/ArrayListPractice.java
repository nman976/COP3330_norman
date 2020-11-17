import java.util.ArrayList;
public class ArrayListPractice {
    public static void main(String[] args){
        ArrayList<String> items = new ArrayList<String>();
        items.add("red");
        items.add(0, "yellow");

        //header
        System.out.print("Display contents with counter controlled loop: \n");

        for (int i = 0; i < items.size(); i++){
            System.out.printf("%s\n", items.get(i));
        }
        items.add("green");
        items.add("yellow");
        for (int i = 0; i < items.size(); i++){
            System.out.printf("%s\n", items.get(i));
        }
        items.remove("yellow");

    }
}
