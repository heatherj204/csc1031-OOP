// import java.util.ArrayList;
import java.util.List;

public class ShallowCopyPerson {
    private String name;
    private List<String> hobbies;

    public ShallowCopyPerson(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies; // Shared reference
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

//         ShallowCopyPerson original = new ShallowCopyPerson("Alice", hobbies);
//         ShallowCopyPerson shallowCopy = new ShallowCopyPerson("Alice", hobbies); // Shallow copy

//         // Modify the shared list
//         hobbies.add("Gaming");

//         System.out.println(original); // Person{name='Alice', hobbies=[Reading, Swimming, Gaming]}
//         System.out.println(shallowCopy); // Person{name='Alice', hobbies=[Reading, Swimming, Gaming]}
//     }
// }