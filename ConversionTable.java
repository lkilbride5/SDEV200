public class ConversionTable {

    public static void main(String[] args) {
        printConversionTable();
    }

    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void printConversionTable() {
        System.out.println("Feet\tMeters\t|\tMeters\tFeet");
        System.out.println("---------------------------------------");

        for (int i = 1; i <= 10; i++) {
            double feet = i;
            double meters = footToMeter(feet);
            double fixedMeters = 20.0 + 5.0 * (i - 1); // Adjust the third column values
            System.out.printf("%.2f\t%.3f\t|\t%.2f\t%.2f%n", feet, meters, fixedMeters, meterToFoot(fixedMeters));
        }
    }
}
