import java.util.*;

public class OnlineGroceryMarket {

    // Create a list of available grocery items
    private static List<String> groceryItems = Arrays.asList("Apples", "Bananas", "Oranges", "Milk", "Bread", "Eggs");

    public static void main(String[] args) {
        // Create a new scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Display the available grocery items
        System.out.println("Welcome to the Online Grocery Market!");
        System.out.println("Here are the available grocery items:");
        for (int i = 0; i < groceryItems.size(); i++) {
            System.out.println((i + 1) + ". " + groceryItems.get(i));
        }

        // Create an empty list to store the user's selected items
        List<String> selectedItems = new ArrayList<String>();

        // Allow the user to select grocery items
        while (true) {
            System.out.println("Please enter the number of the item you would like to add to your cart (or enter 0 to checkout):");
            int itemNumber = scanner.nextInt();

            if (itemNumber == 0) {
                break;
            }

            if (itemNumber < 1 || itemNumber > groceryItems.size()) {
                System.out.println("Invalid item number. Please try again.");
            } else {
                String selectedItem = groceryItems.get(itemNumber - 1);
                selectedItems.add(selectedItem);
                System.out.println(selectedItem + " has been added to your cart.");
            }
        }

        // Display the user's selected items and calculate the total cost
        double totalCost = 0.0;
        System.out.println("Here are your selected items:");
        for (String item : selectedItems) {
            double itemCost = getItemCost(item);
            System.out.println("- " + item + " (Rs. " + itemCost + ")");
            totalCost += itemCost;
        }
        System.out.println("Total cost: Rs. " + totalCost);

        // Close the scanner
        scanner.close();
    }

    // Get the cost of a grocery item
    private static double getItemCost(String item) {
        switch (item) {
            case "Apples":
                return 80.0;
            case "Bananas":
                return 30.0;
            case "Oranges":
                return 100.0;
            case "Milk":
                return 60.0;
            case "Bread":
                return 40.0;
            case "Eggs":
                return 90.0;
            default:
                return 0.0;
        }
    }
}