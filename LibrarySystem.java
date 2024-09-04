import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display Available Books");
            System.out.println("7. Display Users");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    Book newBook = new Book(title, author, isbn);
                    library.addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    User newUser = new User(name, userId);
                    library.addUser(newUser);
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    isbn = scanner.nextLine();
                    User user = library.findUserById(userId);
                    Book book = library.findBookByISBN(isbn);
                    if (user != null && book != null) {
                        user.borrowBook(book);
                    } else {
                        System.out.println("Invalid user ID or book ISBN.");
                    }
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    isbn = scanner.nextLine();
                    user = library.findUserById(userId);
                    book = library.findBookByISBN(isbn);
                    if (user != null && book != null) {
                        user.returnBook(book);
                    } else {
                        System.out.println("Invalid user ID or book ISBN.");
                    }
                    break;
                case 5:
                    library.displayAllBooks();
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    library.displayUsers();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
