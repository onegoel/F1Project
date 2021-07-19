
/**
 * A simple program to - manage the Scuderia Ferrari F1 racing team. track
 * Scuderia Ferrari's 2021 Formula 1 season.
 * 
 */

import java.io.*;

public abstract class Ferrari {
    public int exp, age, points;
    public int d_id, c_id;
    public double speed, dforce, gforce, weight;
    public String name, country;
    final public String engine = "SF90 Turbo";
    public static int countCar = 0;
    public static int countDriver = 0;
    public static int countRace = 0;
    public static int podiums = 0;
    public static int wins = 0;
    public static double budget = 300000000; // 300 mil
    public static int teamPts = 0;
    public static String sponsor;
    final public String color = "Red, White, Black";
    final public int year = 2021;

    abstract void setInfo() throws IOException;

    abstract void dispInfo();

    public static Driver[] drivers = new Driver[5];
    public static Race[] races = new Race[23];
    public static Car[] cars = new Car[4];

    class customExc extends Exception {
        customExc(String c) {
            super(c);
        }
    }

    public static void teamProfile() {
        System.out.println("\t\tSCUDERIA FERRARI - 2021 TEAM PROFILE");
        System.out.println("Base: Maranello, Italy");
        System.out.println("Budget(remainder): $" + budget);
        System.out.println("Drivers: " + countDriver);
        System.out.println("Cars: " + countCar);
        System.out.println("Races: " + countRace);
        System.out.println("Podiums: " + podiums);
        System.out.println("Wins: " + wins);
        System.out.println("Points: " + teamPts);
    }

    public static void viewDrivers() {
        System.out.println("(ID, Name, Country)");
        for (int i = 0; i < countDriver; i++) {
            System.out.println("[" + drivers[i].d_id + "], " + drivers[i].name + ", " + drivers[i].country);
        }
        System.out.println();
    }

    public static void viewCars() {
        System.out.println("(ID, Model, Apex Speed)");
        for (int i = 0; i < countCar; i++) {
            System.out.println("[" + cars[i].c_id + "], " + cars[i].name + ", " + cars[i].speed);
        }
        System.out.println();
    }

    public static void viewRaces() {
        System.out.println("(ID, Venue, Result(P1, P2))");
        for (int i = 0; i < countRace; i++) {
            System.out.println("[" + races[i].r_id + "], " + races[i].venue + ", ("
                    + races[i].d[0].result[races[i].r_id] + ", " + races[i].d[1].result[races[i].r_id] + ")");
        }
        System.out.println();
    }

    public static void setFile(String data, String file) throws IOException {
        int flag = 0;
        String str;
        byte[] dataInfo = data.getBytes();
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((str = br.readLine()) != null) {
            if (str.equals(data))
                flag = 1;
        }
        br.close();
        if (flag != 1) {
            FileOutputStream fo = new FileOutputStream(file, true);
            fo.write(dataInfo);
            fo.close();
        }
    }

    public static void getFile(String mem, String file) throws IOException {
        int i = 0;
        FileInputStream fi = new FileInputStream(file);
        System.out.println("Fetching " + mem + " data from file...\n");
        while ((i = fi.read()) != -1) {
            System.out.print((char) i);
        }
        fi.close();
    }
}
