import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class FamilyPayRate {

    int dollars;

    FamilyPayRate(int dollars){
        this.dollars = dollars;
    }

    FamilyPayRate times(int multiplier){
        return new FamilyPayRate(dollars * multiplier);
    }

    public int familyAPay(Long startTime, Long endTime){
        int startHour = ZonedDateTime.ofInstant(Instant.ofEpochMilli(startTime),
                ZoneId.systemDefault()).getHour(); // Calculate start time
        long diff = ChronoUnit.HOURS.between(Instant.ofEpochMilli(startTime),
                Instant.ofEpochMilli(endTime)); // Total hours worked
        // Only calculate diff if hours are before 11
        int hoursBeforeEleven = (startHour >= 17 && startHour <= 23) ? (23 - startHour) : 0;
        int hoursAfterEleven = (int) diff - hoursBeforeEleven;
        return (hoursBeforeEleven * 15) + (hoursAfterEleven * 20);
    }

    public int familyBPay(Long startTime, Long endTime) {
        int startHour = ZonedDateTime.ofInstant(Instant.ofEpochMilli(startTime),
                ZoneId.systemDefault()).getHour(); // Calculate start time
        int endHour = ZonedDateTime.ofInstant(Instant.ofEpochMilli(endTime),
                ZoneId.systemDefault()).getHour();
        long diff = ChronoUnit.HOURS.between(Instant.ofEpochMilli(startTime),
                Instant.ofEpochMilli(endTime)); // Total hours worked
        int hoursBeforeTen = (startHour >= 17 && startHour <= 22) ? (22 - startHour) : 0;
        int hoursAfterMidnight = (endHour >= 0 && endHour <= 4) ? endHour : 0;
        int hoursBetweenTenAndMidnight = (int) diff - hoursBeforeTen - hoursAfterMidnight;
        return (hoursBeforeTen * 12) + (hoursBetweenTenAndMidnight * 8)
                + (hoursAfterMidnight * 16);
    }

    public int familyCPay(Long startTime, Long endTime){
        int startHour = ZonedDateTime.ofInstant(Instant.ofEpochMilli(startTime),
                ZoneId.systemDefault()).getHour(); // Calculate start time
        long diff = ChronoUnit.HOURS.between(Instant.ofEpochMilli(startTime),
                Instant.ofEpochMilli(endTime)); // Total hours worked
        int hoursBeforeNine = (startHour >= 17 && startHour <= 21) ? (21 - startHour) : 0;
        int hoursAfterNine = (int) diff - hoursBeforeNine;
        return (hoursBeforeNine * 21) + (hoursAfterNine * 15);
    }
}
