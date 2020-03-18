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

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public void setBedrooms(ArrayList<Bedroom> bedrooms) {
        this.bedrooms = bedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void setConferenceRooms(ArrayList<ConferenceRoom> conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }

    public int getTill() {
        return this.till;
    }

    public void setTill(int till) {
        this.till = till;
    }

    public void checkInGuestToBedroom(Bedroom bedroom, Guest guest, int nights){
        int bill = bedroom.getBill(nights);
        if( this.hasGuestEnoughMoney(bill, guest) && (bedroom.placesInRoom()>0) && (bedroom.isGuestIn(guest) == false) ){
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
        if( this.hasGuestEnoughMoney(bill, guest) && (conferenceRoom.placesInRoom()>0) && (conferenceRoom.isGuestIn(guest) == false) ) {
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
