import java.util.Scanner;

public class GameTesting {

    public static Building building = new Building("building", -10, 10, 2);
    public static int elevatorIndex;
    public static int editingElevatorIndex;
    public static int peopleQuantity = 2;
    public static double averageWeight = 150;
    public static StopWatch timer = new StopWatch();
    public static String[] nameBank = {
            "Sam", "John", "Bill", "Joe", "Steve", "Henry", "Rory", "James", "Kyle", "Chris",
            "Amanda", "Catherine", "Zoe", "Taylor", "Rose", "Francesca", "Jillian", "Anna", "Caitlyn", "Rebecca"};

    //<--------------------------------------------Exceptions--------------------------------------------------------->

    public static boolean isNotInt(String string) {
        if (string == null) {
            return true;
        } try {
            Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }

    public static boolean isNotDouble(String string) {
        if (string == null) {
            return true;
        } try {
            Double.parseDouble(string);
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }

    //<------------------------------------------Timer Methods-------------------------------------------------------->

    public static String elapsedTimeInMinutes(double time) {
        String total = "";
        int minutes = (int) (time / 60);
        int seconds = (int) (time % 60);
        total += (minutes + " minutes, " + seconds + " seconds");
        return total;
    }

    //<--------------------------------------Building Menu Methods---------------------------------------------------->

    public static void startMenu() {
        String choice;
        Scanner startMenuInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println("Welcome to CheckIn!");
        System.out.println();
        System.out.println("Start: Start Game");
        System.out.println();
        System.out.println("Settings: Change Game Settings");
        System.out.println("About: Read Game Objective and Instructions");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = startMenuInput.nextLine().toLowerCase();
        switch (choice) {
            case "start" -> {
                System.out.println("Timer Has Begun!");
                timer.start();
                mainMenu(building);
                startMenuInput.close();
            }
            case "settings" -> {
                System.out.println("Going to Settings Menu...");
                settingsMainMenu();
                startMenuInput.close();
            }
            case "about" -> {
                System.out.println("Going to About Menu...");
                aboutMenu();
                startMenuInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                startMenuInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                startMenu();
                startMenuInput.close();
            }
        }
    }

    public static void aboutMenu() {
        String choice;
        Scanner aboutMenuInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.println("Welcome to CheckIn! The object of the game is to use the two provided elevators " +
                "to transport each guest to their desired floor.");
        System.out.println();
        System.out.println("By default, the building will have 10 floors above ground and 10 floors below.");
        System.out.println("The only floor that these two elevators meet is at floor 0, where one goes to");
        System.out.println("above-ground, and the other goes to below-ground.");
        System.out.println();
        System.out.println("Keep in mind that each elevator has a specified max capacity and weight.");
        System.out.println("Once a person reaches their desired floor, they may be checked out.");
        System.out.println("The game can only be won when each person is checked out of the building. " +
                "There is a timer, so the aim is to complete this as fast as possible!");
        System.out.println("Good Luck!");
        System.out.println();
        System.out.println("Back: Go Back to Start Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = aboutMenuInput.nextLine().toLowerCase();
        switch (choice) {
        case "back" -> {
            timer.stop();
            System.out.println("Ending Game!");
            startMenu();
            aboutMenuInput.close();
        }
        case "done" -> {
            System.out.println("Have a nice day!");
            aboutMenuInput.close();
        }
        default -> {
            System.out.println("Error: Invalid Input");
            mainMenu(building);
            aboutMenuInput.close();
            }
        }
    }

    //<--------------------------------------Setting Menu Methods----------------------------------------------------->

    public static void settingsMainMenu() {
        String choice;
        Scanner settingsMenuInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println("Main Settings Menu");
        System.out.println();
        System.out.println("1: Elevator Settings");
        System.out.println();
        System.out.println("2: People Settings");
        System.out.println();
        System.out.println("Back: Go Back");
        System.out.println("Exit: Exit to Start Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = settingsMenuInput.nextLine().toLowerCase();
        switch (choice) {
            case "1" -> {
                System.out.println("Going to Elevator Settings...");
                elevatorSettings();
                settingsMenuInput.close();
            }
            case "2" -> {
                System.out.println("Going to People Settings...");
                peopleSettingsMenu();
                settingsMenuInput.close();
            }
            case "back" -> {
                System.out.println("Going Back...");
                elevatorSettings();
                settingsMenuInput.close();
            }
            case "exit" -> {
                System.out.println("Going Back to Start Menu...");
                startMenu();
                settingsMenuInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                settingsMenuInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                mainMenu(building);
                settingsMenuInput.close();
            }
        }
    }

    public static void elevatorSettings() {
        String choice;
        Scanner elevatorSettingsInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println("Replaceable Elevators List");
        System.out.println();
        for (int i = 0; i < building.getElevatorList().length; i++) {
            if (building.getElevatorList()[i] != null) {
                System.out.println((i + 1) + ": Editable");
            }
            System.out.println();
        }
        System.out.println("Back: Go Back");
        System.out.println("Exit: Exit to Start Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = elevatorSettingsInput.nextLine().toLowerCase();
        switch (choice) {
            case "1" -> {
                replaceElevatorMenu(0);
                editingElevatorIndex = 0;
                elevatorSettingsInput.close();
            }
            case "2" -> {
                replaceElevatorMenu(1);
                editingElevatorIndex = 1;
                elevatorSettingsInput.close();
            }
            case "back" -> {
                System.out.println("Going Back...");
                settingsMainMenu();
                elevatorSettingsInput.close();
            }
            case "exit" -> {
                System.out.println("Going Back to Start Menu...");
                startMenu();
                elevatorSettingsInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                elevatorSettingsInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                mainMenu(building);
                elevatorSettingsInput.close();
            }
        }
    }

    public static void replaceElevatorMenu(int elevator) {
        String currentFloorString, elevatorMinString, elevatorMaxString, elevatorWeightString;
        int elevatorMin = 0, elevatorMax = 1, currentFloor = 0;
        double elevatorWeight = 2400;

        Scanner replaceElevatorInput = new Scanner(System.in);
        for (int i = 0; i < 11; i++) {
            System.out.println();
            if (i == 5) {
                System.out.println("Renovations in Progress...");
            }
        }
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.println("Enter the lowest floor the elevator can reach " +
                "(Must be within " + building.getFloorMin() + " and " + building.getFloorMax() + "): ");
        elevatorMinString = replaceElevatorInput.nextLine();
        if (isNotInt(elevatorMinString)) {
            System.out.println("Error: Floor must be an integer value");
            System.out.println("Elevator replacement unsuccessful!");
            elevatorSettings();
        } else {
            elevatorMin = Integer.parseInt(elevatorMinString);
            if (elevatorMin < building.getFloorMin()) {
                System.out.println("Error: Floor is out of bounds of building");
                System.out.println("Elevator replacement unsuccessful!");
                elevatorSettings();
            } else {
                System.out.println("Enter the highest floor the elevator can reach " +
                        "(Must be between " + elevatorMin + " and " + building.getFloorMax() + "): ");
                elevatorMaxString = replaceElevatorInput.nextLine();
                if (isNotInt(elevatorMaxString)) {
                    System.out.println("Error: Floor must be an integer value");
                    System.out.println("Elevator replacement unsuccessful!");
                    elevatorSettings();
                } else {
                    elevatorMax = Integer.parseInt(elevatorMaxString);
                    if (elevatorMax > building.getFloorMax()) {
                        System.out.println("Error: Floor is out of bounds of building");
                        System.out.println("Elevator replacement unsuccessful!");
                        elevatorSettings();
                    } else {
                        System.out.println("Enter the elevator's current floor " +
                                "(Must be between " + elevatorMin + " and " + elevatorMax + "): ");
                        currentFloorString = replaceElevatorInput.nextLine();
                        if (isNotInt(currentFloorString)) {
                            System.out.println("Error: Floor must be an integer value");
                            System.out.println("Elevator replacement unsuccessful!");
                            elevatorSettings();
                        } else {
                            currentFloor = Integer.parseInt(currentFloorString);
                            if (currentFloor < elevatorMin || currentFloor > elevatorMax) {
                                System.out.println("Error: Floor is out of bounds of elevator");
                                System.out.println("Elevator replacement unsuccessful!");
                                elevatorSettings();
                            } else {
                                System.out.println("Enter the max weight of the elevator: ");
                                elevatorWeightString = replaceElevatorInput.nextLine();
                                if (isNotDouble(elevatorWeightString)) {
                                    System.out.println("Error: Weight must be a double");
                                    System.out.println("Elevator replacement unsuccessful!");
                                    elevatorSettings();
                                } else {
                                    elevatorWeight = Double.parseDouble(elevatorWeightString);
                                    if (elevatorWeight <= 0) {
                                        System.out.println("Error: Weight must a positive value");
                                        System.out.println("Elevator replacement unsuccessful!");
                                        elevatorSettings();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        building.getElevatorList()[elevator].setFloorMin(elevatorMin);
        building.getElevatorList()[elevator].setFloorMax(elevatorMax);
        building.getElevatorList()[elevator].setCurrentFloor(currentFloor);
        building.getElevatorList()[elevator].setMaxWeight(elevatorWeight);
        System.out.println("Elevator was successfully replaced!");
        settingsMainMenu();
        replaceElevatorInput.close();
    }

    public static void peopleSettingsMenu() {
        String choice;
        Scanner peopleSettingsInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println("People Settings Menu");
        System.out.println();
        System.out.println("1: Number of People");
        System.out.println();
        System.out.println("2: Average Weight");
        System.out.println();
        System.out.println("Back: Go Back");
        System.out.println("Exit: Exit to Start Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = peopleSettingsInput.nextLine().toLowerCase();
        switch (choice) {
            case "1" -> {
                peopleQuantityMenu();
                peopleSettingsInput.close();
            }
            case "2" -> {
                peopleWeightMenu();
                peopleSettingsInput.close();
            }
            case "back" -> {
                System.out.println("Going Back...");
                settingsMainMenu();
                peopleSettingsInput.close();
            }
            case "exit" -> {
                System.out.println("Going Back to Start Menu...");
                startMenu();
                peopleSettingsInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                peopleSettingsInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                mainMenu(building);
                peopleSettingsInput.close();
            }
        }
    }

    public static void peopleQuantityMenu() {
        String quantityString;
        int quantity = 2;
        Scanner peopleQuantityInput = new Scanner(System.in);
        for (int i = 0; i < 11; i++) {
            System.out.println();
            if (i == 5) {
                System.out.println("Renovations in Progress...");
            }
        }
        System.out.println("|-----------------------------------------------|");
        System.out.println("Enter number of people (1 - 10): ");
        quantityString = peopleQuantityInput.nextLine();
        if (isNotInt(quantityString)) {
            System.out.println("Error: Value must be an integer");
            System.out.println("Renovation unsuccessful!");
            peopleSettingsMenu();
        } else {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 1 || quantity > 10) {
                System.out.println("Error: Quantity must within bounds of building capacity");
                System.out.println("Renovation unsuccessful!");
                peopleSettingsMenu();
            }
        }
        building.setHeadCount(quantity);
        peopleQuantity = quantity;
        System.out.println("Renovation successful! Returning to Settings Menu...");

        for (int i = 0; i < peopleQuantity; i++) {
            Person temp = new Person(randomName(), randomWeight(), randomFloor(), randomFloor());
            building.getHeadCount()[i] = temp;
        }
        peopleSettingsMenu();
        peopleQuantityInput.close();
    }

    public static void peopleWeightMenu() {
        String choice;
        Scanner peopleQuantityInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println("People Weight Settings Menu");
        System.out.println();
        System.out.println("1: Light Weight (100 - 149 lbs)");
        System.out.println();
        System.out.println("2: Medium Weight (150 - 199 lbs)");
        System.out.println();
        System.out.println("3: Heavy Weight (200 - 250 lbs)");
        System.out.println();
        System.out.println("Back: Go Back");
        System.out.println("Exit: Exit to Start Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = peopleQuantityInput.nextLine().toLowerCase();
        switch (choice) {
            case "1" -> {
                averageWeight = 100;
                System.out.println("Setting successfully changed! Returning to Settings Menu...");
                settingsMainMenu();
                peopleQuantityInput.close();
            }
            case "2" -> {
                averageWeight = 150;
                System.out.println("Setting successfully changed! Returning to Settings Menu...");
                settingsMainMenu();
                peopleQuantityInput.close();
            }
            case "3" -> {
                averageWeight = 200;
                System.out.println("Setting successfully changed! Returning to Settings Menu...");
                settingsMainMenu();
                peopleQuantityInput.close();
            }
            case "back" -> {
                System.out.println("Going Back...");
                peopleSettingsMenu();
                peopleQuantityInput.close();
            }
            case "exit" -> {
                System.out.println("Going Back to Start Menu...");
                startMenu();
                peopleQuantityInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                peopleQuantityInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                peopleSettingsMenu();
                peopleQuantityInput.close();
            }
        }
    }

    public static void mainMenu(Building building) {
        String choice;
        Scanner mainMenuInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println("Welcome to " + building.getName() + "'s Building Menu!");
        System.out.println();
        System.out.println("Elevator: Inspect elevators");
        System.out.println();
        System.out.println("Diagram: View Building Diagram");
        System.out.println();
        System.out.println("Roster: Inspect people inside");
        System.out.println();
        System.out.println("Submit: Submit Log to check if game is won");
        System.out.println();
        System.out.println("Quit: Go to Start Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = mainMenuInput.nextLine().toLowerCase();
        switch (choice) {
            case "elevator" -> elevatorHub(building);
            case "diagram" -> {
                System.out.println("Drawing Diagram...");
                buildingDiagram(building);
            }
            case "roster" -> {
                System.out.println("Inspecting Building Population...");
                rosterMenu(building);
            }
            case "submit" -> {
                if (gameWon(building)) {
                    timer.stop();
                    System.out.println("Game Won!!!");
                    System.out.println("Elapsed Time was: " + (elapsedTimeInMinutes(timer.elapsed() * 0.000000001)));
                    System.out.println("Have a nice day!");

                } else {
                    System.out.println("Cannot submit work! People still checked in! Keep going!");
                    mainMenu(building);
                }
                mainMenuInput.close();
            }
            case "quit" -> {
                timer.stop();
                System.out.println("Ending Game!");
                startMenu();
                mainMenuInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                mainMenuInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                mainMenu(building);
                mainMenuInput.close();
            }
        }
    }

    public static void buildingDiagram(Building building) {
        String choice;
        Scanner buildingDiagramTwoCopyInput = new Scanner(System.in);
        System.out.println();
        for (int i = building.getFloorMax(); i >= building.getFloorMin(); i--) {

            //Top Floor
            if (i == building.getFloorMax()) {
                System.out.print("     #");
                if (i == building.getElevatorList()[0].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[0].getFloorMax()) {
                    System.out.print("v");
                } else {
                    System.out.print("|");
                }
                System.out.print("====");
                System.out.print(floorHeadCount(building, i));
                System.out.print("====");
                if (i == building.getElevatorList()[1].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[1].getFloorMax()) {
                    System.out.print("v");
                } else {
                    System.out.print("|");
                }
                System.out.print("#     \n");
            }

            //Above-Ground Floors
            else if ((i != building.getFloorMax()) && i > 0) {
                System.out.print("     I");
                if (i == building.getElevatorList()[0].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[0].getFloorMax()) {
                    System.out.print("v");
                } else if (i == building.getElevatorList()[0].getFloorMin()) {
                    System.out.print("^");
                } else {
                    System.out.print("|");
                }
                System.out.print("    ");
                System.out.print(floorHeadCount(building, i));
                System.out.print("    ");
                if (i == building.getElevatorList()[1].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[1].getFloorMax()) {
                    System.out.print("v");
                } else if (i == building.getElevatorList()[1].getFloorMin()) {
                    System.out.print("^");
                } else {
                    System.out.print("|");
                }
                System.out.print("I     \n");
            }

            //Ground Level
            else if (i == 0) {
                System.out.print("-----#");
                if (i == building.getElevatorList()[0].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[0].getFloorMax()) {
                    System.out.print("v");
                } else if (i == building.getElevatorList()[0].getFloorMin()) {
                    System.out.print("^");
                } else {
                    System.out.print("|");
                }
                System.out.print("----");
                System.out.print(floorHeadCount(building, i));
                System.out.print("----");
                if (i == building.getElevatorList()[1].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[1].getFloorMax()) {
                    System.out.print("v");
                } else if (i == building.getElevatorList()[1].getFloorMin()) {
                    System.out.print("^");
                } else {
                    System.out.print("|");
                }
                System.out.print("#-----\n");
            }

            //Underground floors
            else if ((i != building.getFloorMax()) && (i > building.getFloorMin()) && (i < 0)) {
                System.out.print("*****I");
                if (i == building.getElevatorList()[0].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[0].getFloorMax()) {
                    System.out.print("v");
                } else if (i == building.getElevatorList()[0].getFloorMin()) {
                    System.out.print("^");
                } else {
                    System.out.print("|");
                }
                System.out.print("    ");
                System.out.print(floorHeadCount(building, i));
                System.out.print("    ");
                if (i == building.getElevatorList()[1].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[1].getFloorMax()) {
                    System.out.print("v");
                } else if (i == building.getElevatorList()[1].getFloorMin()) {
                    System.out.print("^");
                } else {
                    System.out.print("|");
                }
                System.out.print("I*****\n");
            }

            //Bottom Floor
            else if (i == building.getFloorMin()) {
                System.out.print("*****#");
                if (i == building.getElevatorList()[0].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[0].getFloorMin()) {
                    System.out.print("^");
                } else {
                    System.out.print("|");
                }
                System.out.print("====");
                System.out.print(floorHeadCount(building, i));
                System.out.print("====");
                if (i == building.getElevatorList()[1].getFloor()) {
                    System.out.print("E");
                } else if (i == building.getElevatorList()[1].getFloorMin()) {
                    System.out.print("^");
                } else {
                    System.out.print("|");
                }
                System.out.print("#*****\n");
            }
        }

        System.out.println("**********************");
        System.out.println();
        System.out.println("Back: Go Back to Main Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = buildingDiagramTwoCopyInput.nextLine().toLowerCase();
        switch (choice) {
            case "back" -> {
                System.out.println("Going Back...");
                mainMenu(building);
                buildingDiagramTwoCopyInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                buildingDiagramTwoCopyInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                buildingDiagram(building);
                buildingDiagramTwoCopyInput.close();
            }
        }
    }

    public static int floorHeadCount(Building building, int i) {
        int count = 0;
        for (int j = 0; j < building.getHeadCount().length; j++) {
            if (building.getHeadCount()[j].getLocation() == i) {
                count++;
            }
        }
        return count;
    }

    //<--------------------------------------Elevator Menu Methods---------------------------------------------------->

    public static void elevatorHub(Building building) {
        String choice;
        Scanner viewElevatorInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println("Viewing Elevator...");
        System.out.println();
        System.out.println("1: Constructed (Floor " + building.getElevatorList()[0].getFloorMin() + " -> " +
                building.getElevatorList()[0].getFloorMax() + ") ");
        System.out.println();
        System.out.println("2: Constructed (Floor " + building.getElevatorList()[1].getFloorMin() + " -> " +
                building.getElevatorList()[1].getFloorMax() + ") ");
        System.out.println();
        System.out.println("Back: Go Back");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = viewElevatorInput.nextLine().toLowerCase();
        switch (choice) {
            case "1" -> {
                elevatorIndex = 0;
                display(building.getElevatorList()[0]);
                viewElevatorInput.close();
            }
            case "2" -> {
                elevatorIndex = 1;
                display(building.getElevatorList()[1]);
                viewElevatorInput.close();
            }
            case "back" -> {
                System.out.println("Going Back...");
                mainMenu(building);
                viewElevatorInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                viewElevatorInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                elevatorHub(building);
                viewElevatorInput.close();
            }
        }
    }

    public static void display(Elevator elevator) {
        String choice;
        Scanner displayInput = new Scanner(System.in);
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.println("+-----+");
        System.out.println("|     |");
        System.out.print("|  ");
        if (elevator.getCurrentCapacity() == 0) {
            System.out.print(" ");
        } else {
            System.out.print(elevator.getCurrentCapacity());
        }
        System.out.print("  |" + '\n');
        System.out.println("|     |");
        System.out.println("+-----+");
        System.out.println();
        System.out.println("Current Floor: " + elevator.getFloor());
        System.out.println("Max Weight Capacity: " + elevator.getMaxWeight());
        System.out.println("Current Weight: " + elevator.getCurrentWeight());
        System.out.println("Current Capacity: " + elevator.getCurrentCapacity());
        System.out.println();
        System.out.println("Load: Add people from elevator");
        System.out.println("Dispense: Subtract people from elevator");
        System.out.println("Move: Move elevator to a different floor");
        System.out.println();
        System.out.println("Back: Go Back");
        System.out.println("Exit: Exit to Main Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = displayInput.nextLine().toLowerCase();
        switch (choice) {
            case "load" -> {
                System.out.println("Going to Load Menu..");
                loadPeople(building.getElevatorList()[elevatorIndex]);
                displayInput.close();
            }
            case "dispense" -> {
                System.out.println("Going to Dispense Menu..");
                dispensePeople(building.getElevatorList()[elevatorIndex]);
                displayInput.close();
            }
            case "move" -> {
                System.out.println("Going to Elevator Move Menu...");
                moveElevator(building.getElevatorList()[elevatorIndex]);
                displayInput.close();
            }
            case "back" -> {
                System.out.println("Going Back...");
                elevatorHub(building);
                displayInput.close();
            }
            case "exit" -> {
                System.out.println("Exiting to Main Menu...");
                mainMenu(building);
                displayInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                displayInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                display(building.getElevatorList()[elevatorIndex]);
                displayInput.close();
            }
        }
    }

    public static void moveElevator(Elevator elevator) {
        int newFloor;
        Scanner moveElevatorInput = new Scanner(System.in);
        System.out.println("Desired Floor for Elevator: ");

        String newFloorString = moveElevatorInput.nextLine();

        if (isNotInt(newFloorString)) {
            System.out.println("Error: Floor must be an integer");
        } else {
            newFloor = Integer.parseInt(newFloorString);
            if (newFloor > building.getElevatorList()[elevatorIndex].getFloorMax() ||
                    newFloor < building.getElevatorList()[elevatorIndex].getFloorMin()) {
                System.out.println("Error: Floor must be in bounds of the elevator");
            } else {
                elevator.setCurrentFloor(newFloor);
                System.out.println("Elevator Successfully moved to floor " + newFloor);
            }
        }
        System.out.println();
        System.out.println("Returning to Display Elevator Menu...");
        display(building.getElevatorList()[elevatorIndex]);
        moveElevatorInput.close();
    }

    //<--------------------------------------Elevator Person Methods-------------------------------------------------->

    public static void loadPeople(Elevator elevator) {
        String choice;
        Scanner stockPeopleInput = new Scanner(System.in);

        System.out.println("|-----------------------------------------------|");
        System.out.println();

        for (int i = 0; i < building.getHeadCount().length; i++) {
            if ((building.getHeadCount()[i] != null) &&
                    (building.getHeadCount()[i].getLocation() == elevator.getFloor()) &&
                    (!building.getHeadCount()[i].getElevatorStatus())) {
                System.out.println((i + 1) + ": " + building.getHeadCount()[i].getName() + " going to floor "
                        + building.getHeadCount()[i].getDestination());
            } else {
                System.out.println((i + 1) + ": ");
            }
            System.out.println();
        }

        System.out.println("Back: Go Back");
        System.out.println("Exit: Exit to Main Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = stockPeopleInput.nextLine().toLowerCase();
        switch (choice) {
            case "1" -> {
                if (building.getHeadCount()[0] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[0].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[0]);
                        building.getHeadCount()[0].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "2" -> {
                if (building.getHeadCount()[1] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[1].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[1]);
                        building.getHeadCount()[1].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "3" -> {
                if (building.getHeadCount()[2] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[2].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[2]);
                        building.getHeadCount()[2].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "4" -> {
                if (building.getHeadCount()[3] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[3].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[3]);
                        building.getHeadCount()[3].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "5" -> {
                if (building.getHeadCount()[4] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[4].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[4]);
                        building.getHeadCount()[4].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "6" -> {
                if (building.getHeadCount()[5] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[5].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[5]);
                        building.getHeadCount()[5].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "7" -> {
                if (building.getHeadCount()[6] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[6].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[6]);
                        building.getHeadCount()[6].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "8" -> {
                if (building.getHeadCount()[7] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[7].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[7]);
                        building.getHeadCount()[7].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "9" -> {
                if (building.getHeadCount()[8] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[8].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[8]);
                        building.getHeadCount()[8].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "10" -> {
                if (building.getHeadCount()[9] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    if (building.getHeadCount()[9].getLocation() == elevator.getFloor()) {
                        elevator.addPerson(building.getHeadCount()[9]);
                        building.getHeadCount()[9].inElevator();
                    }
                }
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "back" -> {
                System.out.println("Going Back...");
                display(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
            case "exit" -> {
                System.out.println("Exiting to Main Menu...");
                mainMenu(building);
                stockPeopleInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                stockPeopleInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input!");
                loadPeople(building.getElevatorList()[elevatorIndex]);
                stockPeopleInput.close();
            }
        }
    }

    public static void dispensePeople(Elevator elevator) {
        String choice;
        Scanner dispensePeopleInput = new Scanner(System.in);

        System.out.println("|-----------------------------------------------|");
        System.out.println();
        for (int i = 0; i < elevator.getElevatorPopulation().length; i++) {
            if (elevator.getElevatorPopulation()[i] != null) {
                System.out.println((i + 1) + ": " + elevator.getElevatorPopulation()[i].getName() +
                        " going to floor " + elevator.getElevatorPopulation()[i].getDestination());
            } else {
                System.out.println((i + 1) + ": empty");
            }
            System.out.println();
        }
        System.out.println("Back: Go Back");
        System.out.println("Exit: Exit to Main Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = dispensePeopleInput.nextLine().toLowerCase();
        switch (choice) {
            case "1" -> {
                if (elevator.getElevatorPopulation()[0] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    elevator.getElevatorPopulation()[0].outElevator();
                    elevator.subtractPerson(elevator.getElevatorPopulation()[0]);
                }
                display(building.getElevatorList()[elevatorIndex]);
                dispensePeopleInput.close();
            }
            case "2" -> {
                if (elevator.getElevatorPopulation()[1] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    elevator.getElevatorPopulation()[1].outElevator();
                    elevator.subtractPerson(elevator.getElevatorPopulation()[1]);
                }
                display(building.getElevatorList()[elevatorIndex]);
                dispensePeopleInput.close();
            }
            case "3" -> {
                if (elevator.getElevatorPopulation()[2] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    elevator.getElevatorPopulation()[2].outElevator();
                    elevator.subtractPerson(elevator.getElevatorPopulation()[2]);
                }
                display(building.getElevatorList()[elevatorIndex]);
                dispensePeopleInput.close();
            }
            case "4" -> {
                if (elevator.getElevatorPopulation()[3] == null) {
                    System.out.println("Error: Invalid Input");
                } else {
                    elevator.getElevatorPopulation()[3].outElevator();
                    elevator.subtractPerson(elevator.getElevatorPopulation()[3]);
                }
                display(building.getElevatorList()[elevatorIndex]);
                dispensePeopleInput.close();
            }
            case "back" -> {
                System.out.println("Going Back...");
                display(building.getElevatorList()[elevatorIndex]);
                dispensePeopleInput.close();
            }
            case "exit" -> {
                System.out.println("Exiting to Main Menu...");
                mainMenu(building);
                dispensePeopleInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                dispensePeopleInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input!");
                display(building.getElevatorList()[elevatorIndex]);
                dispensePeopleInput.close();
            }
        }
    }

    //<-----------------------------------------Person Methods-------------------------------------------------------->

    public static void rosterMenu(Building building) {
        String choice;
        Scanner rosterMenuInput = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < peopleQuantity; i++) {
            if (building.getHeadCount()[i] != null) {
                count++;
            }
        }
        System.out.println("|-----------------------------------------------|");
        System.out.println("Building Roster");
        System.out.println();
        for (int i = 0; i < building.getHeadCount().length; i++) {
            if (building.getHeadCount()[i] != null) {
                System.out.println(building.getHeadCount()[i].getName() + ": " +
                        building.getHeadCount()[i].getLocation() + " -> " +
                        building.getHeadCount()[i].getDestination());
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Current Capacity: " + count + "/10");
        System.out.println();
        System.out.println("Check Out: Remove a person from the building");
        System.out.println();
        System.out.println("Back: Exit to Main Menu");
        System.out.println("Done: Finish Running Code");
        System.out.println("|-----------------------------------------------|");

        choice = rosterMenuInput.nextLine().toLowerCase();
        switch (choice) {
            case "check out" -> {
                System.out.println("Going to Check-In Menu...");
                removePerson(building);
                rosterMenuInput.close();
            }
            case "back" -> {
                System.out.println("Going Back to Main Menu...");
                mainMenu(building);
                rosterMenuInput.close();
            }
            case "done" -> {
                System.out.println("Have a nice day!");
                rosterMenuInput.close();
            }
            default -> {
                System.out.println("Error: Invalid Input");
                rosterMenu(building);
                rosterMenuInput.close();
            }
        }
    }

    public static void removePerson(Building building) {
        String name, nameLowerCase;
        Scanner removePersonInput = new Scanner(System.in);

        for (int i = 0; i < 11; i++) {
            System.out.println();
            if (i == 5) {
                System.out.println("Check-out In Progress...");
            }
        }
        System.out.println("|-----------------------------------------------|");
        System.out.println("Enter a new Person's name: ");

        name = removePersonInput.nextLine();
        nameLowerCase = name.toLowerCase();

        for (int i = 0; i < building.getHeadCount().length; i++) {
            if (building.getHeadCount()[i] == null) {
                continue;
            } if (nameLowerCase.equals(building.getHeadCount()[i].getName().toLowerCase())) {
                if (canCheckOut(building.getHeadCount()[i])) {
                    building.getHeadCount()[i] = null;
                    System.out.println(name + " was successfully checked-out!");
                    System.out.println("Returning to Population Menu...");
                    rosterMenu(building);
                    removePersonInput.close();
                    return;
                } else {
                    System.out.println("Error: " + name + " cannot be checked-out!");
                    System.out.println("Returning to Roster Menu...");
                    rosterMenu(building);
                    removePersonInput.close();
                }
            }
        }
        System.out.println(name + " is not in this building's population!");
        System.out.println("Returning to Roster Menu...");
        rosterMenu(building);
        removePersonInput.close();
    }

    //<--------------------------------------------Game Logic--------------------------------------------------------->

    public static boolean gameWon(Building building) {
        int count = 0;
        for (int i = 0; i < building.getHeadCount().length; i++) {
            if (building.getHeadCount()[i] == null) {
                count++;
            }
        }
        return (count == building.getHeadCount().length);
    }

    public static String randomName() {
        int randomNumber = (int) ((Math.random() * 100) % 20);
        String name = nameBank[randomNumber];
        while (name == null) {
            randomNumber = (int) ((Math.random() * 100) % 20);
            name = nameBank[randomNumber];
        }
        nameBank[randomNumber] = null;
        return name;
    }

    public static boolean isSatisfied(Person person) {
        return person.getLocation() == person.getDestination();
    }

    public static boolean canCheckOut(Person person) {
        return isSatisfied(person);
    }

    public static int randomFloor() {
        return (int) (((Math.random() * 100) % (building.getFloorMax() - building.getFloorMin()))
                + building.getFloorMin());
    }

    public static double randomWeight() {
        return ((Math.random() * 1000 % 50) + averageWeight);
    }

    //<----------------------------------------------Main------------------------------------------------------------->

    public static void main(String[] args) {
        building.getElevatorList()[0] = new Elevator(-5, -10, 0, 1000);
        building.getElevatorList()[1] = new Elevator(5, 0, 10, 1000);

        for (int i = 0; i < 2; i++) {
            Person temp = new Person(randomName(), randomWeight(), randomFloor(), randomFloor());
            building.getHeadCount()[i] = temp;
        }
        startMenu();
    }
}
