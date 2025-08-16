import java.util.Scanner;

class Item {
    // Static variable to count the number of items (objects) created
    static int itemCount = 0;

    // Instance variables
    String itemName;
    double itemPrice;

    // Default constructor
    Item() {
        itemCount++;
        this.itemName = "Unknown";
        this.itemPrice = 0.0;
        System.out.println("Item created with default constructor.");
    }

    // Constructor with parameters
    Item(String name, double price) {
        itemCount++;
        this.itemName = name;
        this.itemPrice = price;
        System.out.println("Item created with parameterized constructor: " + name + ", Price: $" + price);
    }

    // Constructor accepting an existing object
    Item(Item item) {
        itemCount++;
        this.itemName = item.itemName;
        this.itemPrice = item.itemPrice;
        System.out.println("Item created by copying: " + item.itemName + ", Price: $" + item.itemPrice);
    }

    // Static method to return the number of items created
    static int getItemCount() {
        return itemCount;
    }

    // Method to create an array of Item objects
    static Item[] createItemArray(int n) {
        Item[] itemArray = new Item[n];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name and price of item " + (i + 1) + ": ");
            String name = scanner.next();
            double price = scanner.nextDouble();
            itemArray[i] = new Item(name, price);
        }
        return itemArray;
    }
}

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Item item1 = null, item2 = null; // Declare objects

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create an item using default constructor");
            System.out.println("2. Create an item using parameterized constructor");
            System.out.println("3. Create an item using copy constructor");
            System.out.println("4. Create an array of items");
            System.out.println("5. Display number of items created");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    item1 = new Item(); // Create an item using default constructor
                    break;

                case 2:
                    System.out.println("Enter the item name: ");
                    String name = scanner.next();
                    System.out.println("Enter the item price: ");
                    double price = scanner.nextDouble();
                    item1 = new Item(name, price); // Create an item using parameterized constructor
                    break;

                case 3:
                    if (item1 != null) {
                        item2 = new Item(item1); // Create an item using copy constructor
                    } else {
                        System.out.println("Create an item first using the parameterized constructor.");
                    }
                    break;

                case 4:
                    System.out.println("Enter the number of items to create in the array:");
                    int n = scanner.nextInt();
                    Item[] itemArray = Item.createItemArray(n);
                    System.out.println(n + " items created and stored in an array.");
                    break;

                case 5:
                    System.out.println("Number of items created: " + Item.getItemCount());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
