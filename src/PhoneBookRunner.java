import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBookRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 4;
        String name;
        String number;
        Map<String, String> phoneBook = new TreeMap<>();

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
                    System.out.println("Please enter the name: ");
                    name = scanner.nextLine();
                    if (phoneBook.containsKey(name)) {
                        System.out.println("That name already exists in your phone book !" +
                                "\n press 1 if you want to keep editing their number." +
                                "\n press any key to return to main menu.");
                        try{
                            userInput = scanner.nextInt();}
                        catch (InputMismatchException e){
                            System.out.println("Please!!! only enter specified numbers!");
                            scanner.nextLine();
                            break;
                        }
                        scanner.nextLine();
                        if (userInput == 1){
                            System.out.println("Please enter the phone number: ");
                            number = scanner.nextLine();
                            if (number.matches("^09\\d{9}$"))
                                phoneBook.put(name, number);
                            else{
                                System.out.println("That number is not valid please enter a valid one next time!");
                            }
                        }
                        else
                            scanner.nextLine();
                    } else {
                        System.out.println("Please enter the phone number: ");
                        number = scanner.nextLine();
                        if (number.matches("^09\\d{9}$"))
                            phoneBook.put(name, number);
                        else{
                            System.out.println("That number is not valid please enter a valid one next time!");
                        }
                    }
                    break;
                case 2:
                    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                        System.out.println("name: " + entry.getKey() + ", number: " + entry.getValue());
                    }
                    System.out.println("**************************");
                    break;
                default:
                    System.out.println("That's not a possible action.");
            }

        }

    }
}
