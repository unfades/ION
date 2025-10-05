abstract interface Printable{
  public abstract String print();
}

abstract class Polygon{
  private String shape;
  protected double width, length;
  private double side1, side2;
      
  public Polygon(){
    this.shape = null;
    this.width = 0.0;
    this.length = 0.0;
    this.side1 = 0.0;
    this.side2 = 0.0;
  }
  public Polygon(String shape, double side1, double side2){
    this.shape = shape;
    this.side1 = side1;
    this.side2 = side2;
  }
  
  public abstract double area();

  public void display () {
    System.out.println("My shape is a " + this.shape + " Its sides are " + this.side1 + " and " + this.side2); 
  }
}

class Square extends Polygon implements Printable{ 

  private String shape;
  private double side1, side2;  
  // constructor
  public Square() {   
    shape = null;
    side1 = 0.0;
    side2 = 0.0;
  }

  public Square(String shape, double side1, double side2) {
    super(shape, side1, side2);
    this.shape = shape;
    this.side1 = side1;
    this.side2 = side2;
  }
  @Override
  public double area () {
    return this.side1 * this.side2; 
  }
  @Override
  public String print(){
    return "********\n********\n********\n********";
  }
  public void display () { 
    System.out.println("My shape is a " + this.shape + " Its sides are " + this.side1 + " and " + this.side2); 
  }
}

class Trapezoid extends Polygon implements Printable{ 
    
  private String shape;
  private double side1, side2, height;  
  // constructor
  public Trapezoid() {   
    shape  = null;
    side1  = 0.0;
    side2  = 0.0;
    height = 0.0;
  }

  public Trapezoid(String shape, double side1, double side2, double height) {
    super(shape, side1, side2);
    this.shape = shape;
    this.side1 = side1;
    this.side2 = side2;
    this.height = height;
  }
  @Override
  public double area () {
    return this.height*(this.side1 + this.side2)/2;
  }
  @Override
  public String print(){
    return "   ****\n  ******\n ********\n**********";
  }
  public void display () { 
    System.out.println("My shape is a " + this.shape + " Its sides are " + this.side1 + " and " + this.side2); 
  }
}

class Rhombus extends Polygon implements Printable{ 
    
  private String shape;
  private double side1, side2;  
  // constructor
  public Rhombus() {
    shape = null;
    side1 = 0.0;
    side2 = 0.0;
  }

  public Rhombus(String shape, double side1, double side2) {
    super(shape, side1, side2);
    this.shape = shape;
    this.side1 = side1;
    this.side2 = side2;
  }
  @Override
  public double area () {
    return (this.side1 * this.side2)/2;
  }
  @Override
  public String print(){
    return " *******\n  *******\n   *******";
  }
  public void display () { 
    System.out.println("My shape is a " + this.shape + " Its sides are " + this.side1 + " and " + this.side2); 
  }
}

class Triangle extends Polygon implements Printable{
  private String shape;
  private double side1, side2;

  public Triangle(){
    this.shape = null;
    this.side1 = 0.0;
    this.side2 = 0.0;
  }
  public Triangle(String shape, double side1, double side2) {
    super(shape, side1, side2);
    this.shape = shape;
    this.side1 = side1;
    this.side2 = side2;
  }
  @Override
  public double area() {
    return 0.5 * side1 * side2;
  }
  @Override
  public String print(){
    return "   *\n  ***\n *****\n*******";
  }
  public void display () { 
    System.out.println("My shape is a " + this.shape + " Its sides are " + this.side1 + " and " + this.side2); 
  }
}

public class MainClass {
  public static void main(String args[]) { 
    Polygon square = new Square("Square", 10, 10);
    square.display();
    
    Square s = new Square("Square", 10, 10);
    System.out.println("The area of the square is " + s.area());
    System.out.println(s.print());
    
    Rhombus rh = new Rhombus("Rhombus", 10, 10);
    System.out.println("The area of the Rhombus is " + rh.area());
    System.out.println(rh.print());
    
    Trapezoid tr = new Trapezoid("Trapezoid", 10, 10,4);
    System.out.println("The area of the Trapezoid is " + tr.area());
    System.out.println(tr.print());
    
    Triangle t  = new Triangle("Triangle", 60, 2);
    System.out.println(t.print());
    System.out.println("The area of the Triangle is " + t.area());
  }
}
