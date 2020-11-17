public class CalcHelper {

	//Its public (class modifier), static (can be called from class itself and not just an instance), returns a double
	public static double addValues(double d1, double d2){
		return d1 + d2;

	}
	public static double subbtractValues(double d1, double d2){
		return d1 - d2;

	}
	public static double multiplyValues(double d1, double d2){
		return d1 * d2;

	}
	public static double divideValues(double d1, double d2){
		return d1 / d2;

	}


}

public class Main {
	private int hiFive;
	public static void main(String args[]){
		hiFive = 5;
		System.out.println("hi" + hiFive);
	}
}