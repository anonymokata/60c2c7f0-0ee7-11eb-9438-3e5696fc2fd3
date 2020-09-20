

public class HoursWorked {

    public Boolean isStartValidTime(int startHour){
        return startHour >= 17;
        }

    public Boolean isValidEndTime(int endHour){
        return endHour <= 3;
    }

    public Boolean endTimeIsAfterStartTime(int startTime, int endTime) {
        // Handling 12am -4am since start time will be 17 or later
        if(endTime < 4) {
            endTime += + 24;
        }
        return startTime <= endTime;
        }

    public Boolean isTimeValid(int startTime, int endTime){
        // Checking for valid start time and a valid end time and end
        // time is after start time
        return isStartValidTime(startTime) && isValidEndTime(endTime)
                && endTimeIsAfterStartTime(startTime, endTime);
    }
}
