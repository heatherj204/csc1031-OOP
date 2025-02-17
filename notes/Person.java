public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding the toString method
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// public class Main {
//     public static void main(String[] args) {
//         Person person = new Person("Alice", 30);

//         // Using the overridden toString method
//         System.out.println(person); // Automatically calls person.toString()
//     }
// }