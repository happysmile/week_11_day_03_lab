import java.util.ArrayList;

public class Bedroom {

    private int roomNumber;
    private int capacity;
    private int ratePerNight;
    private String type;
    private ArrayList<Guest> guests;

    public Bedroom(int roomNumber, int capacity, int ratePerNight, String type) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.ratePerNight = ratePerNight;
        this.type = type;
        this.guests = new ArrayList<Guest>();
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRatePerNight() {
        return this.ratePerNight;
    }

    public void setRatePerNight(int ratePerNight) {
        this.ratePerNight = ratePerNight;
    }


    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBill(int numberOfNights){
        return numberOfNights * this.ratePerNight;
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void removeGuest(Guest guest){
        this.guests.remove(this.guests.indexOf(guest));
    }

    public boolean isGuestIn(Guest guest){
        if(this.guests.contains(guest)){
            return true;
        } else {
            return false;
        }
    }

    public int placesInRoom(){
        return this.capacity - this.guests.size();
    }

}
