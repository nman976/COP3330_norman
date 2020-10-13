public abstract class Shape2D extends Shape {
    protected String name;
    protected double a, b;

    protected Shape2D() {
        double a;
        double b;
    }
}
    // Square class extending from Shape2D
    class Square extends Shape2D{
        Square(double a) {
            this.a = a;
        }
        public String getName() {
            return "square";
        }
        public double getArea(){
            return a * a;
        }
    }


    //Circle class extending from Shape2D
    class Circle extends Shape2D{
        Circle(double a) {
            this.a = a;
        }
        public String getName() {
            return "circle";
        }
        public double getArea(){
            return Math.PI *(a*a);
        }
    }

    //Triangle class extending from Shape2D
    class Triangle extends Shape2D {
        Triangle(double a, double b) {
            this.a = a;
            this.b = b;
        }
        public String getName() {
            return "triangle";
        }
        public double getArea() {
            return 0.5 * a * b;
        }
    }