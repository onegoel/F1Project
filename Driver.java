import java.io.IOException;
import java.util.Scanner;

public class Driver extends Ferrari {
    public boolean eligible; // to check for eligibility for driver to enter F1 world championship
    public double earnings;
    public int[] result = new int[100];
    String driverData;

    public Driver() {
        this.d_id = countDriver;
        this.points = 0;
        Ferrari.countDriver += 1;
        this.earnings += 5000000;
        Ferrari.budget -= 5000000; // each driver costs 5000000
    }

    public Driver(String name, int age, String country, int exp) throws IOException {
        this.name = name;
        this.d_id = countDriver;
        this.age = age;
        this.country = country;
        this.points = 0;
        this.exp = exp;
        this.eligible = isEligible();
        Ferrari.countDriver += 1;
        this.earnings += 5000000;
        Ferrari.budget -= 5000000; // each driver costs 5000000
    }

    public void setInfo() { // creates a driver
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = sc.nextLine();
        System.out.print("Age (yrs): ");
        this.age = sc.nextInt();
        System.out.print("Country: ");
        this.country = sc.next();
        System.out.print("Experience (yrs): ");
        this.exp = sc.nextInt();
        System.out.println("Checking driver eligibility...");
        this.eligible = isEligible();
        this.points = 0;
    }

    public void dispInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Driver ID: " + this.d_id);
        System.out.println("Age (min 18 yrs): " + this.age);
        System.out.println("Country: " + this.country);
        System.out.println("Experience (min 3 yrs): " + this.exp + " yrs");
        System.out.println("Season Points: " + this.points);
        System.out.println("Earnings: $" + this.earnings);
    }

    private boolean isEligible() {
        if (this.age < 18) // use of ArithmeticException
            throw new ArithmeticException("Driver must be at least 18 years old to be eligible.");
        try { // use of custom exception customExc
            if (this.exp < 3)
                throw new customExc("Driver must have at least 3 years of experience.");
        } catch (customExc e) {
            System.out.println(e);
        }
        return true;
    }

    public void logFile() {
        this.driverData = this.name + ", " + this.d_id + ", " + this.age + ", " + this.country + ", " + this.exp + ", "
                + this.points + ", $" + this.earnings + "\n";
        try {
            Ferrari.setFile(this.driverData, "Drivers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
