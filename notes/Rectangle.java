public class Rectangle {
    private int width;
    private int height;

    // Default constructor
    public Rectangle() {
        this.width = 1;
        this.height = 1; // Default dimensions
    }

    // Constructor with one parameter
    public Rectangle(int size) {
        this.width = size;
        this.height = size; // Square dimensions
    }

    // Constructor with two parameters
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

// public class Main {
//     public static void main(String[] args) {
//         Rectangle defaultRectangle = new Rectangle();
//         Rectangle square = new Rectangle(5);
//         Rectangle customRectangle = new Rectangle(4, 8);

//         System.out.println(defaultRectangle); // Rectangle{width=1, height=1}
//         System.out.println(square); // Rectangle{width=5, height=5}
//         System.out.println(customRectangle); // Rectangle{width=4, height=8}
//     }
// }
