package Test;

import Main.LengthUnit;
import Main.QuantityLength;

public class QuantityMeasurementApp {

    public static boolean checkEquality(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        QuantityLength quantity1 =
                new QuantityLength(
                        value1,
                        unit1
                );

        QuantityLength quantity2 =
                new QuantityLength(
                        value2,
                        unit2
                );

        return quantity1.equals(quantity2);
    }

    public static void main(String[] args) {

        System.out.println(
                "1 Foot == 12 Inch : "
                        + checkEquality(
                        1.0,
                        LengthUnit.FEET,
                        12.0,
                        LengthUnit.INCH
                )
        );

        System.out.println(
                "1 Inch == 1 Inch : "
                        + checkEquality(
                        1.0,
                        LengthUnit.INCH,
                        1.0,
                        LengthUnit.INCH
                )
        );
    }
}