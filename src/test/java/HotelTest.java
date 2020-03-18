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
    public void canAddRooms(){
        assertEquals(0, hotelDelLuna.getBedrooms().size());
        hotelDelLuna.addBedroom(room1);
        assertEquals(1, hotelDelLuna.getBedrooms().size());
    }


    @Test
    public void canAddGuestToRooms(){
        hotelDelLuna.addBedroom(room1);
        assertEquals(false, room1.isGuestIn(steve));
        assertEquals(80, steve.getMoney());
        assertEquals(0, hotelDelLuna.getTill());
        hotelDelLuna.checkInGuestToBedroom(room1, steve, 2);
        assertEquals(true, room1.isGuestIn(steve));
        assertEquals(40, steve.getMoney());
        assertEquals(40, hotelDelLuna.getTill());
        hotelDelLuna.checkInGuestToBedroom(room1, niall, 2);
        assertEquals(false, room1.isGuestIn(niall));
    }

    @Test
    public void canRemoveGuestsFromRooms(){
        hotelDelLuna.addBedroom(room1);
        hotelDelLuna.checkInGuestToBedroom(room1, steve, 2);
        assertEquals(true, room1.isGuestIn(steve));
        hotelDelLuna.checkOutGuestFromBedroom(room1, steve);
        assertEquals(false, room1.isGuestIn(steve));
    }




}
