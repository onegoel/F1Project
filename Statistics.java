public class Statistics implements iStats {
    final double minPrize = 25000;

    public int getPoints(int pos) {
        int x = 0;
        if (pos == 1)
            x = 25;
        else if (pos == 2)
            x = 18;
        else if (pos == 3)
            x = 15;
        else if (pos == 4)
            x = 12;
        else if (pos == 5)
            x = 10;
        else if (pos == 6)
            x = 8;
        else if (pos == 7)
            x = 6;
        else if (pos == 8)
            x = 4;
        else if (pos == 9)
            x = 2;
        else if (pos == 10)
            x = 1;
        return x;
    }

    public static void sortByResult() { // this method will sort all races by team result ie. by teamPts
        Race[] r = Ferrari.races;
        int min;
        int n = Ferrari.countRace;
        Race temp;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (r[min].racePts < r[j].racePts)
                    min = j;
            }
            temp = r[min];
            r[min] = r[i];
            r[i] = temp;
        }
        System.out.println("Classification of race results by team points - ");
        for (int i = 0; i < n; i++)
            System.out.println(r[i].venue + " GP (" + r[i].racePts + ")");
    }

    public static void carTest() {
        Car[] c = Ferrari.cars;
        Car temp;
        int n = Ferrari.countCar;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (c[j].speed < c[j + 1].speed) {
                    temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }

        System.out.println("Classification of cars by speed -");
        for (int i = 0; i < n; i++)
            System.out.println(c[i].name + ", " + c[i].speed + " kmph");
        System.out.println("Fastest car is - " + c[0].name + " (" + c[0].speed + ")");
    }

    public double getPrize(int res) {
        double prize = 0;
        for (int i = 10; i > 0; i--) {
            if (i == res)
                break;
            else
                prize += 100000;
        }
        return prize + minPrize;
    }
}
