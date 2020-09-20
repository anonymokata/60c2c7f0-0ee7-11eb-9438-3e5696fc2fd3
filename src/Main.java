import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your start time (5 PM): ");
        String input = new String(scanner.nextLine());
        // Catching the time and splitting into integer and am/pm
        String[] startTimeEntered = input.split(" ");
        // Actual start hour - parse String one - returns
        // Parsing string into an int and if it equals pm we add 12
        // if not 0
        Integer startTime = Integer.parseInt(startTimeEntered[0])
                + (startTimeEntered[1].equalsIgnoreCase("PM") ? 12
                : 0);

        // End Time
        String[] endTimeEntered = input.split(" ");
        // Parsing String array into an int
        Integer endTime = Integer.parseInt(endTimeEntered[0])
                + (endTimeEntered[1].equalsIgnoreCase("PM") ? 12
                : 0);

//        Integer startingHour = new Integer(input.nextLine());
    }
}
