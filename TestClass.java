import java.io.IOException;
import java.util.Scanner;

public class TestClass extends Ferrari {
    public static void main(String[] args) throws IOException {
        int opt;
        drivers[countDriver] = new Driver("Charles Leclerc", 23, "Monaco", 5);
        drivers[countDriver] = new Driver("Carlos Sainz", 27, "Spain", 8);
        cars[countCar] = new Car("SF21 Modena", 5, 752);
        cars[countCar] = new Car("SF21 Milano", 7, 756);
        cars[countCar] = new Car("SF21 Torino", 6, 760);
        races[countRace] = new Race(drivers[0], drivers[1], "Bahrain", cars[2], 6, 8);
        races[countRace] = new Race(drivers[0], drivers[1], "Florence", cars[0], 4, 5);
        races[countRace] = new Race(drivers[0], drivers[1], "Portimao", cars[1], 6, 11);
        races[countRace] = new Race(drivers[0], drivers[1], "Barcelona", cars[2], 4, 7);
        races[countRace] = new Race(drivers[0], drivers[1], "Monaco", cars[0], 20, 2);
        races[countRace] = new Race(drivers[0], drivers[1], "Baku", cars[1], 4, 8);
        races[countRace] = new Race(drivers[0], drivers[1], "France", cars[2], 16, 11);
        races[countRace] = new Race(drivers[0], drivers[1], "Styria", cars[0], 7, 6);
        races[countRace] = new Race(drivers[0], drivers[1], "Austria", cars[1], 5, 8);
        races[countRace] = new Race(drivers[0], drivers[1], "Silverstone", cars[2], 2, 6);

        System.out.println("\n\nThis is JGarage. Created by Aryan Goel & Ayush Malik.");
        System.out.println("Welcome to Scuderia Ferrari Formula One team.\n\n");
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("              MAIN MENU");
            System.out.println("[1] Team Profile [2] Driver Menu [3] Race Menu [4] Car Menu [5] Stats Menu [6] Exit");
            System.out.print("[Choice] : ");
            opt = sc.nextInt();
            if (opt == 1)
                Ferrari.teamProfile();
            else if (opt == 2)
                driverMenu();
            else if (opt == 3)
                raceMenu();
            else if (opt == 4)
                carMenu();
            else if (opt == 5)
                statsMenu();
            else if (opt == 6) {
                for (int i = 0; i < countDriver; i++) {
                    drivers[i].logFile();
                }
                System.exit(1);
            }
        }

    }

    static void driverMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        int opt, sel;
        while (true) {
            System.out.println("              DRIVER MENU");
            System.out.println(
                    "[1] View Driver List [2] Create Driver [3] View Driver Info [4] Read Drivers.txt [5] Exit");
            System.out.print("[Choice] : ");
            opt = sc.nextInt();
            if (opt == 1)
                Ferrari.viewDrivers();
            else if (opt == 2) {
                drivers[countDriver] = new Driver();
                drivers[countDriver - 1].setInfo();
            } else if (opt == 3) {
                System.out.println("\nSelect driver to view - \n");
                Ferrari.viewDrivers();
                System.out.print("[Select] : ");
                sel = sc.nextInt();
                drivers[sel].dispInfo();
            } else if (opt == 4)
                getFile("Drivers", "Drivers.txt");
            else if (opt == 5)
                break;
        }
    }

    static void raceMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        int opt, sel;
        while (true) {
            System.out.println("              RACE MENU");
            System.out.println("[1] View Race List [2] Enter Race Data [3] View Race Data [4] Read Races.txt [5] Exit");
            System.out.print("[Choice] : ");
            opt = sc.nextInt();
            if (opt == 1)
                Ferrari.viewRaces();
            else if (opt == 2) {
                races[countRace] = new Race();
                races[countRace - 1].setRaceData();
            } else if (opt == 3) {
                System.out.println("\nSelect race to view - \n");
                Ferrari.viewRaces();
                System.out.print("[Select] : ");
                sel = sc.nextInt();
                races[sel].getRaceData();
            } else if (opt == 4)
                getFile("Races", "Races.txt");
            else if (opt == 5)
                break;
        }
    }

    static void carMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        int opt, sel;
        while (true) {
            System.out.println("              CAR MENU");
            System.out.println(
                    "[1] View Cars List [2] Enter Car Setting [3] View Car Setting [4] Read Cars.txt [5] Exit");
            System.out.print("[Choice] : ");
            opt = sc.nextInt();
            if (opt == 1)
                Ferrari.viewCars();
            else if (opt == 2) {
                cars[countCar] = new Car();
                cars[countCar - 1].setInfo();
            } else if (opt == 3) {
                System.out.println("\nSelect race to view - \n");
                Ferrari.viewCars();
                System.out.print("[Select] : ");
                sel = sc.nextInt();
                cars[sel].dispInfo();
            } else if (opt == 4)
                getFile("Cars", "Cars.txt");
            else if (opt == 5)
                break;
        }
    }

    static void statsMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        int opt;
        while (true) {
            System.out.println("              STATS MENU");
            System.out.println("[1] Sort Races by Points [2] Find Fastest Car [3] Exit");
            System.out.print("[Choice] : ");
            opt = sc.nextInt();
            if (opt == 1)
                Statistics.sortByResult();
            else if (opt == 2)
                Statistics.carTest();
            else if(opt == 3)
                break;
        }
    }

    void setInfo() {
    }

    void dispInfo() {
    }

}
