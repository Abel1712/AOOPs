import java.util.Scanner;

public class UnitConverter {

    // Conversion rates
    private static final double METER_TO_KILOMETER = 0.001;
    private static final double KG_TO_POUND = 2.20462;
    private static final double POUND_TO_KG = 1 / KG_TO_POUND;
    private static final double LITER_TO_MILLILITER = 1000.0;

    public static double convertLength(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase("meter") && toUnit.equalsIgnoreCase("kilometer")) {
            return value * METER_TO_KILOMETER;
        } else if (fromUnit.equalsIgnoreCase("kilometer") && toUnit.equalsIgnoreCase("meter")) {
            return value / METER_TO_KILOMETER;
        } else {
            throw new IllegalArgumentException("Unsupported length units.");
        }
    }

    public static double convertWeight(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase("kg") && toUnit.equalsIgnoreCase("pound")) {
            return value * KG_TO_POUND;
        } else if (fromUnit.equalsIgnoreCase("pound") && toUnit.equalsIgnoreCase("kg")) {
            return value * POUND_TO_KG;
        } else {
            throw new IllegalArgumentException("Unsupported weight units.");
        }
    }

    public static double convertVolume(double value, String fromUnit, String toUnit) {
        if (fromUnit.equalsIgnoreCase("liter") && toUnit.equalsIgnoreCase("milliliter")) {
            return value * LITER_TO_MILLILITER;
        } else if (fromUnit.equalsIgnoreCase("milliliter") && toUnit.equalsIgnoreCase("liter")) {
            return value / LITER_TO_MILLILITER;
        } else {
            throw new IllegalArgumentException("Unsupported volume units.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unit Converter");
        System.out.println("Choose conversion type: 1) Length 2) Weight 3) Volume");
        int choice = scanner.nextInt();
        
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();
        
        System.out.print("Enter from unit: ");
        String fromUnit = scanner.next();
        
        System.out.print("Enter to unit: ");
        String toUnit = scanner.next();

        double result = 0;
        try {
            switch (choice) {
                case 1:
                    result = convertLength(value, fromUnit, toUnit);
                    break;
                case 2:
                    result = convertWeight(value, fromUnit, toUnit);
                    break;
                case 3:
                    result = convertVolume(value, fromUnit, toUnit);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    scanner.close();
                    return;
            }
            System.out.printf("Converted value: %.2f %s\n", result, toUnit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
