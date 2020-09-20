

public class FamilyPayRate {

    int dollars;

    FamilyPayRate(int dollars){
        this.dollars = dollars;
    }

    FamilyPayRate times(int multiplier){
        return new FamilyPayRate(dollars * multiplier);
    }

    public int familyAPay(int startTime, int endTime){
        int difference = endTime + ((endTime <= 4) ? 24 : 0) - startTime; // Total Hours Worked
        // Only calculate diff if hours are before 11
        int hoursBeforeEleven = (startTime >= 17 && startTime <= 23) ? (23 - startTime) : 0;
        int hoursAfterEleven = difference - hoursBeforeEleven;
        return (hoursBeforeEleven * 15) + (hoursAfterEleven * 20);
    }

    public int familyBPay(int startTime, int endTime) {
        // Calculate difference
        int difference = endTime + ((endTime <= 4) ? 24 : 0) - startTime;

        int hoursBeforeTen = (startTime >= 17 && startTime <= 22) ? (22 - startTime) : 0;
        int hoursAfterMidnight = (endTime >= 0 && endTime <= 4) ? endTime : 0;
        int hoursBetweenTenAndMidnight = difference - hoursBeforeTen - hoursAfterMidnight;
        return (hoursBeforeTen * 12) + (hoursBetweenTenAndMidnight * 8)
                + (hoursAfterMidnight * 16);
    }

    public int familyCPay(int startTime, int endTime){
        int difference = endTime + ((endTime <= 4) ? 24 : 0) - startTime;
        int hoursBeforeNine = (startTime >= 17 && startTime <= 21) ? (21 - startTime) : 0;
        int hoursAfterNine = difference - hoursBeforeNine;
        return (hoursBeforeNine * 21) + (hoursAfterNine * 15);
    }
}
