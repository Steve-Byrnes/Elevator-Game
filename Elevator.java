public class Elevator {

    private int floor;
    private int floorMax;
    private int floorMin;
    private int direction;
    private double maxWeight;
    private double currentWeight;
    private int currentCapacity;
    private Person[] elevatorPopulation;

    public Elevator() {
        this.floor = 0;
        this.direction = 0;
        this.maxWeight = 2400;
        this.currentWeight = 0;
        this.currentCapacity = 0;
        this.elevatorPopulation = new Person[4];

    }
    public Elevator(int floor, int floorMin, int floorMax, double maxWeight) {
        this.floor = floor;
        this.floorMin = floorMin;
        this.floorMax = floorMax;
        this.direction = 0;
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.currentCapacity = 0;
        this.elevatorPopulation = new Person[4];
    }

    public boolean up() {
        if (this.direction != 1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean down() {
        if (this.direction != -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean still() {
        if (this.direction != 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getFloor() {
        return this.floor;
    }
    public int getDirection() {
        return this.direction;
    }
    public double getMaxWeight() {
        return this.maxWeight;
    }
    public double getCurrentWeight() {
        return this.currentWeight;
    }
    public int getCurrentCapacity() {
        return this.currentCapacity;
    }
    public int getFloorMax() {
        return this.floorMax;
    }
    public int getFloorMin() {
        return this.floorMin;
    }
    public Person[] getElevatorPopulation() {
        return this.elevatorPopulation;
    }

    public void setCurrentFloor(int floor) {
        this.floor = floor;
    }
    public void setFloorMax(int floor) {
        this.floorMax = floor;
    }
    public void setFloorMin(int floor) {
        this.floorMin = floor;
    }
    public void setMaxWeight(double weight) {
        this.maxWeight = weight;
    }

    public void setDirection(int direction) {
            if (direction < 0) {
                this.direction = -1;
            } else if (direction > 0) {
                this.direction = 1;
            } else {
                this.direction = 0;
            }
    }
    public void addPerson(Person person) {
        for (int i = 0; i < this.elevatorPopulation.length; i++) {
            if (this.elevatorPopulation[i] == null) {
                if (person.getWeight() + this.currentWeight <= this.maxWeight) {
                    this.elevatorPopulation[i] = person;
                    this.currentWeight += person.getWeight();
                    this.currentCapacity += 1;
                    System.out.println(person.getName() + " successfully added to elevator!");
                } else {
                    System.out.println(person.getName() + " cannot be added to elevator; will go over max capacity!");
                }
                System.out.println();
                return;
            }
        }
        System.out.println(person.getName() + " cannot be added to this elevator; too many people!");
    }
    public void subtractPerson(Person person) {
        for (int i = 0; i < this.elevatorPopulation.length; i++) {
            if (this.elevatorPopulation[i] == null) {
                continue;
            } else {
                if (person.getName() == this.elevatorPopulation[i].getName()) {
                    person.setLocation(this.floor);
                    this.currentWeight -= person.getWeight();
                    this.currentCapacity -= 1;
                    this.elevatorPopulation[i] = null;
                    System.out.println(person.getName() + " successfully removed from elevator!");
                    System.out.println();
                    break;
                } else {
                    System.out.println(person.getName() + " is not on this elevator!");
                    System.out.println();
                }
            }
        }
    }
}
