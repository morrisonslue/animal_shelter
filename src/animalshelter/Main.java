package animalshelter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AnimalShelter shelter = new AnimalShelter();
        boolean running = true;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("First Come First Serve Animal Shelter");

        while (running) {
            System.out.println("\nchoose an option:");
            System.out.println("1 - add an animal");
            System.out.println("2 - adopt any animal");
            System.out.println("3 - adopt a dog");
            System.out.println("4 - adopt a cat");
            System.out.println("5 - exit");
            System.out.print("your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 1) {
                // input type
                System.out.print("enter animal type (dog or cat): ");
                String type = scanner.nextLine();

                // input name
                System.out.print("enter animal name: ");
                String name = scanner.nextLine();

                // input arrival time
                System.out.print("enter arrival date and time (yyyy-MM-dd HH:mm): ");
                String datetimeInput = scanner.nextLine();

                LocalDateTime arrivalTime;
                try {
                    arrivalTime = LocalDateTime.parse(datetimeInput, formatter);
                    Animal a = new Animal(name, type, arrivalTime);
                    shelter.enqueue(a);
                    System.out.println(name + " the " + type + " was added.");
                } catch (Exception e) {
                    System.out.println("invalid date and time format.");
                }

            } else if (choice == 2) {
                Animal adopted = shelter.dequeueAny();
                if (adopted != null) {
                    System.out.println("you adopted " + adopted.getName() + " the " + adopted.getType());
                } else {
                    System.out.println("no animals available");
                }

            } else if (choice == 3) {
                Animal dog = shelter.dequeueDog();
                if (dog != null) {
                    System.out.println("you adopted " + dog.getName() + " the dog");
                } else {
                    System.out.println("no dogs available");
                }

            } else if (choice == 4) {
                Animal cat = shelter.dequeueCat();
                if (cat != null) {
                    System.out.println("you adopted " + cat.getName() + " the cat");
                } else {
                    System.out.println("no cats available");
                }

            } else if (choice == 5) {
                running = false;
                System.out.println("goodbye");
            } else {
                System.out.println("invalid choice");
            }
        }

        scanner.close();
    }
}

