package Main;

import Main.LengthUnit;
import Main.QuantityLength;
public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        double result =
                QuantityLength.convert(
                        value,
                        fromUnit,
                        toUnit
                );

        System.out.println(
                value + " " + fromUnit +
                        " = " +
                        result + " " +
                        toUnit
        );
    }

    public static void demonstrateLengthConversion(
            QuantityLength quantity,
            LengthUnit targetUnit) {

        QuantityLength converted =
                quantity.convertTo(targetUnit);

        System.out.println(
                quantity +
                        " = " +
                        converted
        );
    }

    public static void demonstrateLengthEquality(
            QuantityLength length1,
            QuantityLength length2) {

        System.out.println(
                "Equal : "
                        + length1.equals(length2)
        );
    }

    public static void demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        QuantityLength q1 =
                new QuantityLength(
                        value1,
                        unit1
                );

        QuantityLength q2 =
                new QuantityLength(
                        value2,
                        unit2
                );

        demonstrateLengthEquality(
                q1,
                q2
        );
    }

    public static void main(String[] args) {

        demonstrateLengthConversion(
                1.0,
                LengthUnit.FEET,
                LengthUnit.INCH
        );

        demonstrateLengthConversion(
                3.0,
                LengthUnit.YARDS,
                LengthUnit.FEET
        );

        demonstrateLengthConversion(
                36.0,
                LengthUnit.INCH,
                LengthUnit.YARDS
        );

        demonstrateLengthConversion(
                1.0,
                LengthUnit.CENTIMETER,
                LengthUnit.INCH
        );

        QuantityLength length =
                new QuantityLength(
                        2.0,
                        LengthUnit.YARDS
                );

        demonstrateLengthConversion(
                length,
                LengthUnit.INCH
        );
    }
}