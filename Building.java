
public class Building {

    private String name;
    private int floorMin;
    private int floorMax;
    private Person[] headCount;
    private Elevator[] elevatorList;

    public Building() {
        this.name = " ";
        this.floorMin = 0;
        this.floorMax = 1;
        this.headCount = new Person[2];
        this.elevatorList = new Elevator[1];
    }

    public Building(String name, int floorMin, int floorMax, int headCount) {
        this.name = name;
        this.floorMin = floorMin;
        this.floorMax = floorMax;
        this.headCount = new Person[headCount];
        this.elevatorList = new Elevator[2];
    }

    public String getName() {
        if (this == null) {
            return "*";
        } else {
            return this.name;
        }
    }
    public int getFloorMin() {
        return this.floorMin;
    }
    public int getFloorMax() {
        return this.floorMax;
    }
    public Elevator[] getElevatorList() {
        return this.elevatorList;
    }
    public Person[] getHeadCount() {
        return this.headCount;
    }

    public void setFloorMin(int min) {
        this.floorMin = min;
    }
    public void setFloorMax(int max) {
        this.floorMax = max;
    }
    public void changeName(String name) {
        this.name = name;
    }
    public void setHeadCount(int quantity) {
        headCount = new Person[quantity];
    }

    public void checkOut(Person person) {
        for (int i = 0; i < this.headCount.length; i++) {
            if (person.getName().equals(this.getHeadCount()[i].getName())) {
                this.getHeadCount()[i] = null;
            } else {
                System.out.println(this.getName() + " is not currently in this building");
            }
        }
    }

    public void checkIn(Person person) {
        for (int i = 0; i < this.headCount.length; i++) {
            if (this.getHeadCount()[i] == null) {
                person = this.getHeadCount()[i];
                return;
            }
        }
        System.out.println("Building is currently at capacity");
    }

}
