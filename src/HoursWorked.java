import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class HoursWorked {

    public Boolean isStartValidTime(int startHour){
        return startHour >= 17;
        }

    public Boolean isValidEndTime(Long timeInMillis){
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(timeInMillis),
                ZoneId.systemDefault()).minusMinutes(1).getHour() <= 3;
    }

    public Boolean endTimeIsAfterStartTime(Long startTime, Long endTime) {
        return startTime <= endTime;
        }

    public Boolean isTimeValid(Long startTime, Long endTime){
        return isStartValidTime(startTime) && isValidEndTime(endTime)
                && endTimeIsAfterStartTime(startTime, endTime);
    }
}
