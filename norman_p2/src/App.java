// App.java Program that calculates BMI
import java.util.Scanner;
import java.util.ArrayList;
public class App{
    public static void main(String[] args) {

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();
            BodyMassIndex bmi = new BodyMassIndex(height, weight);

            bmiData.add(bmi);
            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static boolean moreInput() {
        System.out.println("Would you like to add more data? (Y/N)");
        Scanner keepGoing = new Scanner(System.in);
        String c = keepGoing.nextLine();
        boolean d = false;
        if (c.equals("Y")){
            d = true;
        }
        else if (c.equals("N")) {
            d = false;}
        else {
            System.out.println("Sorry, but you must enter Y or N. Please Try again");
            c = keepGoing.nextLine();
        }
        return d;
    }


    public static double getUserHeight(){
        //Names a new scanner
        Scanner getHeight = new Scanner(System.in);
        System.out.println("Enter height in inches:");
        //Creates a new double "height" to be used
        double height = getHeight.nextDouble();
        //Test input for valid value
        while (height < 0){
            System.out.println("Sorry, but you must input a positive value. Please Try again");
            height = getHeight.nextDouble();
        }
        // Return validated input
        return height;
    }
    public static double getUserWeight(){
        //Make Scanner to get input
        Scanner getWeight = new Scanner(System.in);
        System.out.println("Enter Weight in lbs:");
        double weight = getWeight.nextDouble();
        //Test input for valid value
        while (weight < 0) {
            System.out.println("Sorry, but you must input a positive value. Please Try again");
            weight = getWeight.nextDouble();
        }
        // Return validated input
        return weight;
    }
    public static void displayBmiInfo(BodyMassIndex bmi){

        double bmiScore = bmi.calculateBMIScore();
        String bmiCat = bmi.findBmiCategory();
        System.out.println("Bmi Score: " + bmiScore + "\n" + "Bmi category: " + bmiCat +"\n");

    }
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiList){
        double sum = 0;
        for (BodyMassIndex bmi : bmiList){
            sum += bmi.calculateBMIScore();
        }
        double average = sum / bmiList.size();
        System.out.print("Average Bmi value: ");
        System.out.print(average + "\n");
    }
}


