public class BodyMassIndex {
    double height;
    double weight;
    double bmiScore;
    String bmiCat;
    public BodyMassIndex(double height, double weight){
        //these actualize the parameters for each object/instance we construct
        this.height = height;
        this.weight = weight;


    }
    // make public method to calculate BMI score
    public double calculateBMIScore(){
        bmiScore = (703 * this.weight) / (this.height * this.height);
        return bmiScore;
    }
    public String findBmiCategory(){
        if (bmiScore < 18.5){
            bmiCat = "Underweight";
        }
        else if (bmiScore > 24.9 && bmiScore <=29.9) {
            bmiCat =  "Overweight";
        }
        else if (bmiScore >= 30){
            bmiCat =  "obesity";
        }
        return bmiCat;
    }
}