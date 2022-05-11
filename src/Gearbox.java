import java.util.ArrayList;
import java.util.List;

public class Gearbox {
    private List<Gear> gears;
    private int maxGears;
    private int currentGear;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        gears = new ArrayList<>();
        currentGear = 0;
        clutchIsIn = false;

        for(int i = 0; i < maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }

    public void operateClutch(boolean in) {
        clutchIsIn = in;
    }

    public void changeGear(int gearNumber) {
        if(gearNumber >= 0 && gearNumber < maxGears && clutchIsIn) {

            if(gearNumber == currentGear) {
                System.out.println("Gear has already been at number " + currentGear);
                return;
            }
            currentGear = gearNumber;
            System.out.println("Gear " + gearNumber + " selected");
        } else {
            System.out.println("Grind!");
            currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if(clutchIsIn) {
            System.out.println("Scream!");
            return 0.0;
        }

        //return revs * gears.get(currentGear).getRatio();
        return gears.get(currentGear).driveSpeed(revs);
    }

    private void addGear(int number, double ratio) {
        if(number >= 0 || number < maxGears) {
            gears.add(new Gear(number, ratio));
        }
    }

    public class Gear {
        private int number;
        private double ratio;

        public Gear(int number, double ratio) {
            this.number = number;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs) {
            return revs * ratio;
        }
    }
}
