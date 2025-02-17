import java.util.ArrayList;
import java.util.List;

public class DeepCopyPerson {
    private String name;
    private List<String> hobbies;

    public DeepCopyPerson(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = new ArrayList<>(hobbies); // Deep copy of the list
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', hobbies=" + hobbies + '}';
    }
}

// public class Main {
//     public static void main(String[] args) {
//         List<String> hobbies = new ArrayList<>();
//         hobbies.add("Reading");
//         hobbies.add("Swimming");

//         DeepCopyPerson original = new DeepCopyPerson("Alice", hobbies);
//         DeepCopyPerson deepCopy = new DeepCopyPerson("Alice", hobbies); // Deep copy

//         // Modify the original list
//         hobbies.add("Gaming");

//         System.out.println(original); // Person{name='Alice', hobbies=[Reading, Swimming, Gaming]}
//         System.out.println(deepCopy); // Person{name='Alice', hobbies=[Reading, Swimming]}
//     }
// }