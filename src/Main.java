import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your start time (5 PM): ");
        String startInput = scanner.nextLine();
        // Catching the time and splitting into integer and am/pm
        String[] startTimeEntered = startInput.split(" ");
        // Actual start hour - parse String one - returns
        // Parsing string into an int and if it equals pm we add 12
        // if not 0
        Integer startTime = Integer.parseInt(startTimeEntered[0])
                + (startTimeEntered[1].equalsIgnoreCase("PM") ? 12
                : 0);

        // End Time
        System.out.println("Enter your end time (4 AM): ");
        String endInput = scanner.nextLine();
        String[] endTimeEntered = endInput.split(" ");
        // Parsing String array into an int
        Integer endTime = Integer.parseInt(endTimeEntered[0])
                + (endTimeEntered[1].equalsIgnoreCase("PM") ? 12
                : 0);

        // Error Handling
        System.out.println("Enter what family you babysat for (Ex. A, B, C): ");
        String familyLetter = scanner.nextLine();
        if (!(familyLetter.equals("A") || familyLetter.equals("B") ||
            familyLetter.equals("C"))) {
            System.out.println("Please enter a different letter.");
        }
        // Instantiate object
        FamilyPayRate familyPay = new FamilyPayRate(0);

        switch(familyLetter) {
            case "A":
                // catch it and print it
                int cost = familyPay.familyAPay(startTime, endTime);
                System.out.println(cost);
                break;
            case "B":
                cost = familyPay.familyBPay(startTime, endTime);
                System.out.println(cost);
                break;
            case "C":
                cost = familyPay.familyCPay(startTime, endTime);
                System.out.println(cost);
            default:
                System.out.println("You have entered a wrong family.");
        }
    }
}
