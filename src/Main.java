public class Main {
    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(7);
        Gearbox.Gear first = mcLaren.new Gear(8, 4.7);
        System.out.println(first.driveSpeed(3400));
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(4000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(4);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(4000));
    }
}
