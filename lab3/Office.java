package lab3;

public class Office {
    private final static String Office_FORMAT_STRING = "%-3s %-15s %-5s %-5s";

    private int id;
    private String location;
    private double area;
    private int rooms;

    Office(){
        id = 0;
        location = "";
        area = 0;
        rooms = 0;
    }

    Office(int id, String location, double area, int rooms){
        this.id = id;
        this.location = location;
        this.area = area;
        this.rooms = rooms;
    }

    Office(Office office){
        id = office.id;
        location = office.location;
        area = office.area;
        rooms = office.rooms;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setArea(double area){
        this.area = area;
    }
    public void setRooms(int rooms){
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }
    public String getLocation() {
        return location;
    }
    public double getArea() {
        return area;
    }
    public int getRooms() {
        return rooms;
    }

    public String toString(){
        return String.format(Office_FORMAT_STRING, id, location, area, rooms);
    }
}

