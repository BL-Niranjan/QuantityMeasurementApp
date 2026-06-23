package Main;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength oneFoot =
                new QuantityLength(
                        1,
                        LengthUnit.FEET
                );

        QuantityLength twelveInches =
                new QuantityLength(
                        12,
                        LengthUnit.INCHES
                );

        QuantityLength oneYard =
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                );

        QuantityLength centimeters =
                new QuantityLength(
                        2.54,
                        LengthUnit.CENTIMETERS
                );

        System.out.println(
                oneFoot.convertTo(
                        LengthUnit.INCHES
                )
        );

        System.out.println(
                oneFoot.add(
                        twelveInches,
                        LengthUnit.FEET
                )
        );

        System.out.println(
                twelveInches.equals(
                        oneYard
                )
        );

        System.out.println(
                oneYard.add(
                        new QuantityLength(
                                3,
                                LengthUnit.FEET
                        ),
                        LengthUnit.YARDS
                )
        );

        System.out.println(
                centimeters.convertTo(
                        LengthUnit.INCHES
                )
        );

        System.out.println(
                LengthUnit.INCHES
                        .convertToBaseUnit(12)
        );
    }
}