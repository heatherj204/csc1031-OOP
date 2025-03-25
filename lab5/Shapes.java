
abstract class Shape {
    protected String color;

    Shape(String color){
        this.color = color;
    }

    public void displayColor(){
        System.out.println("Shape color: " + this.color );
    }

    abstract double getArea();

}

// Subclass Circle
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);

        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 0;
        }
    }

    @Override
    public double getArea(){
        return Math.PI * (this.radius * this.radius);
    }
}

// Subclass Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;
    // Constructor
    public Rectangle(String color, double width, double height) {
        super(color);

        this.height = height < 0 ? 0 : height;
        this.width = width < 0 ? 0 : width;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}