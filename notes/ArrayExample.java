public class ArrayExample {
    public static void main(String[] args) {
        // Declaration and initialization
        int[] numbers = {1, 2, 3, 4, 5};

        // Accessing elements
        System.out.println("First number: " + numbers[0]); // Output: 1

        // Modifying an element
        numbers[2] = 10;

        // Iterating through the array
        System.out.println("Array elements:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
