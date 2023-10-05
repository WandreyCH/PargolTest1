import java.util.Scanner;

public class Computer {
    // Final Project

    // Wandrey Cabidele Haagensen

    // Written by: Wandrey Cabidele Haagensen ID: 2391694

    // Declare variables

    private String brand;
    private String model;
    private Double price;
    private long serialNumber;
    private static int serialNumberCounter = 1000;
    private static int computercounter = 0;


    // Create a constructor for brand, model, price and Serial Number

    public Computer(String br, String m, double pr) {

        brand = br;
        model = m;
        price = pr;
        serialNumber = serialNumberCounter;
        serialNumberCounter++;

        // inicializar

    }
    // make getter and setter

    public String getBrand() {

        return brand;

    }

    public void setBrand(String br) {
        brand = br;

    }

    public String getModel() {
        return model;

    }

    public void setModel(String m) {
        model = m;

    }

    public Double getPrice() {
        return price;

    }

    public void setPrice(Double pr) {
        price = pr;

    }

    public long getSerialNumber() {
        return serialNumber;

    }

    public void setSerialNumber(long sn) {
        serialNumber = sn;

    }

    public void displayComputer() {

        System.out.println(" == the info is : ");
        System.out.println(" the computer brand is : " + this.getBrand());
        System.out.println(" the computer price is : " + this.getPrice());
        System.out.println(" the computer model is : " + this.getModel());
        System.out.println(" the computer serial number is : " + this.getSerialNumber());


    }

    @Override

    public String toString() {

        return "Computer [brand = " + brand + ", model = " + model + ", price = " + price + ", serialNumber = " + serialNumber
                + "]";

    }

    public static int findNumberOfCreatedComputers() {
        return computercounter;

    }

    public boolean equal(Computer c) {

        if (brand == c.getBrand() && model == c.getModel() && price == c.getPrice()) {

            return true;

        } else {

            return false;

        }
    }

    public static boolean checkPassword(Scanner kb) {
        int PassTry = 0;
        while (PassTry < 3) {
            String Password = kb.next();
            PassTry++;
            if (Password.equals("password")) {
                return true;
            } else if (PassTry <= 2) {
                System.out.println("Invalid Password, try again.");
            }

        }
        return false;
    }

    public static void DisplayMenu() {
        System.out.println("What do you want?");
        System.out.println("    1. Enter new computers (Password Required) ");
        System.out.println("    2. Change information of a computer (password required) ");
        System.out.println("    3. Display all computers by a specific brand ");
        System.out.println("    4. Display all computers under a certain a price. ");
        System.out.println("    5. Quit ");
        System.out.println("Please enter your choice > ");
    }

    public static void ChangeMenu() {
        System.out.println("What information would you like to change?");
        System.out.println("    1. Brand ");
        System.out.println("    2. Model ");
        System.out.println("    3. Sn ");
        System.out.println("    4. Price ");
        System.out.println("    5. Quit ");
        System.out.println("Enter your choice > ");
    }
}
