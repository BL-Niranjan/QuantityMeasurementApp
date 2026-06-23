package Main;

public class QuantityMeasurementApp {

    public static void demonstrateAddition(
            QuantityLength first,
            QuantityLength second,
            LengthUnit targetUnit) {

        QuantityLength result =
                QuantityLength.add(
                        first,
                        second,
                        targetUnit
                );

        System.out.println(
                first +
                        " + " +
                        second +
                        " = " +
                        result
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
                ),
                LengthUnit.FEET
        );

        demonstrateAddition(
                new QuantityLength(
                        1,
                        LengthUnit.FEET
                ),
                new QuantityLength(
                        12,
                        LengthUnit.INCH
                ),
                LengthUnit.INCH
        );

        demonstrateAddition(
                new QuantityLength(
                        1,
                        LengthUnit.FEET
                ),
                new QuantityLength(
                        12,
                        LengthUnit.INCH
                ),
                LengthUnit.YARDS
        );

        demonstrateAddition(
                new QuantityLength(
                        36,
                        LengthUnit.INCH
                ),
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                ),
                LengthUnit.FEET
        );
    }
}