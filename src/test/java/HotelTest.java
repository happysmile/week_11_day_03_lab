import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotelDelLuna;
    Guest niall;
    Guest steve;
    Bedroom room1;
    ConferenceRoom redRoom;

    @Before
    public void before(){
        hotelDelLuna = new Hotel("Hotel Del Luna");
        niall = new Guest("Niall", 35);
        steve = new Guest("Steve", 80);
        room1 = new Bedroom(1, 2, 20, "double");
        redRoom = new ConferenceRoom("Red", 50, 10);
    }

    @Test
    public void hasName(){
        assertEquals("Hotel Del Luna", hotelDelLuna.getName());
    }

    @Test
    public void canAddGuestToRooms(){

    }

    @Test
    public void canRemoveGuestsFromRooms(){

    }




}
