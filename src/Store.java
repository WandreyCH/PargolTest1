import java.awt.*;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {

        //  Computer c1 = new Computer ("apple", "MAC PRO" ,3000);
        //  Computer c2 = new Computer ("Dell", "SuperDell", 2000);
        //  c1.displayComputer(c1);
        //  c2.displayComputer(c2);
        //  System.out.println(c1.equal(c2));
        //  if (c1.equal(c2)){
        //      System.out.println("The computers are equal");
        //  } else
        //      System.out.println("The computers are different");

        boolean passwordIsValid = false;
        int newComp = 0;
        int selectedComp;
        int e, d;
        int numComp = 0;
        int passcounter = 0;
        int maxComp;
        int ab = 0;
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to my Computer Store!");
        do {
            System.out.println("Please give me the maximum size of the store inventory: ");
            maxComp = kb.nextInt();
            if (maxComp <= 0) {
                System.out.println("Invalid Entry! The number should be positive: ");
            }
        } while (maxComp <= 0);

        Computer[] inventory = new Computer[maxComp];

        do {
            Computer.DisplayMenu();
            e = kb.nextInt();

            switch (e) {
                case 1 -> {
                    do {
                        System.out.println("Please input your password: ");
                        if (Computer.checkPassword(kb)) {
                            passwordIsValid = true;
                            System.out.println("How many computers you want to enter? ");
                            newComp = kb.nextInt();
                            passcounter++;
                            ab = numComp + newComp;
                            if (ab <= maxComp) {
                                for (int i = numComp; i < ab; i++) {
                                    inventory[i] = new Computer("Dell", "k100", i*1000);
                                }
                            }
                        } else {
                            passwordIsValid = false;
                            passcounter++;
                        }

                        if (numComp + newComp <= maxComp && passwordIsValid) {
                            numComp += newComp;
                            System.out.println("You now have: " + numComp + " Computers stored.");
                        } else {
                            System.out.println("You are trying to store " + newComp + " but you can not store more than " + maxComp + " computers");
                        }
                        int AvailableSpace = maxComp - numComp;
                        if (AvailableSpace < maxComp && passwordIsValid) {
                            System.out.println("You can store " + AvailableSpace + " more computers");
                        }
                        if (AvailableSpace > maxComp && passwordIsValid) {
                            System.out.println("You are trying to store " + newComp + " but you can not store more than " + maxComp + " computers");
                        }
                    } while (passcounter < 1);
                }


                case 2 -> {
                    System.out.println("Please input your password: ");
                    if (Computer.checkPassword(kb)) {
                        passwordIsValid = true;
                        System.out.println("Please input the number of the computer you want to modify: ");
                        selectedComp = kb.nextInt();
                        kb.nextLine();
                        if (selectedComp >= 0 && selectedComp < inventory.length - 1) {
                            Computer computer = inventory[selectedComp];
                            if (computer != null) {
                                System.out.println("Computer # " + selectedComp);
                                computer.displayComputer();
                            } else {
                                System.out.println("No computer found at index " + selectedComp);
                            }
                            do {
                                Computer.ChangeMenu();
                                d = kb.nextInt();

                                switch (d) {
                                    case 1 -> {
                                        System.out.println("Please input the brand ");
                                        String brand = kb.next();
                                        kb.nextLine();
                                        inventory[selectedComp].setBrand(brand);
                                    }
                                    case 2 -> {
                                        System.out.println("Please input the model ");
                                        String model = kb.next();
                                        kb.nextLine();
                                        inventory[selectedComp].setModel(model);
                                    }
                                    case 3 -> {
                                        System.out.println("Please input the SN ");
                                        Long sn = kb.nextLong();
                                        kb.nextLine();
                                        inventory[selectedComp].setSerialNumber(sn);
                                    }
                                    case 4 -> {
                                        System.out.println("Please input the Price ");
                                        double price = kb.nextDouble();
                                        kb.nextLine();
                                        inventory[selectedComp].setPrice(price);
                                    }
                                    case 5 -> {
                                    }
                                }
                            } while (d != 5);
                        }
                        if (selectedComp <= inventory.length - 1 && inventory[selectedComp] == null) {
                            System.out.println("Do you want to add more computers? (y/n)");
                            String answer = kb.next();
                            if (answer.equals("y")) {
                                for (int i = numComp; i < ab; i++) {
                                    inventory[i] = new Computer("Dell", "k100", 800.0);
                                }
                            } else if (answer.equals("n")) ;
                        }

                    }
                }

                case 3 -> {
                    System.out.println("Please tell me the brand you are looking for: ");
                    String brand = kb.next();
                    kb.nextLine();
                    for (int i = 0; i < numComp; i++) {
                        if (inventory[i] != null && inventory[i].getBrand().equals(brand)) {
                            System.out.println(inventory[i].toString());
                        }
                    }
                        }

                    case 4 -> {
                        System.out.println("Please tell me the value you are looking for: ");
                        double value = kb.nextDouble();
                        kb.nextLine();
                        for (int i = 0; i < numComp; i++) {
                            if (inventory[i] != null && inventory[i].getPrice() < value) {
                                System.out.println(inventory[i].toString());
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("Thanks for using my program.");
                    }

                    }
        } while (e != 5);

                }

            }

