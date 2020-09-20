import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertFalse(hoursWorked.isStartValidTime(1595165495000L)); // 08:31am
        assertTrue(hoursWorked.isStartValidTime(1595196000000L)); // 5:00pm
        assertTrue(hoursWorked.isStartValidTime(1595203200000L)); // 7:00pm
        assertTrue(hoursWorked.isValidEndTime(1595149200000L)); // 4:00am
        assertFalse(hoursWorked.isValidEndTime(1595149260000L)); // 4:01am
        assertTrue(hoursWorked.endTimeIsAfterStartTime(1595152800000L, 1595235600000L));
        assertTrue(hoursWorked.isTimeValid(1595203200000L, 1595228400000L));
    }

    @Test
    public void familyAPayTest(){
        FamilyPayRate familyAPayRate = new FamilyPayRate(15);
        assertEquals(110, familyAPayRate.familyAPay(1595196000000L,1595221200000L));
        assertEquals(80, familyAPayRate.familyAPay(1595221200000L, 1595235600000L));
    }

    @Test
    public void familyCPayTest(){
        FamilyPayRate familyCPayRate = new FamilyPayRate(21);
        assertEquals(129, familyCPayRate.familyCPay(1595196000000L, 1595221200000L)); // 5 - 9, 9 - 12
        assertEquals(147, familyCPayRate.familyCPay(1595203200000L, 1595235600000L)); // 7 - 9, 9 - 4
    }

    @Test
    public void familyBPayTest() {
        FamilyPayRate familyBPayRate = new FamilyPayRate(12);
        assertEquals(140, familyBPayRate.familyBPay(1595196000000L,1595235600000L)); // 5:00pm - 4am
        assertEquals(68, familyBPayRate.familyBPay(1595196000000L, 1595217600000L)); // 5pm - 11pm
    }
}