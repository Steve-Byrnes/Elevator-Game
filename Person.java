public class Person {

    private String name;
    private double weight;
    private int location;
    private int destination;
    private boolean elevatorStatus;

    public Person(String name, double weight, int location, int destination) {
        this.name = name;
        this.weight = weight;
        this.location = location;
        this.destination = destination;
    }

    public String getName() {
        if (this == null) {
            return "*";
        } else {
            return this.name;
        }
    }
    public double getWeight() {
        return this.weight;
    }

    public int getLocation() {
        return this.location;
    }
    public int getDestination() {
        return this.destination;
    }
    public boolean getElevatorStatus() {
        return this.elevatorStatus;
    }
    public void inElevator() {
        this.elevatorStatus = true;
    }
    public void outElevator() {
        this.elevatorStatus = false;
    }

    public void setLocation(int newLocation) {
        this.location = newLocation;
    }
}
