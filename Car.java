import java.util.Scanner;
import java.io.*;

public class Car extends Ferrari implements iCar {
    String carData;

    public Car() {
        this.c_id = countCar;
        Ferrari.countCar += 1;
    }

    public Car(String name, double gforce, double weight) throws IOException {
        this.name = name;
        this.c_id = countCar;
        this.gforce = gforce;
        this.weight = weight;
        this.speed = this.getSpeed();
        this.dforce = gforce * weight;
        Ferrari.countCar += 1;
        Ferrari.budget -= 50000000; // 50 mil per car
        this.carData = this.c_id + ", " + this.name + ", " + this.color + ", " + this.engine + ", " + this.speed + ", "
                + this.weight + ", " + this.dforce + "\n";
        Ferrari.setFile(this.carData, "Cars.txt");
    }

    public double getSpeed() {
        double s = 359.7;
        if (this.weight >= 752 && this.weight < 759) {
            if (this.gforce == 6)
                s -= 10;
            else if (this.gforce == 7)
                s -= 16;
            else if (this.gforce == 8)
                s -= 22;
        } else if (this.weight >= 759 && this.weight < 766) {
            if (this.gforce == 6)
                s -= 28;
            else if (this.gforce == 7)
                s -= 34;
            else if (this.gforce == 8)
                s -= 40;
        } else
            s -= 50;
        return s;
    }

    public void setInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Model (name): ");
        this.name = sc.nextLine();
        System.out.print("Weight (min 752kg, max 766kg): ");
        this.weight = sc.nextDouble();
        System.out.print("Set g-force (5-8): ");
        this.gforce = sc.nextDouble();
        System.out.println("Computing car setting...");
        try {
            if (this.weight < 752 || this.weight > 766 || (this.gforce < 5 || this.gforce > 8)) {
                sc.close();
                throw new customExc("Invalid car setting.");
            }
        } catch (customExc e) {
            System.out.println(e);
        }
        this.dforce = this.gforce * this.weight;
        this.speed = getSpeed();
        System.out.println("Note: Apex speed of the car is determined by downforce (= g-force x weight).");
        this.carData = this.c_id + ", " + this.name + ", " + this.color + ", " + this.engine + ", " + this.speed + ", "
                + this.weight + ", " + this.dforce + "\n";
        try {
            Ferrari.setFile(this.carData, "Cars.txt");
        } catch (IOException e) {
            System.out.println("File missing.");
        }
    }

    public void dispInfo() {
        System.out.println("Car ID: " + this.c_id);
        System.out.println("Model (name): " + this.name);
        System.out.println("Color: " + this.color);
        System.out.println("Engine: " + this.engine);
        System.out.println("Speed: " + this.speed + " kmh");
        System.out.println("Weight: " + this.weight + " kg");
        System.out.println("Downforce: " + this.dforce + " kg-force");
    }

}
