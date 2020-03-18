import java.util.ArrayList;

public class ConferenceRoom {

    private String name;
    private int capacity;
    private int ratePerHour;
    private ArrayList<Guest> guests;

    public ConferenceRoom(String name, int capacity, int ratePerHour) {
        this.name = name;
        this.capacity = capacity;
        this.ratePerHour = ratePerHour;
        this.guests = new ArrayList<Guest>();
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }


    public int getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(int ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomName() {
        return this.name;
    }

    public void setRoomName(String roomName) {
        this.name = roomName;
    }

    public int getBill(int numberOfHours){
        return numberOfHours * this.ratePerHour;
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

    public boolean isRoomAvailable(){
        if(this.guests.size() == 0){
            return true;
        } else {
            return false;
        }
    }


}
