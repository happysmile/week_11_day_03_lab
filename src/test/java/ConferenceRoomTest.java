import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom redRoom;
    Guest niall;

    @Before
    public void before(){
        redRoom = new ConferenceRoom("Red", 50, 10);
        niall = new Guest("Niall", 45);
    }

    @Test
    public void hasName() {
        assertEquals("Red", redRoom.getRoomName());
    }

    @Test
    public void hasCapacity(){
        assertEquals(50, redRoom.getCapacity());
    }

    @Test
    public void hasRatePerHour(){
        assertEquals(10, redRoom.getRatePerHour());
    }


    @Test
    public void calculatesTotalBill(){
        assertEquals(40, redRoom.getBill(4), 0);
    }

    @Test
    public void hasGuests(){
        assertEquals(0, redRoom.getGuests().size());
    }

    @Test
    public void canAddGuest(){
        assertEquals(0, redRoom.getGuests().size());
        redRoom.addGuest(niall);
        assertEquals(1, redRoom.getGuests().size());
        assertEquals(true, redRoom.getGuests().contains(niall));
    }



}
