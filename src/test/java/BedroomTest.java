import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom room1;
    Guest niall;
    Guest steve;

    @Before
    public void before(){
        niall = new Guest("Niall", 35);
        steve = new Guest("Steve", 80);
        room1 = new Bedroom(1, 2, 20, "double");
    }

    @Test
    public void hasRoomNumber(){
        assertEquals(1, room1.getRoomNumber());
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, room1.getCapacity());
    }

    @Test
    public void hasRatePerNight(){
        assertEquals(20, room1.getRatePerNight());
    }

    @Test
    public void hasType(){
        assertEquals("double", room1.getType());
    }

    @Test
    public void calculatesTotalBill(){
        assertEquals(40, room1.getBill(2), 0);
    }

    @Test
    public void hasGuests(){
       assertEquals(0, room1.getGuests().size());
    }

    @Test
    public void canAddGuest(){
        assertEquals(0, room1.getGuests().size());
        room1.addGuest(niall);
        assertEquals(1, room1.getGuests().size());
        assertEquals(true, room1.getGuests().contains(niall));
    }

    @Test
    public void canRemoveGuest(){
        assertEquals(0, room1.getGuests().size());
        room1.addGuest(niall);
        room1.addGuest(steve);
        assertEquals(2, room1.getGuests().size());
        room1.removeGuest(steve);
        assertEquals(1, room1.getGuests().size());
        assertEquals(true, room1.getGuests().contains(niall));
    }

    @Test
    public void checksIfGuestIn(){
        room1.addGuest(niall);
        assertEquals(true, room1.isGuestIn(niall));
        assertEquals(false, room1.isGuestIn(steve));
    }

    @Test
    public void checksIfAvailable(){
        System.out.println(room1.getGuests());
        System.out.println(room1.getGuests().size());
        assertEquals(true, room1.isRoomAvailable());
        room1.addGuest(steve);
        assertEquals(false, room1.isRoomAvailable());
    }

}
