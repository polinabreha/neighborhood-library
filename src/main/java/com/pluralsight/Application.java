package com.pluralsight;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = {
                new Book(1,  "978-0-7432-7356-5", "The Great Gatsby"),
                new Book(2,  "978-0-06-112008-4", "To Kill a Mockingbird"),
                new Book(3,  "978-0-14-028329-7", "Seven husbands of Evelyn Hugo" ),
                new Book(4,  "978-0-7432-7357-2", "Of Mice and Men"),
                new Book(5,  "978-0-06-093546-9", "The Catcher in the Rye"),
                new Book(6,  "978-0-7432-7358-9", "Brave New World"),
                new Book(7,  "978-0-14-243723-0", "The Odyssey"),
                new Book(8,  "978-0-06-112009-1", "Lord of the Flies"),
                new Book(9,  "978-0-7432-7359-6", "Animal Farm"),
                new Book(10, "978-0-14-028330-3", "Fahrenheit 451"),
                new Book(11, "978-0-06-112010-7", "The Grapes of Wrath"),
                new Book(12, "978-0-7432-7360-2", "East of Eden"),
                new Book(13, "978-0-14-243724-7", "Crime and Punishment"),
                new Book(14, "978-0-06-112011-4", "The Brothers Karamazov"),
                new Book(15, "978-0-7432-7361-9", "Jane Eyre"),
                new Book(16, "978-0-14-028331-0", "Pride and Prejudice"),
                new Book(17, "978-0-06-112012-1", "Wuthering Heights"),
                new Book(18, "978-0-7432-7362-6", "The Scarlet Letter"),
                new Book(19, "978-0-14-243725-4", "Moby Dick"),
                new Book(20, "978-0-06-112013-8", "Don Quixote")
        };


        boolean runningTheProgram = true;

        while (runningTheProgram) {
            System.out.println("-------Welcome at the Library!-------");
            System.out.println("\tWhat would you like to do?");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            if (choice == 1) {
                for (int i = 0; i < books.length; i++) {
                    if (!books[i].isCheckedOut()) {
                        System.out.println(books[i].getId() + " Isbn:" +
                                books[i].getIsbn() + "\n Title: " +
                                books[i].getTitle());
                    }
                }
                System.out.print("Enter book ID to check out or 0 to go back: ");
                int selectedId = scanner.nextInt();
                scanner.nextLine();
                if (selectedId > books.length || selectedId < 1) {
                    System.out.println("Please enter a valid book ID:");
                    continue;

                }
                boolean found = false;

                if(selectedId != 0){
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].getId() == selectedId) {
                            if (books[i].isCheckedOut()) {
                                System.out.println("This book is already checked out!");
                            } else {
                                System.out.print("Enter your name: ");
                                String name = scanner.nextLine();

                                books[i].checkOut(name);
                                found = true;
                            }
                            break;
                        }
                        if (!found) {
                            System.out.println("Book not found. Please try again.");
                        } else {
                            System.out.println("\t Great choice ");
                            System.out.println("Book Checked Out Successfully!");
                        }
                    }
                }






            }else if (choice == 2) {
                for (int i = 0; i < books.length; i++) {

                    if (books[i].isCheckedOut()) {
                        System.out.println(
                                books[i].getId() + " | " +
                                        books[i].getIsbn() + " | " +
                                        books[i].getTitle() + " | Checked out to: " +
                                        books[i].getCheckedOutTo()
                        );
                    }

                }

                System.out.println("\nC - Check in a book");
                System.out.println("X - Go back to home screen");
                System.out.print("Choose option: ");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("C")) {
                    System.out.print("Enter book ID to check in: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    for (int l = 0; l < books.length; l++) {
                        if (books[l].getId() == id) {
                            books[l].checkIn();
                            System.out.println("Book checked in successfully!");
                        }else if  (option.equalsIgnoreCase("X")) {}
                    }
                }




                     } else if (choice == 3) {
                        runningTheProgram = false;
                     }


        }



    }


}
