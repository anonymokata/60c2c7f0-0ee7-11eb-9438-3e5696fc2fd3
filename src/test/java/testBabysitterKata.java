import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testBabysitterKata {

    @Test
    public void payBabysitterForOneHourOfWorkFromFamilyA(){
        FamilyPayRate fifteen = new FamilyPayRate(15);
        fifteen.times(1);
        assertEquals(15, fifteen.dollars);
    }

    @Test
    public void returnDollarAmountWithMultipleHoursOfBabysitting(){
        FamilyPayRate fifteen = new FamilyPayRate(15);
        FamilyPayRate total = fifteen.times(2);
        assertEquals(30, total.dollars);
        total = fifteen.times(3);
        assertEquals(45, total.dollars);
    }

    @Test
    public void returnPayAmountForElevenToFourAM(){
        FamilyPayRate twenty = new FamilyPayRate(20);
        twenty.times(1);
        assertEquals(20, twenty.dollars);
    }

    @Test
    public void isValidTimeTest(){
        HoursWorked hoursWorked = new HoursWorked();
        assertFalse(hoursWorked.isStartValidTime(15)); // 3:00PM
        assertTrue(hoursWorked.isStartValidTime(18)); // 6:00pm
        assertTrue(hoursWorked.isStartValidTime(20)); // 8:00pm
        assertTrue(hoursWorked.isValidEndTime(1)); // 1:00am
        assertFalse(hoursWorked.isValidEndTime(5)); // 5:00am
        assertTrue(hoursWorked.endTimeIsAfterStartTime(17, 2)); // // 5pm, 2am
        assertTrue(hoursWorked.isTimeValid(17, 2)); // 5pm - 2am
    }

    @Test
    public void familyAPayTest(){
        FamilyPayRate familyAPayRate = new FamilyPayRate(15);
        assertEquals(110, familyAPayRate.familyAPay(17,24)); // 5pm - 12am
        assertEquals(50, familyAPayRate.familyAPay(17,21)); // 5pm - 11pm
    }

    @Test
    public void familyCPayTest(){
        FamilyPayRate familyCPayRate = new FamilyPayRate(21);
        assertEquals(129, familyCPayRate.familyCPay(17, 24)); // 5 - 9, 9 - 12
        assertEquals(147, familyCPayRate.familyCPay(19, 4)); // 7 - 9, 9 - 4
    }

    @Test
    public void familyBPayTest() {
        FamilyPayRate familyBPayRate = new FamilyPayRate(12);
        assertEquals(140, familyBPayRate.familyBPay(17,4)); // 5:00pm - 4am
        assertEquals(68, familyBPayRate.familyBPay(17,23)); // 5pm - 11pm
    }
}
