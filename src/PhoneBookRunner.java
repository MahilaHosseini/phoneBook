import java.util.*;

public class PhoneBookRunner {
    private static List<Contact> phoneBook;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 4;
        phoneBook = new ArrayList<>();
        System.out.println("Welcome to your phone book");
        System.out.println("**************************");
        OuterLoop:while(true){
            System.out.println("Please choose an action to proceed");
            System.out.println(" press 1 to ADD NEW ITEM TO THE PHONEBOOK. " +
                    "\n press 2 to SEE ITEMS OF YOUR PHONEBOOK." +
                    "\n press 0 to EXIT.");
           try{
                userInput = scanner.nextInt();
           }
           catch (InputMismatchException e){
               System.out.println("Please!!! only enter specified numbers!");
           }
            scanner.nextLine();
            switch (userInput){
                case 0:
                    break OuterLoop;
                case 1:
                    addContact(scanner, phoneBook);
                    break;
                case 2:
                    printPhoneBook(phoneBook);
                    break;
                default:
                    System.out.println("That's not a possible action.");
            }

        }
        scanner.close();

    }

    private static void printPhoneBook(List<Contact> phoneBook) {
        for (Contact contact : phoneBook ) {
            System.out.println("name: " + contact.getName() + ", numbers: ");
            for (String number : contact.getNumbers())
                System.out.println(number);
        }
        System.out.println("**************************");
    }

    private static void addContact(Scanner scanner, List<Contact> phoneBook) {
        String name;
        String number;
        int userInput;
        boolean redundant = false;
        System.out.println("Please enter the name: ");
        name = scanner.nextLine();
        for (Contact contact : phoneBook){
            if (contact.getName().equals(name)){
                System.out.println("That name already exists in your phone book !" +
                        "\n press 1 if you want to add another number for them." +
                        "\n press any key to return to main menu.");
                try{
                    userInput = scanner.nextInt();
                    scanner.nextLine();
                }
                catch (InputMismatchException e){
                    System.out.println("Please!!! only enter specified numbers!");
                    scanner.nextLine();
                    return;
                }
                if (userInput == 1){
                    System.out.println("Please enter the phone number: ");
                    number = scanner.nextLine();
                    if (number.matches("^09\\d{9}$"))
                        contact.getNumbers().add(number);
                    else{
                        System.out.println("That number is not valid please enter a valid one next time!");
                    }
                }

                redundant = true;
                break;
            }
        }

        if (!redundant) {
            System.out.println("Please enter the phone number: ");
            number = scanner.nextLine();
            if (number.matches("^09\\d{9}$")){
                Contact contact = new Contact();
                contact.setName(name);
                contact.addNumber(number);
                phoneBook.add(contact);
            }
            else{
                System.out.println("That number is not valid please enter a valid one next time!");
            }
        }
    }
}
