import com.sun.jndi.ldap.Ber;

import java.util.ArrayList;

public class Hotel {
    String name;
    ArrayList<Bedroom> bedrooms;
    ArrayList<ConferenceRoom> conferenceRooms;
    int till;

    public Hotel(String name) {
        this.name = name;
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.till = till;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }


    public void addBedroom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }

    public Bedroom findBedroom(Bedroom bedroom) {
        if(this.bedrooms.contains(bedroom)){
            return bedroom;
        } else {
            return null;
        }
    }

    public ConferenceRoom findConferenceRoom(ConferenceRoom conferenceRoom) {
        if(this.conferenceRooms.contains(conferenceRoom)){
            return conferenceRoom;
        } else {
            return null;
        }
    }

    public int getTill() {
        return this.till;
    }

    public void checkInGuestToBedroom(Bedroom bedroom, Guest guest, int nights){
        int bill = bedroom.getBill(nights);
        Bedroom foundBedroom = this.findBedroom(bedroom);
        if( this.hasGuestEnoughMoney(bill, guest) && (foundBedroom!= null) && (bedroom.isRoomAvailable()) && (bedroom.isGuestIn(guest) == false) ){
            bedroom.addGuest(guest);
            guest.payMoney(bill);
            this.getPaid(bill);
        }
    }

    public void checkOutGuestFromBedroom(Bedroom bedroom, Guest guest){
       if(bedroom.isGuestIn(guest)) {
           bedroom.removeGuest(guest);
       }
    }

    public void checkInGuestToConferenceRoom(ConferenceRoom conferenceRoom, Guest guest, int hours){
        int bill = conferenceRoom.getBill(hours);
        ConferenceRoom foundConferenceRoom = this.findConferenceRoom(conferenceRoom);
        if( this.hasGuestEnoughMoney(bill, guest) && ( foundConferenceRoom != null ) && (conferenceRoom.isRoomAvailable()) && (conferenceRoom.isGuestIn(guest) == false) ) {
            conferenceRoom.addGuest(guest);
            guest.payMoney(bill);
            this.getPaid(bill);
        }
    }

    public void checkOutGuestFromConferenceRoom(ConferenceRoom conferenceRoom, Guest guest){
        if(conferenceRoom.isGuestIn(guest)) {
            conferenceRoom.removeGuest(guest);
        }
    }


    public void getPaid(int money){
        this.till = this.till + money;
    }

    public boolean hasGuestEnoughMoney(int bill, Guest guest){
        if (guest.getMoney() < bill){
            return false;
        } else {
            return true;
        }
    }



}
