package Main;

import Main.LengthUnit;
import Main.QuantityLength;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength yard =
                new QuantityLength(
                        1.0,
                        LengthUnit.YARDS
                );

        QuantityLength feet =
                new QuantityLength(
                        3.0,
                        LengthUnit.FEET
                );

        QuantityLength inch =
                new QuantityLength(
                        36.0,
                        LengthUnit.INCH
                );

        QuantityLength cm =
                new QuantityLength(
                        1.0,
                        LengthUnit.CENTIMETER
                );

        QuantityLength inchEquivalent =
                new QuantityLength(
                        0.393701,
                        LengthUnit.INCH
                );

        System.out.println(
                "1 Yard == 3 Feet : "
                        + yard.equals(feet)
        );

        System.out.println(
                "1 Yard == 36 Inches : "
                        + yard.equals(inch)
        );

        System.out.println(
                "1 CM == 0.393701 Inch : "
                        + cm.equals(inchEquivalent)
        );
    }
}