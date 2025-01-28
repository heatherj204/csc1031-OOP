import java.util.ArrayList;

public class Fridge {

    int balance;
    ArrayList<String> foods;

    public Fridge(int initialBalance) {
        if (initialBalance < 0){
            System.out.println("Error");
            initialBalance = 0;
        }
        this.balance = initialBalance;
        this.foods = new ArrayList<>();
    }

    public void addFood(String item, int cost) {
        if (balance - cost < 0 || cost < 0 || item == null){
            System.out.println("Error");
        }else {
            foods.add(item);
            balance = balance - cost;
            System.out.printf("Item %s has been added to the fridge.\n", item);
        }
    }

    public void getFood(String item) {
        if (item == null){
            System.out.println("Error");
            return;
        }
        for (String fooditem : foods) {
            if (fooditem.equals(item)) {
                foods.remove(item);
                System.out.printf("Item %s has been removed from the fridge.\n", item);
                return;
            }
        }
        System.out.println("Error");
    }

    public void checkStatus() {
        System.out.println("Food items:");
        if (foods.size() == 0) {
            System.out.println("(none)");
        } else {
            for (String item : foods) {
                System.out.println(item);
            }
        }
        System.out.printf("Balance: €%d\n", balance);
    }

}