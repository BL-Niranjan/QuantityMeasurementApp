package Main;

import Main.LengthUnit;
import Main.QuantityLength;
public class QuantityMeasurementApp {

    public static void demonstrateAddition(
            QuantityLength first,
            QuantityLength second) {

        QuantityLength result =
                first.add(second);

        System.out.println(
                first + " + "
                        + second
                        + " = "
                        + result
        );
    }

    public static void main(String[] args) {

        demonstrateAddition(
                new QuantityLength(
                        1,
                        LengthUnit.FEET
                ),
                new QuantityLength(
                        12,
                        LengthUnit.INCH
                )
        );

        demonstrateAddition(
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                ),
                new QuantityLength(
                        3,
                        LengthUnit.FEET
                )
        );

        demonstrateAddition(
                new QuantityLength(
                        2.54,
                        LengthUnit.CENTIMETER
                ),
                new QuantityLength(
                        1,
                        LengthUnit.INCH
                )
        );
    }
}