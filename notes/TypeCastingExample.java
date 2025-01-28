public class TypeCastingExample {
    public static void main(String[] args) {
        // Implicit Casting
        int num = 10;
        double converted = num; // int to double
        System.out.println("Implicit Casting: " + converted);

        // Explicit Casting
        double pi = 3.14159;
        int truncated = (int) pi; // double to int
        System.out.println("Explicit Casting: " + truncated);
    }
}
