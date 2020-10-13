public abstract class Shape3D extends Shape {

    protected String name;
    protected double a, b, c, h1, h2;

    // extra method in Shape3D not found in superclass
    public abstract double getVolume();
    //Constructor that initializes variables for Shape3D
    protected Shape3D() {
        double a, b, c, h1, h2;
    }
}
    // Cube class extending from Shape3D
    class Cube extends Shape3D{
        Cube(double a){
            this.a = a;
        }
        public String getName() {
            return "cube";
        }
        public double getArea(){
            return 6 * a * a;
        }
        public double getVolume(){
            return a * a * a;
        }
    }


    // Sphere class extending from Shape3D
    class Sphere extends Shape3D{
        Sphere(double a){
            this.a = a;
        }
        public String getName() {
            return "sphere";
        }
        public double getArea(){
            return 4 * Math.PI * a * a;
        }
        public double getVolume(){
            return (4 * Math.PI * a * a * a)/3;
        }
    }


    // Pyramid class extending from Shape3D
    class Pyramid extends Shape3D{
        Pyramid(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public String getName() {
            return "pyramid";
        }
        public double getArea(){
            h1 = Math.sqrt((c*c)+((b/2)*(b/2)));
            h2 = Math.sqrt((c*c)+((a/2)*(a/2)));
            return a*b + h1*a + h2*b;
        }
        public double getVolume(){
            return (a * b * c)/3;
        }
    }
