

public class HoursWorked {

    public Boolean isStartValidTime(int startHour){
        return startHour >= 17;
        }

    public Boolean isValidEndTime(int endHour){
        return endHour <= 3;
    }

    public Boolean endTimeIsAfterStartTime(int startTime, int endTime) {
        if(endTime < 4) {
            endTime += + 24;
        }
        return startTime <= endTime;
        }

    public Boolean isTimeValid(int startTime, int endTime){
        return isStartValidTime(startTime) && isValidEndTime(endTime)
                && endTimeIsAfterStartTime(startTime, endTime);
    }
}
