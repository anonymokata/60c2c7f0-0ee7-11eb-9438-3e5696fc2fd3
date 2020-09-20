import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your start time (Format: 5 PM): ");
        String startInput = scanner.nextLine();
        // Catching the startTime input into string array and
        // splitting into integer and am/pm
        String[] startTimeEntered = startInput.split(" ");
        // Take start time and parse first string array index into int
        // and if the second array index equals PM add 12 otherwise 0
        Integer startTime = Integer.parseInt(startTimeEntered[0])
                + (startTimeEntered[1].equalsIgnoreCase("PM") ? 12
                : 0);

        // End Time
        System.out.println("Enter your end time (4 AM): ");
        String endInput = scanner.nextLine();
        String[] endTimeEntered = endInput.split(" ");
        Integer endTime = Integer.parseInt(endTimeEntered[0])
                + (endTimeEntered[1].equalsIgnoreCase("PM") ? 12
                : 0);

        // Getting the familyLetter input
        System.out.println("Enter what family you babysat for (Options: A, B, C): ");
        String familyLetter = scanner.nextLine();

        // Instantiate FamilyPayRate object using default constructor
        FamilyPayRate familyPay = new FamilyPayRate(0);

        // Switch case for family pay method to be used
        switch(familyLetter) {
            case "A":
                // catch it and print it
                int cost = familyPay.familyAPay(startTime, endTime);
                System.out.println("Your nightly pay is $" + cost);
                break;
            case "B":
                cost = familyPay.familyBPay(startTime, endTime);
                System.out.println("Your nightly pay is $" + cost);
                break;
            case "C":
                cost = familyPay.familyCPay(startTime, endTime);
                System.out.println("Your nightly pay is $" + cost);
                break;
            default:
                System.out.println("You have entered a wrong family.");
        }
    }
}
