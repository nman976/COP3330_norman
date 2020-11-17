import java.lang.Math;
public class Foo {
    private int x = 5;
    int y;
    double h;
    double w;


    // instance
    public void upset() {
        System.out.println(x);
    }

    public int bar(int x) {
        return x + 2;
    }
    public double squareRt (int y){
        double sqrtz = Math.sqrt(y);
        return sqrtz;
    }

    public double squarer (int y){
        return y * y;
    }

    public double calculateBMIScore(double w, double h){
        double bmiScore = (703 * w) / (h * h);
        bmiScore = bmiScore *100;              // this sets a to 354.555555
        bmiScore =Math.floor(bmiScore);      // this sets a to 354
        bmiScore = bmiScore /100;
        return bmiScore;
    }
    // static
    public static void upsetAgain(Foo f) {
        System.out.println(f.y);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        // class field var x
        // shadowing
        this.x = x;
    }
}