import java.io.IOException;
import java.util.Scanner;

public class Race extends Statistics {
    public int r_id;
    public int racePts;
    public String venue;
    public Driver[] d = new Driver[2]; // a race can be raced by 2 drivers for a team only
    public Car c;
    String raceData;

    public Race() {
        this.r_id = Ferrari.countRace;
        Ferrari.countRace += 1;
    }

    public Race(Driver d1, Driver d2, String venue, Car c, int res1, int res2) throws IOException {
        this.d[0] = d1;
        this.d[1] = d2;
        this.venue = venue;
        this.r_id = Ferrari.countRace;
        this.c = c;
        this.d[0].result[this.r_id] = res1;
        this.d[1].result[this.r_id] = res2;
        this.d[0].earnings += getPrize(res1);
        this.d[1].earnings += getPrize(res2);
        Ferrari.budget += 1.25 * (getPrize(res1) + getPrize(res2));
        this.checkPodium();
        this.d[0].points += getPoints(res1);
        this.d[1].points += getPoints(res2);
        // d1.points += getPoints(res1);
        // d2.points += getPoints(res2);
        this.racePts = getPoints(res1) + getPoints(res2);
        Ferrari.teamPts += this.racePts;
        Ferrari.countRace += 1;
        this.raceData = "[" + this.r_id + "], " + this.venue + ", " + this.c.name + ", \n" + this.d[0].name + "(" + this.d[0].result[r_id] + ", "
                + getPoints(this.d[0].result[r_id]) + ")\n" + this.d[1].name + "(" + this.d[1].result[r_id] + ", "
                + getPoints(this.d[1].result[r_id]) + ")\n" + this.racePts + ", $"
                + (1.25 * (getPrize(this.d[0].result[this.r_id]) + getPrize(this.d[1].result[this.r_id]))) + "\n\n";
        Ferrari.setFile(this.raceData, "Races.txt");
    }

    public void setRaceData() throws IOException {
        Scanner sc = new Scanner(System.in);
        int d1, d2, c1, res1, res2;
        System.out.print("Race venue: ");
        this.venue = sc.nextLine();
        System.out.println("Select drivers: ");
        Ferrari.viewDrivers();
        System.out.println("[Choices] : ");
        d1 = sc.nextInt();
        d2 = sc.nextInt();
        this.d[0] = Ferrari.drivers[d1];
        this.d[1] = Ferrari.drivers[d2];
        System.out.print("Select cars: ");
        Ferrari.viewCars();
        System.out.print("[Choice] : ");
        c1 = sc.nextInt();
        this.c = Ferrari.cars[c1];
        System.out.println("Enter team result [driver1, driver2]: ");
        res1 = sc.nextInt();
        res2 = sc.nextInt();
        this.d[0].result[this.r_id] = res1;
        this.d[1].result[this.r_id] = res2;
        this.d[0].result[this.r_id] = res1;
        this.d[1].result[this.r_id] = res2;
        this.d[0].earnings += getPrize(res1);
        this.d[1].earnings += getPrize(res2);
        Ferrari.budget += 1.25 * (getPrize(res1) + getPrize(res2));
        this.checkPodium();
        this.d[0].points += getPoints(res1);
        this.d[1].points += getPoints(res2);
        this.racePts = getPoints(res1) + getPoints(res2);
        // Ferrari.drivers[d1].points += getPoints(res1);
        // Ferrari.drivers[d2].points += getPoints(res2);
        Ferrari.teamPts += this.racePts;
        Ferrari.countRace += 1;
        this.raceData = "[" + this.r_id + "], " + this.venue + ", " + this.c.name + ", \n" + this.d[0].name + "(" + this.d[0].result[r_id] + ", "
                + getPoints(this.d[0].result[r_id]) + ")\n" + this.d[1].name + "(" + this.d[1].result[r_id] + ", "
                + getPoints(this.d[1].result[r_id]) + ")\n" + this.racePts + ", $"
                + (1.25 * (getPrize(this.d[0].result[this.r_id]) + getPrize(this.d[1].result[this.r_id]))) + "\n\n";
        Ferrari.setFile(this.raceData, "Races.txt");
    }

    public void checkPodium() {
        for (int i = 0; i < 2; i++) {
            if (this.d[i].result[this.r_id] <= 3) {
                Ferrari.podiums += 1;
                if (this.d[i].result[this.r_id] == 1) {
                    Ferrari.wins += 1;
                }
            }
        }
    }

    public void getRaceData() {
        System.out.println("Race venue: " + this.venue);
        System.out.println("Car used: " + this.c.name);
        System.out.print("Classification");
        System.out.print(" (Name, Position, Points)\n");
        for (int i = 0; i < 2; i++)
            System.out
                    .println(this.d[i].name + ", " + this.d[i].result[r_id] + ", " + getPoints(this.d[i].result[r_id]));
        System.out.println("Team Result: " + this.racePts + " pts");
        System.out.println("Team Earnings: $"
                + (1.25 * (getPrize(this.d[0].result[this.r_id]) + getPrize(this.d[1].result[this.r_id]))));
    }
}
