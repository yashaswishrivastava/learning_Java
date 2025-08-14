class Car {
    String model;
    String color;
    int year;

    // Default constructor
    public Car() {
        this("Unknown Model", "Unknown Color", 0);
        System.out.println("Default Constructor called.");
    }

    // Parameterized constructor
    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
        System.out.println("Parameterized Constructor called.");
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(); // Calls default constructor
        Car car2 = new Car("Tesla Model S", "Red", 2024); // Calls parameterized constructor

        // Using a switch case to demonstrate different actions based on the car's year
        switch (car2.year) {
            case 2022:
                System.out.println("This car is from the year 2022.");
                break;
            case 2023:
                System.out.println("This car is from the year 2023.");
                break;
            case 2024:
                System.out.println("This car is from the year 2024.");
                break;
            default:
                System.out.println("This car's year is unknown or not listed.");
                break;
        }

        // Display details of both cars
        System.out.println("\nDetails of car1:");
        car1.displayDetails();

        System.out.println("\nDetails of car2:");
        car2.displayDetails();
    }
}
